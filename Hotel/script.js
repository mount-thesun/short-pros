let heading = document.getElementById("heading");

var btn = document.getElementById("button-book");
// Higher order Function -> takes a function and returns a function
btn.addEventListener("focus", // Callback function
function() {
    heading.style.color = "cyan";
})

var btn = document.getElementById("button-more");
btn.addEventListener("focus", function() {
    heading.style.color = "red";
})

setTimeout( function() {
    console.log("Timeout");
}, 5000);


// ECMA Standard 6 (ES6)
/* Hoisting -> pushes variables before initialization
a=100;
(or)
console.log(a);
var a;
*/

/* Template Literal
const name = `My name is ${firstname} ${lastname} at ${20+5}`;
 
console.log( name.includes("a") );
*/

/* 
var x = () => {
    console.log("This is an Arrow function");
}
x();
*/

/* Destructuring (unpacking array)
var array = [100,200,300];
var [first,second] = array;
console.log(second, first);
array.pop();  @ending
array.push(number);
array.shift();  @starting
array.unshift(number);
*/

/*
for (var iterator of array) {
    total += iterator;
}

array.forEach( (element)=> {
    total += element;
}) 
    'element' is a parameter

array.map( (item)=> {
    return item * 2;
})
*/