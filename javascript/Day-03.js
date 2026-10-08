/*
=========================================================
DAY 03
Topics:
- undefined
- not defined
- ReferenceError
- Lexical Scope
- Scope Chain
- Parent Environment
- Global Scope
=========================================================
*/

/*
=========================================================
Q1 — THEORY
=========================================================

In your own words, explain the difference between:

1. undefined
2. not defined

Give one code example for each.

Do NOT just give the definitions.
Explain what JavaScript is actually trying to find
in each case.
*/

// Answer: undefined occours when we try to reference an var before its declaration becasue at time js engine has assigned it
// undefined as a placeholder. not defined occours when we try to reference a variable that does not exists.
// e.g.:
console.log(a); // undefined
var a = 10;
console.log(x); // not defined.

// =========================================================
// Q2 — PRACTICAL
// =========================================================

// Predict the EXACT output.

var a;

console.log(a);

console.log(b);

// Then answer:

// Which line works?
// Which line causes an error?
// What type of error occurs?

// Do not run the code before predicting.

/*
Your answer: 
undefined (not an error)
not defined (reference error)
*/

/*
=========================================================
Q3 — ACTUAL CODING
=========================================================

Write a function called `checkValue(value)`.

If the value is `undefined`, print:

"Value is undefined"

Otherwise print:

"Value is defined"

Test your function with:

1. An uninitialized variable
2. A normal value
3. A function that does not return anything
*/

// Write your code below:

function checkValue(value) {
  if (value === undefined) {
    console.log("Value is undefined");
  } else {
    console.log("Value is defined");
  }
}

function returnNothing() {
  console.log("this returns nothing");
}
var a;
checkValue(a);
var b = 10;
checkValue(b);
checkValue(returnNothing());

/*
=========================================================
Q4 — SCOPE
=========================================================

Predict the output:

var a = 10;

function test() {
    var b = 20;

    console.log(a);
    console.log(b);
}

test();

console.log(a);

Then explain:

Why can `test()` access `a` even though `a` was not
declared inside `test()`?
*/

/*
Your answer:
*/
// output:
// 10
// 20
// 10
// test() can access a because it is a part of its lexical environment. meaning when execution context is created for text()
// inside it it will have a reference of its outer context

/*
=========================================================
Q5 — SCOPE CHAIN — ACTUAL CODING
=========================================================

Create three levels of nested functions:

global
  ↓
outer()
  ↓
inner()

Create one variable at each level.

Then make `inner()` print:

1. Its own variable
2. The variable from `outer()`
3. The variable from global scope

Your goal is to demonstrate the Scope Chain using code.

Do NOT use global variables only.
Actually create the nested functions.
*/

// Write your code below:

var globalVar = 10;

function outer() {
  var outerVar = 20;

  function inner() {
    var innerVar = 30;
    console.log(innerVar);
    console.log(outerVar);
    console.log(globalVar);
  }
  inner();
}
outer();

/*
=========================================================
Q6 — INTERVIEW THEORY
=========================================================

An interviewer asks:

"What is lexical scope in JavaScript?"

Explain it as if you are speaking directly to the
interviewer.

Then explain how lexical scope is related to the
Scope Chain.
*/

/*
Your answer:

In JavaScript, lexical scope—also known as static scope—means that where you write your variables and functions in the code 
dictates where they can be accessed. When an inner function is defined inside an outer function, that inner function has 
permanent access to the variables declared in its outer scope. This relationship is fixed at the time of writing, not at 
runtime.
Lexical scope is the foundation of the Scope Chain. When JavaScript tries to find a variable inside a function, it first looks in 
the function's own scope. If it doesn't find it, it moves to the scope where that function was lexically defined, then continues 
outward until it reaches the global scope.
So, in simple terms, lexical scope determines which scopes are connected, and the scope chain is the mechanism JavaScript uses to 
search through those scopes.
*/

// =========================================================
// Q7 — INTERVIEW HANDS-ON
// =========================================================

// Predict the EXACT output:

var a = 10;

function outer() {
  var b = 20;

  function inner() {
    var c = 30;

    console.log(a);
    console.log(b);
    console.log(c);
  }

  inner();
}

outer();

// Explain exactly how JavaScript finds `a`, `b`, and `c`.

// For each variable, identify which scope JavaScript finds
// it in.

