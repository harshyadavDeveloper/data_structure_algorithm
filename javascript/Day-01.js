/*
=========================================================
DAY 01
Topics:
- JavaScript Execution Context
- Memory Component
- Code Component
- Creation Phase
- Execution Phase
- Call Stack
- Hoisting
- var
- Function Declaration
- Function Expression
- Arrow Function

RULE:
Answer theory questions inside comments.
Run practical questions and write your predicted output
before running them.
=========================================================
*/

/*
=========================================================
SECTION 1 — THEORY
Q1 - Q5
=========================================================
*/

// Q1.
// What exactly is an Execution Context?
//
/*
Execution context is an abstract enviroment where javascript executes code. it consists of two thing memory component and code component. 
Memory component is where variables and function gets assigned to a value. at the first phase it skims thru the code and indentifies functions and variable. variables are assigned with undefined and at the function it places the entire function code.
Also when the function is invoked then for that function another conext is created to execute that function. only creating a function does not create a context for that function
Then in the second phase it assigns the correct values to variables and for function it creates another execution context that gets stacked up in the call stack

*/

// Q2.
// What are the two major components of an Execution Context?
// the two major components are memory components and code components

// Q3.
// What happens during the creation phase of a Global
// Execution Context?
//
// Specifically explain what happens to:
// - var variables
// - function declarations
// - functions
/*
 at the creation phase function and variables gets assigned with some values specifically variables gets undefined.
 functions that we define like function getName(){} stores the entire function code
 and arrow function gets treated as varibale so undefined is store against it. and yes the memory component stores this in a key:value pair. e.g. x:4, getName: {..}.
 2nd e.g.: var x = 10;
           function test(){...}
           creation phase: x:undefined
                           test:{...}
*/

// Q4.
// What is the difference between the creation phase and
// the execution phase?

// first of all js is a single threaded and synchronous language. single threaded means it only has 1 stack it can only execute 1 line at a time. so in the creation phase all the variables and functions gets defined in the memory component.
// in the execution phase variables gets assings with the actual values and it gets executed line by line.

//Q5.

//Explain the Call Stack using this code:

function one() {
  two();
}

function two() {
  three();
}

function three() {
  console.log("Hello");
}

one();

//Explain step-by-step what gets pushed onto and removed
//from the Call Stack.
//
/*
fist the global context gets inserted into the call stack with one:{...}, then another on top of it gets added two:{...} and then three:{...}. then when the three prints hello it pops from the context and gives the control back to function two and when two finishes calling three with gives control back to 1 and only then the main global context finishes and pops from the call stack
Global EC created
      ↓
Global code starts executing
      ↓
one() is invoked
      ↓
one() EC is created and pushed
      ↓
one() calls two()
      ↓
two() EC is created and pushed
      ↓
two() calls three()
      ↓
three() EC is created and pushed
      ↓
three() executes console.log()
      ↓
three() finishes → popped
      ↓
control returns to two()
      ↓
two() finishes → popped
      ↓
control returns to one()
      ↓
one() finishes → popped
      ↓
Global code continues
*/

/*
=========================================================
SECTION 2 — PRACTICAL
Q6 - Q10
=========================================================
*/

//Q6.

//Without running the code, predict the output.

console.log(a);
var a = 10;

console.log(a);

// Then explain WHY the first console.log produces that
// result.

// first console will print undefined and second will print 10. this is possible because of hoisting. hoisting is an ability to use a var/func before its declaration. at first js skims thru the project the identifies only variables and function and marks them with undefined and function as it is. this is the reason for getting undefined. it knows the code has x but rn it does not know about the value it holds that happens in the second phase(exection)

// Q7.
//
// Predict the output:
//
console.log(x);

var x = 20;

console.log(x);

// Explain what happened to x during the creation phase
// and execution phase.

/* 
first print will be undefined and second print will be 20. at the creation phase x gets assings with undefined and at the execution phase it gets the value 20.
*/

// Q8.
//
// Predict the output:

greet();

function greet() {
  console.log("Hello");
}

// Then explain why this works even though greet() appears
// before the function declaration.
// this will print hello. it works become something called as hoisting in js. at the creation phase js stores all the variables with undefined and function as it is. at the execution phase it actually executes the function so even tho greeting is defined below js already know what is inside and is able to run the function

// Q9.
//
// Predict the output:

console.log(foo);

var foo = function () {
  console.log("Hello");
};

// Explain why this behaves differently from Q8.
// here it will print undefiend. here when the js engine scans the code it sees var foo and immidieately assings it with undefined it has no idea that it will be assigned with a function later.

// Q10.
//
// Predict the output:
//
// console.log(foo);
//
// var foo = () => {
//     console.log("Hello");
// };
//
// Explain why an arrow function behaves this way here.
// Don't simply say "because arrow functions are variables."
// here the output will be undefined. when the engine scans thru our project it see var foo and considers it as a variable and immedieately assigns it as undefiend at point it has no idea that this varibale later will be assgined to a function.

/*
=========================================================
SECTION 3 — INTERVIEW THEORY
Q11 - Q15
=========================================================
*/

// Q11.
// An interviewer asks:
//
// "Is JavaScript interpreted or compiled?"
//
// Based only on what you learned today, how would you
// answer?

// Modern JavaScript engines use both compilation and interpretation techniques, including JIT compilation.. at starting it was interpreted and code used to get executed line by line but as the requirement changed the approach changed too.

