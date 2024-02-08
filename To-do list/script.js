const input = document.querySelector("input");
const button = document.querySelector("button");
const list = document.querySelector(".list");

button.addEventListener("click", addItem);
list.addEventListener("click", modifyItem);

function addItem(event) {
    event.preventDefault();   // Avoids auto-submit
 
    const toDoDiv = document.createElement("div");
    toDoDiv.classList.add("to-do-container");
    list.appendChild(toDoDiv);

    const item = document.createElement("li");
    item.classList.add("to-do-item");
    item.innerText = input.value;
    toDoDiv.appendChild(item);
     
    const complete = document.createElement("button");
    complete.classList.add("complete");
    complete.innerHTML = '<i class="fa-solid fa-check"></i>'
    toDoDiv.appendChild(complete);

    const deleteButton = document.createElement("button");
    deleteButton.classList.add("delete");
    deleteButton.innerHTML = '<i class="fa-sharp fa-solid fa-trash"></i>';
    toDoDiv.appendChild(deleteButton);

    input.value = "";   // Resets input
}

function modifyItem(event) {
    const item = event.target;
    if( item.classList[0] == "delete") {
        const deleteItem = item.parentElement;
        deleteItem.remove();
    }
    if( item.classList[0] == "complete") {
        const markItem = item.parentElement;
        markItem.classList.toggle("completed");
    }
}