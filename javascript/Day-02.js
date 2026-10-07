/*
=========================================================
DAY 02
Topics:
- Functions in JavaScript
- Function creation
- Function invocation/execution
- Execution Context refresher
- JavaScript program / empty file
=========================================================
*/

/*
=========================================================
Q1 — PRACTICAL
=========================================================

Write a function called `calculateSquare` that accepts a
number and returns its square.

Then call it with 5 and print the result.

Expected result:

25
*/

// Write your code below:

function sqr(num) {
  return num * num;
}

console.log(sqr(5));

/*
=========================================================
Q2 — TRACE THE FUNCTION
=========================================================

Without running the code, trace what happens when this
program executes.
*/
function greet(name) {
  console.log("Hello " + name);
}

greet("Harsh");
/*
Answer:

1. When is the function created?
2. When is its Execution Context created?
3. What value does `name` receive?
4. What gets printed?
5. What happens to the Function Execution Context after
   the function finishes?

Your answer:
The `greet` function is created during the memory/creation phase of the Global Execution Context. When `greet("Harsh")` is actually called, JavaScript creates a new 
Function Execution Context for `greet` and pushes it onto the Call Stack. The value `"Harsh"` is passed as an argument, so the `name` parameter gets the value `"Harsh"`. 
The function then executes and prints `Hello Harsh` to the console. Once the function finishes executing, its Function Execution Context is popped from the Call Stack, 
and the execution continues from where it left off.

*/

/*
=========================================================
Q3 — ACTUAL CODING
=========================================================

Write a function:

isEven(number)

It should return `true` if the number is even and `false`
if it is odd.

Test it with at least 3 different numbers.

Example:

isEven(10) → true
isEven(7)  → false
*/

// Write your code below:

function isEven(num) {
  if (num % 2 == 0) {
    return true;
  }
  return false;
}

let ten = isEven(10);
let seven = isEven(7);
console.log(ten);
console.log(seven);

/*
=========================================================
Q4 — FUNCTION RETURN
=========================================================

What will this print?
*/
function add(a, b) {
  return a + b;
}

var result = add(10, 20);

console.log(result);
/*
Then modify the function so that it also prints:

"Result is: 30"

Do NOT change the `console.log(result)` line.
*/

// Your explanation:
// I used `(a + b)` inside parentheses so that `a` and `b` are added together first. This gives `30`, which is then combined with the string `"Result is: "`. Therefore,
// the function returns `"Result is: 30"`, which is stored in `result` and printed by `console.log(result)`.When add(10, 20) is called, the values 10 and 20 are passed to the parameters a and b.

// Your modified code:

function add(a, b) {
  return "Result is: " + (a + b);
}

var result = add(10, 20);

console.log(result);

/*
=========================================================
Q5 — FUNCTION CREATION VS EXECUTION
=========================================================

Write a small program containing:

1. A function declaration
2. A function call
3. A variable used inside the function
4. A return value

Then explain, in comments, the difference between:

- Function creation
- Function invocation
- Function Execution Context
- Function completion

This is your "teach it back" question.
*/

// Your code:

function add() {
  let a = 10;
  return a + 5;
}

let result = add();
console.log(result);

// Your explanation:
// Function creation:
// The `add` function is created during the creation phase of the
// Global Execution Context. JavaScript stores the complete function
// in memory, but the function does not execute at this point.

// Function invocation:
// When JavaScript reaches `add()`, the function is invoked.
// This is when JavaScript actually starts executing the function.

// Function Execution Context:
// When `add()` is invoked, a new Function Execution Context is
// created for the `add` function and pushed onto the Call Stack.
// The variable `a` is created inside this Function Execution Context.

// Function completion:
// The function executes `return a + 5`, so `10 + 5` gives `15`.
// The value `15` is returned and the Function Execution Context
// is removed (popped) from the Call Stack.

/*
=========================================================
Q6 — INTERVIEW THEORY
=========================================================

An interviewer asks:

"What is the difference between defining a function
and invoking a function in JavaScript?"

Answer as if you are speaking directly to the interviewer.

Give a small example.
*/
// function defination:
function print() {
  console.log("Hello World");
}

// function invokation:
print();
// Defining a function means creating the function and specifying what it should do by writing its function body. At this point, the function is only being created; it
// is not executing yet. Invoking a function means calling that function using its name, and that's when JavaScript actually starts executing the code inside the
// function.

/*
Your answer:
*/

