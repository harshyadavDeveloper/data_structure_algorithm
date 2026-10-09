/*
=========================================================
DAY 04
Topics:
- var, let, const
- Function Scope vs Block Scope
- Hoisting and Temporal Dead Zone (TDZ)
- Block Scope
- Shadowing
- Illegal Shadowing
=========================================================
*/

/*
=========================================================
SECTION 1 — LEARN & PRACTICE
Q1–Q8
=========================================================
*/

/*
Q1. THEORY — var vs let vs const

Explain the differences between var, let, and const in
terms of:

1. Scope
2. Hoisting and initialization
3. Reassignment
4. Redeclaration

Give a small code example for each.

Also explain why const does not mean that an object's
contents can never change.
*/
// var is function scoped while let and const are block scoped.
// var is initialized with undefined, while let and const remain uninitialized in the Temporal Dead Zone (TDZ) until their
// declaration is executed. Accessing them before initialization throws a ReferenceError.
// because they are stored outside of global scope unlike var. They are also defined but before initialzation they are in a TDZ.
// Temporal dead zone is peroid between entering a scope and initializing a let or const.
// we can reassign var and let variable but we cannot reassing const. We can just declare var and let at top and maybe assing
// them value later in the code but const requires a value at the time of declaration.
// var allows redeclaration, whereas let and const do not allow redeclaration in the same scope.

var a = 10;
var a = 20; // Allowed

let b = 10;
let b = 20; // SyntaxError

const c = 10;
const c = 20; // SyntaxError


// Q2. PRACTICAL — BLOCK SCOPE

// Predict the EXACT output:

var a = 10;
let b = 20;
const c = 30;

{
    var a = 100;
    let b = 200;
    const c = 300;

    console.log(a);
    console.log(b);
    console.log(c);
}

console.log(a);
console.log(b);
console.log(c);

// Explain why each value is printed.

// Pay special attention to what happens to `a` after
// the block finishes.

// Output: 

// 100
// 200
// 300
// 100
// 20
// 30

/* 
First a → 100: var is not block-scoped. The inner var a = 100 refers to the same variable declared outside the block and overwrites 
its value from 10 to 100.
First b → 200: let is block-scoped. The inner b is a separate variable from the outer b, which remains 20.
First c → 300: const is also block-scoped. The inner c is separate from the outer c, which remains 30.
After the block: a is still 100 because the inner var changed the same variable. But b and c return to their outer values, 20 and 
30, because their inner declarations existed only inside the block.
*/

/*
Q3. PRACTICAL — TEMPORAL DEAD ZONE

Predict the EXACT output or error:

console.log(a);
let a = 10;

Then consider:

console.log(b);
var b = 20;

Explain why the two examples behave differently.

What is the Temporal Dead Zone, and when does it end?
*/

/* 
Output: reference error
Output: undefined

Explanation:
let is hoisted but remains uninitialized in the
Temporal Dead Zone (TDZ) until its declaration is
executed. Accessing it before initialization causes
a ReferenceError.

var is hoisted and initialized with undefined
during the creation phase, so accessing it before
assignment prints undefined.

The TDZ ends when the let or const variable
is initialized during execution.
*/

/*
Q4. ACTUAL CODING — SCOPE

Write a program that:

1. Declares a variable named `message` in the global scope.
2. Creates a function named `showMessage`.
3. Inside that function, creates a block using `if`.
4. Declares another `message` using let inside the block.
5. Prints both the inner and outer values.

Your output should demonstrate that the inner block's
variable does not overwrite the outer variable.

Use meaningful values and explain the output.
*/

/*
Q5. PRACTICAL — SHADOWING

Predict the EXACT output:

let x = 10;

function test() {
    let x = 20;

    if (true) {
        let x = 30;
        console.log(x);
    }

    console.log(x);
}

test();
console.log(x);

Explain which declaration each console.log accesses.
*/

/*
Q6. PRACTICAL — var INSIDE A BLOCK

Predict the EXACT output:

function test() {
    var a = 1;

    if (true) {
        var a = 2;
        console.log(a);
    }

    console.log(a);
}

test();

Now explain what would change if the inner `var a = 2`
were replaced with `let a = 2`.

Do not just give the output. Explain the scope difference.
*/

/*
Q7. ACTUAL CODING — LOOP SCOPE

Write a program using a for loop that declares its counter
with `let`.

Print the counter inside the loop.

Then write a second version using `var`.

Explain the scope difference between the two declarations.

Do not use setTimeout or Promises for this question.
*/

/*
Q8. PRACTICAL — const

Predict the output:

const user = {
    name: "Alex",
    age: 25
};

user.age = 26;
console.log(user.age);

Then consider:

const user = {
    name: "Alex"
};

user = {
    name: "Sam"
};

What happens in each example, and why?

Explain what const actually prevents.
*/

/*
=========================================================
SECTION 2 — INTERVIEW PRACTICE
Q9–Q15
=========================================================
*/

/*
Q9. INTERVIEW THEORY — HOISTING

An interviewer asks:

"Are let and const hoisted in JavaScript?"

Give an interview-ready answer.

Explain how their behavior differs from var and what
the Temporal Dead Zone has to do with it.
*/

/*
Q10. INTERVIEW HANDS-ON — OUTPUT PREDICTION

Predict the EXACT output or error:

var a = 1;

function test() {
    console.log(a);
    let a = 2;
}

test();

Explain why JavaScript does not print the global value
of `a` inside the function.

Identify the role of the local declaration.
*/

/*
Q11. INTERVIEW THEORY — SHADOWING

What is variable shadowing in JavaScript?

Explain it with an example involving an outer variable
and an inner variable with the same name.

Then explain the difference between shadowing with let
and redeclaring a variable with var inside a block.
*/

/*
Q12. INTERVIEW HANDS-ON — ILLEGAL SHADOWING

Predict what happens:

let a = 10;

{
    var a = 20;
}

Does this code execute successfully?

Now compare it with:

var b = 10;

{
    let b = 20;
}

Explain why the two cases behave differently.

Do not run the code before making your prediction.
*/

/*
Q13. INTERVIEW HANDS-ON — LOOP CLOSURE PREVIEW

Predict the output:

for (var i = 0; i < 3; i++) {
    console.log(i);
}

for (let j = 0; j < 3; j++) {
    console.log(j);
}

Write the complete output in order.

Explain the scope of `i` and `j` after their loops finish.

Do not use closures or asynchronous code in your explanation.
*/

/*
Q14. INTERVIEW THEORY — BLOCK SCOPE

An interviewer asks:

"What is a block in JavaScript, and which declarations
are block-scoped?"

Explain:

1. What curly braces represent in a block statement.
2. How let and const behave inside a block.
3. Why var behaves differently.
4. Whether every pair of curly braces automatically
   creates a block scope.

Give examples to support your explanation.
*/

/*
Q15. INTERVIEW CHALLENGE — DEBUGGING

A developer writes:

let count = 10;

if (true) {
    var count = 20;
}

console.log(count);

They expect the output to be 10.

Answer the following:

1. What happens when JavaScript processes this code?
2. Does it print 10, print 20, or throw an error?
3. Why?
4. Rewrite the code with the smallest sensible change
   so that the output is 10.

Explain the underlying scope rule.
*/

/*
=========================================================
END OF DAY 04 — REFLECTION
=========================================================

1. Which distinction became clearer today?
2. Which question challenged your understanding most?
3. Explain the difference between block scope,
   function scope, and the Temporal Dead Zone in your
   own words.
=========================================================
*/