/*
Your answer:

Explanation:

When inner() executes, JavaScript first looks for each variable
in the local scope of inner().

1. `a`
   - JavaScript first checks inner() scope → not found.
   - Then it checks outer() scope → not found.
   - Then it checks global scope → found.
   - Therefore, a = 10.

2. `b`
   - JavaScript first checks inner() scope → not found.
   - Then it checks outer() scope → found.
   - Therefore, b = 20.

3. `c`
   - JavaScript checks inner() scope → found.
   - Therefore, c = 30.

The scope chain for inner() is:

inner() → outer() → global

JavaScript searches this chain from the inside outward
until it finds the required variable.
*/

/*
=========================================================
Q8 — INTERVIEW HANDS-ON
=========================================================

What happens here?

function test() {

    console.log(a);

    var a = 10;
}

test();

Predict the output and explain whether this is:

- undefined
- not defined

Explain why.


/*
Your answer:

undefined

This is because `a` is declared using `var` inside the function.

During the creation phase of the function's execution context,
JavaScript hoists the variable declaration and initializes `a`
with `undefined`.

So internally, it is like:

var a;
console.log(a); // undefined
a = 10;

Therefore, this is `undefined`, not `not defined`.

The variable `a` exists in the function scope, but its value has
not been assigned yet when console.log(a) executes.
*/

/*
=========================================================
Q9 — INTERVIEW THEORY
=========================================================

An interviewer asks:

"Does a child scope have access to variables from its
parent scope? Does the parent scope have access to variables
inside the child scope?"

Answer with a small code example.

This question is testing whether you actually understand
the direction of the Scope Chain.
*/

/*
Your answer:
Yes, a child scope can access variables from its parent scope,
because the Scope Chain searches from the child scope outward.

But the parent scope cannot access variables declared inside
the child scope.

Example:

var parent = 10;

function outer() {

    var child = 20;

    console.log(parent); // 10
    console.log(child);  // 20
}

outer();

// The child scope can access the parent variable.
// But the parent scope cannot access the child variable.

So the Scope Chain works in one direction:

Child → Parent → Global

It does not work in the opposite direction.
*/

/*
=========================================================
Q10 — INTERVIEW CHALLENGE
=========================================================

Predict the EXACT output:

var a = 1;

function first() {

    var b = 2;

    function second() {

        var c = 3;

        console.log(a);
        console.log(b);
        console.log(c);
    }

    second();
}

first();

Then draw the Scope Chain available inside `second()`.

Think carefully:

second()
   ↓
?
   ↓
?
   ↓
?

What is the final parent environment?

Also explain what would happen if `second()` tried to
access a variable that exists in NONE of these scopes.
*/

/*
Your answer:

Exact output:

1
2
3

Scope Chain available inside second():

second()
   ↓
first()
   ↓
Global Scope

Inside second():

- `c` is found in the second() scope.
- `b` is not found in second(), so JavaScript searches first()
  and finds it there.
- `a` is not found in second() or first(), so JavaScript
  searches the Global Scope and finds it there.

Therefore:

c → second()
b → first()
a → Global Scope

The final parent environment is the Global Scope.

If second() tries to access a variable that does not exist
in any of these scopes, JavaScript cannot find it and throws
a ReferenceError.

Example:

console.log(x);

This gives:

ReferenceError: x is not defined
*/

/*
=========================================================
END OF DAY 03 — REFLECTION
=========================================================

1. What became clearer about scope today?

I understood that scope determines where a variable can be
accessed. I also understood that JavaScript searches for a
variable from the current scope outward through its parent
scopes.

I became clearer about lexical scope and how it determines
the relationship between nested scopes. I also understood
that a child scope can access variables from its parent
scope, but the parent scope cannot access variables declared
inside the child scope.

The Scope Chain now makes more sense to me because I can
actually trace how JavaScript searches for a variable:
current scope → parent scope → outer scope → global scope.


2. What is still confusing?

The basic Scope Chain is clear to me now, but I still want
to understand more deeply how the scope/environment reference
is maintained internally and how this eventually leads to
closures.

I also want to become more comfortable distinguishing
Execution Context, Scope, and Lexical Environment because
they are closely related concepts.


3. Can you explain the difference between:
   Execution Context
   Scope
   Scope Chain

Execution Context is the environment created when JavaScript
needs to execute code. It contains the information required
to execute that code.

Scope determines where variables and functions are accessible
in the code.

Scope Chain is the mechanism through which JavaScript searches
for a variable. It starts from the current scope and moves
outward through the parent scopes until it finds the variable
or reaches the Global Scope.

In simple terms:

Execution Context → where code is being executed
Scope             → where a variable can be accessed
Scope Chain       → how JavaScript searches for that variable

=========================================================
*/