/*
=========================================================
Q7 — INTERVIEW HANDS-ON
=========================================================

What is the EXACT output?
*/
function test() {
  console.log("A");
  return;
  console.log("B");
}

test();

// Then explain why "B" is never printed.

/*
Your answer: Output: A
B will never print because it is written after return, anything written after return is beyound reach basically dead code. In JS after the return statement the control 
goes back to the line where it was invoked and it never reaches B
*/

/*
=========================================================
Q8 — INTERVIEW HANDS-ON
=========================================================

Write a function called `findMax(a, b, c)` that returns
the largest of the three numbers.

Do NOT use Math.max().

Test your function with at least 3 different inputs.
*/

// Write your code below:
function findMax(a, b, c) {
  if (a >= b && a >= c) {
    return a;
  } else if (b >= a && b >= c) {
    return b;
  } else {
    return c;
  }
}

let first = findMax(10, 20, 30);
let second = findMax(10, 40, 20);
let third = findMax(50, 10, 50);

console.log(first);
console.log(second);
console.log(third);

/*
=========================================================
Q9 — INTERVIEW THEORY + PRACTICAL
=========================================================

An interviewer gives you:
*/
function multiply(a, b) {
  return a * b;
}

console.log(multiply(5, 4));
/*
Explain the complete execution flow:

1. What exists before `multiply()` is called?
2. What happens when `multiply()` is invoked?
3. What happens to `a` and `b`?
4. What gets returned?
5. What happens to the Function Execution Context
   afterward?

Then draw/write the Call Stack while `multiply()` is
executing.
*/

/*
Your answer:
Before `multiply()` is called, the `multiply` function is created during the creation phase of the Global Execution Context and stored in memory. The function itself 
does not execute yet.

When JavaScript reaches `multiply(5, 4)`, the function is invoked, so a new Function Execution Context is created for `multiply` and pushed onto the Call Stack. The 
arguments `5` and `4` are passed to the function, so `a` gets `5` and `b` gets `4`.

Inside the function, `a * b` is calculated, which gives `20`. The function returns `20` to the place where it was called, which is `console.log()`, so `20` is printed 
to the console.

After the function finishes, its Function Execution Context is removed (popped) from the Call Stack. Execution then continues in the Global Execution Context.

┌─────────────────────────────┐
│ multiply()                  │ ← Function Execution Context
│ a = 5                       │
│ b = 4                       │
│ return a * b → 20           │
├─────────────────────────────┤
│ Global Execution Context    │
└─────────────────────────────┘
*/

/*
=========================================================
Q10 — INTERVIEW CHALLENGE
=========================================================

Write a function called `countVowels(str)` that returns
the number of vowels in a string.

Example:

countVowels("javascript") → 3
countVowels("hello")      → 2

Requirements:

- Handle a string
- Count a, e, i, o, u
- Return the count
- Do not use a regular-expression solution

Test your function with at least 3 strings.
*/

// Write your code below:

function countVowels(str) {
  if (str.length === 0) {
    return 0;
  }

  let count = 0;

  for (let i = 0; i < str.length; i++) {
    if (
      str[i] === "a" ||
      str[i] === "e" ||
      str[i] === "i" ||
      str[i] === "o" ||
      str[i] === "u"
    ) {
      count++;
    }
  }

  return count;
}

console.log(countVowels("hello"));
console.log(countVowels("javascript"));
console.log(countVowels(""));

/*
=========================================================
END OF DAY 02 — REFLECTION
=========================================================

1. What became clearer about functions today?

I understood the difference between function creation and
function invocation more clearly. A function is created and
stored during the creation phase, but its code does not
execute until the function is actually invoked.

I also understood that when a function is invoked, JavaScript
creates a new Function Execution Context, pushes it onto the
Call Stack, executes the function, returns the result, and
then removes that Function Execution Context from the stack.

I also became more comfortable tracing how arguments are
assigned to function parameters and how return values travel
back to the place where the function was called.


2. What still feels unclear?

The concept of the shortest JavaScript program being an empty
file is something I understand at a basic level, but I don't
yet see much practical or interview value in it.

I also want to become more comfortable with the deeper internal
details of how JavaScript creates and manages the global
environment, but I don't think I need to over-focus on that
until the playlist reaches those concepts.


3. Which question took the most thinking?

Q10 — countVowels() took the most practical thinking because
I had to actually design the logic myself instead of just
predicting an output or explaining a concept.

It helped me practice loops, conditions, string indexing,
variables, and return values together.

=========================================================
*/
