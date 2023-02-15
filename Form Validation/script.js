// Control variable
let flag=[1,1,1,1,1];

// Name of user
var user = document.getElementById("name");
user.addEventListener("change", checkName);

function checkName() {
    const input = user.value;
    if(input.length < 5) 
        alert("Name should have more than 5 letters");
    else
        flag[0]=0;
}

// Email
var mail = document.getElementById("mail");
mail.addEventListener("change", checkEmail);

function checkEmail() {
    const input = mail.value;
    if( ! input.includes("@") ) 
        alert("Enter correct email");
    else
        flag[1]=0;
}

// Contact number
var phone = document.getElementById("phone");
phone.addEventListener("change", checkPhone);

function checkPhone() {
    const input = phone.value;
    if(input.length != 10 || input === "1234567890") 
        alert("Enter a valid Phone Number");
    else
        flag[2]=0;
}

// Password
var password = document.getElementById("pass");
password.addEventListener("change", checkPassword);

function checkPassword() {
    const input = password.value;
    const name = user.value;
    if(input.length < 8 || input === "password" || input === name) 
        alert("Please enter a more secure password");
    else
        flag[3]=0;
}

// Confirm password
var re_password = document.getElementById("re-pass");
re_password.addEventListener("change", confirmPassword);

function confirmPassword() {
    const input = re_password.value;
    if(input != password.value) 
        alert("Password mismatch!");
    else
        flag[4]=0;
}

// Form Submission
document.querySelector("form").addEventListener("submit", proceed);
function verifyForm() {
    checkName();
    checkEmail();
    checkPhone();
    checkPassword();
    confirmPassword();
}
function proceed() {
    verifyForm();

    // searching for errors
    let count=0;
    for(let i=0; i<5; i++)
        if(flag[i] == 0)
            count++;

    // verification
    if(count==5)
        alert("You are Welcome! The form was submitted");
    else
        alert("Please fill the form correctly");
}