/*
Q12.

An interviewer asks:

"What is the difference between an Execution Context
and the Call Stack?"

Answer as if you're speaking to the interviewer.
*/
// execution context is the abstract envioronment where the js code executes and call stack is a way to handle the EC efficiently and it used LIFO method for it. as the EC gets generated it gets pushed into call stack and as the execution ends one by one it pops.

// Q13.
//
// Why does JavaScript allow this?

console.log(a);

var a = 100;

// What JavaScript mechanism makes this possible?
// JS allows this because of the mechanism called hoisting which occours during the setup of execution context. before running the single line of code engine scans and identifies the variable and assigns it undefiend.

/*
Q14.

An interviewer asks:

"Is hoisting actually moving variable declarations to
the top of the code?"

How would you answer?
*/
// no not exactly. js engine before running a single line of code scans thru the code and indentifies var and assings it with undefined which is not 100% hoisting we are not actually pulling the variable up litrally

/*
Q15.

What is the difference between:

var a = 10;

and:

function test() {
    console.log("Hello");
}

in terms of what is available during the creation phase?

Explain carefully.
*/
// at creation phase a gets assigns with undefined and test gets assigned with the function as it is. a:undefined, test:{...} so at creation phase undefiend is availbale and for test the entire function as it is available.

/*
=========================================================
SECTION 4 — INTERVIEW HANDS-ON
Q16 - Q20
=========================================================
*/

//Q16.

// Predict the EXACT output:

console.log(a);

var a = 10;

function test() {
  console.log("Inside test");
}

test();

console.log(a);

// Then explain the complete execution flow.

// first print will be undefiend then inside test and then 10. first at the creation js engine will scan thru the entire code to indentify var and func. then it will assing a:undefiend, test:{..}
// then in the execution another EC will be created and pushed in the call stack for test() there it will print the inside test and then it pop from the stack and then on the next line it will print 10

// Q17.

// Predict the EXACT output:

var a = 10;

function test() {
  var a = 20;
  console.log(a);
}

console.log(a);

test();

console.log(a);

// Explain which Execution Context each `a` belongs to.

// 10
// 20
// 10

// The first `a` belongs to the Global Execution Context. Inside the `test()` function, a new Function Execution Context is created. The `var a = 20` belongs to this function's Execution Context and shadows the global `a`.
// Therefore: Global a = 10 test() a  = 20 After `test()` finishes, its Execution Context is removed from the Call Stack, so the global `a` is still 10.

// Q18.

// Predict the EXACT output:

console.log(foo);

var foo = 10;

function foo() {
  console.log("function");
}

console.log(foo);

// Why does the result surprise many developers?

// Explain what happened during the creation phase.

// output: function
//         10
/* 
During the creation phase, the function declaration
`function foo()` is stored in memory with the actual
function definition.

The `var foo` declaration is also processed, but it does
not overwrite the function during the creation phase.

Therefore, before execution:

foo → function

So the first `console.log(foo)` prints the function.

When execution reaches:

var foo = 10;

the declaration has already been handled during the
creation phase. During execution, `foo = 10` assigns
the value 10 to `foo`.

Therefore, the second `console.log(foo)` prints 10.
*/


// Q19.

// Predict the EXACT output:

var a = 1;

function first() {
    var a = 2;

    function second() {
        var a = 3;
        console.log(a);
    }

    second();
    console.log(a);
}

first();

console.log(a);

// Draw/write the Call Stack at the point where `second()`
// is executing.

/*

Initially, the Global Execution Context contains:

a = 1

When `first()` is called, a new Function Execution Context
is created for `first()`.

Inside `first()`:

a = 2

Then `second()` is called, creating another Function
Execution Context.

Inside `second()`:

a = 3

Therefore:

`console.log(a)` inside `second()` prints 3.

After `second()` finishes, its Execution Context is removed
from the Call Stack.

Execution returns to `first()` where:

`console.log(a)` prints 2.

After `first()` finishes, its Execution Context is removed
from the Call Stack.

Execution returns to the Global Execution Context where:

`console.log(a)` prints 1.


Call Stack while `second()` is executing:

┌─────────────────────┐
│ second() Context    │
│ a = 3               │
├─────────────────────┤
│ first() Context     │
│ a = 2               │
├─────────────────────┤
│ Global Context      │
│ a = 1               │
*/


// Q20 — INTERVIEW CHALLENGE

// Without running the code first, predict the output:

console.log(a);

var a = 10;

function a() {
    console.log("A");
}

a();

// Then answer:

// 1. What was stored for `a` during the creation phase?
// 2. What happened when execution reached `var a = 10`?
// 3. Why can/can't `a()` execute at the end?

// This question is intentionally designed to test whether
// you actually understand today's concept rather than just
// remembering the definition of hoisting.


// output:
// function
// 10

/*

Explanation:

1. What was stored for `a` during the creation phase?

During the creation phase, the function declaration
`function a()` is stored in memory.

So initially:

a → function


2. What happened when execution reached `var a = 10`?

The `var a` declaration was already handled during the
creation phase.

When execution reaches:

var a = 10;

the assignment happens:

a = 10

So the function reference is replaced by the value 10.


3. Why can/can't `a()` execute at the end?

At the end, `a` contains the value 10, not the function.

Therefore:

a();

tries to call 10 as if it were a function.

This causes a TypeError because 10 is not callable.

So the actual output is:

function
10

followed by a TypeError at:

a();


Important concept:

Creation Phase:
a → function

After `var a = 10` executes:
a → 10

Therefore `a()` cannot execute successfully at the end.
*/

/*
=========================================================
END OF DAY 01
=========================================================
*/
