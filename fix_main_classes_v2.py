"""
Bulk-fixes TWO problems across a Java practice repo:

  1. Every file declaring `class Main` (causes bin/Main.class to overwrite
     across files, so Run always runs the "wrong" file).
  2. Files whose class name contains characters that are ILLEGAL in Java
     identifiers -- most commonly hyphens from filenames like
     "delete-node.java" -> `class delete-node { ... }` which is a SYNTAX
     ERROR in Java (hyphen is parsed as subtraction).

For both cases, the script derives a correct class name from the file's
own name, converted to PascalCase:
    delete-node.java          -> class DeleteNode
    level-order.java           -> class LevelOrder
    my-inbuild-functions.java  -> class MyInbuildFunctions
    Task87_DeleteOneChild.java -> class Task87_DeleteOneChild   (already valid, untouched pattern-wise)

It only ever touches the FIRST top-level class in the file (the one
matching the "broken" pattern: named Main, or containing invalid
characters). Other classes in the same file (helper classes like
TreeNode) are left completely alone.

USAGE:
    python fix_main_classes_v2.py "C:\\flutter\\projects\\data_structure_algorithm"

Always run this on a separate git branch and review `git diff` before merging.
"""

import re
import sys
from pathlib import Path

# Matches: [public] class <name>   where <name> may include invalid chars
# like hyphens, so we can DETECT the broken declaration in the first place.
CLASS_DECL_RE = re.compile(r'\b(public\s+)?class\s+([A-Za-z_][A-Za-z0-9_\-]*)')

VALID_IDENTIFIER_RE = re.compile(r'^[A-Za-z_][A-Za-z0-9_]*$')


def derive_class_name(stem: str) -> str:
    """Turn a filename stem into a valid Java identifier, PascalCase if needed."""
    if VALID_IDENTIFIER_RE.match(stem):
        # Already valid (letters/digits/underscore only) -- keep as-is,
        # e.g. Task87_DeleteOneChild
        name = stem
    else:
        # Split on anything that's not letter/digit/underscore (hyphens,
        # spaces, dots, etc.) and PascalCase each piece.
        parts = [p for p in re.split(r'[^0-9A-Za-z_]+', stem) if p]
        name = ''.join(p[0].upper() + p[1:] for p in parts)

    if name and name[0].isdigit():
        name = "_" + name
    return name


def process_file(path: Path):
    text = path.read_text(encoding="utf-8", errors="ignore")

    match = CLASS_DECL_RE.search(text)
    if not match:
        return None  # no class declaration found at all, skip

    old_name = match.group(2)

    needs_fix = (old_name == "Main") or not VALID_IDENTIFIER_RE.match(old_name)
    if not needs_fix:
        return None  # class name is already fine, leave file untouched

    new_name = derive_class_name(path.stem)
    if new_name == old_name:
        return None

    # Replace the class declaration itself (only first occurrence)
    new_text = text[:match.start(2)] + new_name + text[match.end(2):]

    # Replace other literal self-references to the old name in this file
    # (e.g. `new delete-node()`, `Main.foo()`). Escaped for regex safety.
    old_escaped = re.escape(old_name)
    ref_pattern = re.compile(old_escaped)
    new_text, n_refs = ref_pattern.subn(new_name, new_text)
    n_refs = max(0, n_refs - 1)  # don't double-count the declaration itself

    path.write_text(new_text, encoding="utf-8")
    return (path, old_name, new_name, n_refs)


def main():
    if len(sys.argv) < 2:
        print("Usage: python fix_main_classes_v2.py <project_root>")
        sys.exit(1)

    root = Path(sys.argv[1])
    changed = []
    skipped = []

    for java_file in root.rglob("*.java"):
        try:
            result = process_file(java_file)
            if result:
                changed.append(result)
        except Exception as e:
            skipped.append((java_file, str(e)))

    print(f"\nFixed {len(changed)} files:")
    for path, old_name, new_name, n_refs in changed:
        print(f"  {path}")
        print(f"      class {old_name}  ->  class {new_name}   ({n_refs} other references updated)")

    if skipped:
        print(f"\nSkipped {len(skipped)} files due to errors:")
        for path, err in skipped:
            print(f"  {path}: {err}")

    print("\nDone. Run `git diff` to review every change before committing.")


if __name__ == "__main__":
    main()
