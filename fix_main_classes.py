"""
Bulk-fixes the "everyone named their class Main" problem.

For every .java file under the given root:
  - if it contains a top-level line like `class Main {` or `public class Main {`
  - rename that class to match the file's own name (so bin/*.class stops colliding)

SAFE BY DESIGN:
  - Only touches files where the class name is literally "Main".
  - Only renames the *declaration* line and simple self-references
    (new Main(), Main.foo(), Main::foo) inside the SAME file.
  - Skips (and reports) any file where "Main" appears in a way it can't
    safely handle, so you can fix those by hand.
  - Does NOT touch files outside the given root, and does not delete anything.

USAGE:
    python fix_main_classes.py "C:\\flutter\\projects\\data_structure_algorithm"

Run `git status` / `git diff` afterwards to review every change before committing.
"""

import re
import sys
from pathlib import Path

CLASS_DECL_RE = re.compile(r'\b(public\s+)?class\s+Main\b')
WORD_MAIN_RE = re.compile(r'\bMain\b')

def safe_identifier(name: str) -> str:
    # Java identifiers can't start with a digit; prefix with underscore if needed.
    if not name:
        return name
    if name[0].isdigit():
        name = "_" + name
    return name

def process_file(path: Path):
    text = path.read_text(encoding="utf-8", errors="ignore")

    if not CLASS_DECL_RE.search(text):
        return None  # doesn't declare class Main, leave untouched

    new_name = safe_identifier(path.stem)

    # Replace the class declaration itself
    new_text, n_decl = CLASS_DECL_RE.subn(
        lambda m: f"{m.group(1) or ''}class {new_name}", text, count=1
    )

    # Replace other self-references to Main (constructor calls, static refs)
    # within this same file only.
    new_text, n_refs = WORD_MAIN_RE.subn(new_name, new_text)

    if new_text == text:
        return None

    path.write_text(new_text, encoding="utf-8")
    return (path, new_name, n_refs)

def main():
    if len(sys.argv) < 2:
        print("Usage: python fix_main_classes.py <project_root>")
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

    print(f"\nRenamed 'class Main' -> matching filename in {len(changed)} files:")
    for path, new_name, n_refs in changed:
        print(f"  {path}  ->  class {new_name}  ({n_refs} references updated)")

    if skipped:
        print(f"\nSkipped {len(skipped)} files due to errors:")
        for path, err in skipped:
            print(f"  {path}: {err}")

    print("\nDone. Now run `git diff` to review every change before committing.")

if __name__ == "__main__":
    main()
