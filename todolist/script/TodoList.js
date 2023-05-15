class TodoList {
    constructor() {
        this.list = new Array();
    }

    aggiungiTodo() {
        let descrizione = document.getElementById("descrizione").value;
        let scadenza = document.getElementById("scadenza").value;
        if (descrizione != "" && scadenza != "") {
            const attivita = new Attivita(descrizione, scadenza);
            this.list.push(attivita);

            const lista = document.getElementById("todoList");
            const elemento = attivita.creaToDo();
            lista.innerHTML += elemento;
        } else {
            alert("Compilare i campi");
        }
        document.getElementById("descrizione").value = "";
        document.getElementById("scadenza").value = "";
    }
    elimina(attivita) {
        attivita.parentNode.remove();
    }
    eliminaTutto() {
        document.getElementById("todoList").innerHTML = "";
    }
     ordinaScadenza() { 

    }
    mostraUrgenti() {
        const lista = document.getElementById("todoList");
        const checkboxUrgenti = document.getElementById("urgenti");
        for (let i = 0; i < this.list.length; i++) {
            const attivita = this.list[i];
            const dataScadenza = new Date(attivita.scadenza);
            const now = new Date();
            const daysDiff = (dataScadenza.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
            const elemento = lista.children[i];
            if (checkboxUrgenti.checked) {
                if (daysDiff <= 3 && daysDiff >= -1) {
                    elemento.style.visibility = "visible";
                } else {
                    elemento.style.visibility = "hidden";
                }
            } else {
                elemento.style.visibility = "visible";
            }
        }
    }
}

