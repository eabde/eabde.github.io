class TodoList {
    constructor(d, s) {
        this.descrizione = d;
        this.scadenza = s;
    }
}
function aggiungiTodo() {
    let descrizione = document.getElementById("descrizione").value;
    let scadenza = document.getElementById("scadenza").value;
    if (descrizione != "" && scadenza != "") {
        let lista = document.getElementById("todoList");
        const attivita = creaToDo(descrizione, scadenza);
        lista.innerHTML += attivita;
    } else {
        alert("Compilare i campi")
    }
    document.getElementById("descrizione").value = "";
    document.getElementById("scadenza").value = "";
}
function creaToDo(descrizione, scadenza) {
    const attivita = `
        <div class="elemento">
            <input type="checkbox" id="check">
            <input type='text' id='descrizione' value='${descrizione}' readonly></input>
            <input type="date" id="scadenza" value='${scadenza}' readonly>
            <button type='button' id='elimina' onclick='elimina(this)'>Elimina</button>
            <button type='button' id='modifica''>Modifica</button>
        </div>
        `;
    return attivita;
}
function elimina(attivita) {
    attivita.parentNode.remove();
}
function eliminaTutto() {
    document.getElementById("todoList").innerHTML = "";
}
function mostraUrgenti() {
    let lista = document.getElementById("todoList");
    let checkboxUrgenti = document.getElementById("urgenti");
    let attivita = lista.getElementsByClassName("elemento");
    for (let i = 0; i < attivita.length; i++) {
        let scadenzaInput = attivita[i].getElementsByTagName("input")[2];
        let dataScadenza = new Date(scadenzaInput.value);
        let now = new Date();
        let daysDiff = (dataScadenza.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
        if (checkboxUrgenti.checked) {
            if (daysDiff <= 3 && daysDiff >= -1) {
                attivita[i].style.visibility = "visible";
            } else {
                attivita[i].style.visibility = "hidden";
            }
        } else {
            attivita[i].style.visibility = "visible";
        }
    }
}
function ordinaScadenza(){

}