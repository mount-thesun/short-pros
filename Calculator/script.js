// Inputs

const operator = document.querySelectorAll(".operator");
for(let index=0; index < operator.length; index++)
    operator[index].addEventListener("click", append);

function append(event) {
    event.preventDefault();     // prevents page refresh
    var item = event.target.id;

    switch(item) {
        case 'zero':
            item = '0'; break;
        case 'one':
            item = '1'; break;
        case 'two':
            item = '2'; break;
        case 'three':
            item = '3'; break;
        case 'four':
            item = '4'; break;
        case 'five':
            item = '5'; break;
        case 'six':
            item = '6'; break;
        case 'seven':
            item = '7'; break;
        case 'eight':
            item = '8'; break;
        case 'nine':
            item = '9'; break;
        case 'zeroes':
            item = '00'; break;
        case 'decimal':
            item = '.'; break;
        case 'add':
            item = '+'; break;
        case 'subtract':
            item = '-'; break;
        case 'multiply':
            item = '*'; break;
        case 'divide':
            item = '/'; break;
        case 'modulo':
            item = '%'; break;
        case 'power':
            item = '**('; break;
        case 'square':
            item = '**2'; break;
        case 'square-root':
            item = '**(1/2)'; break;
        case 'cube':
            item = '**3'; break;
        case 'cube-root':
            item = '**(1/3)'; break;
    }
    
    var input = document.querySelector("input");
    input.value += item;
}

// Result

document.querySelector("#equal-to").addEventListener("click", calculate);

function calculate(event) {
    event.preventDefault();     // prevents page refresh
    var input = document.querySelector("input");
    input.value = eval(input.value);
}

// All Clear

document.querySelector("#clear").addEventListener("click", clearAll);

function clearAll(event) {
    event.preventDefault();     // prevents page refresh
    var input = document.querySelector("input");
    input.value = "";
}
