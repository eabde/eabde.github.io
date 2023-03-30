class Calcolatrice {
    constructor(){
        this.num1 = null;
        this.num2 = null;
        this.operazione = null;
    }
}

function cancella(){
    document.getElementById("campo").value = "";
}

function aggiungiNumero(num) {
    document.getElementById("campo").value += num;
}

function eseguiOperazione(operazione) {
    this.operazione = operazione;
    this.num1 = document.getElementById("campo").value;
    document.getElementById("campo").value = "";
}

function calcola() {
    num2 = document.getElementById("campo").value;
    var risultato;
    switch (operazione) {
        case "+":
            risultato = num1 + num2;
            break;
        case "-":
            risultato = num1 - num2;
            break;
        case "*":
            risultato = num1 * num2;
            break;
        case "/":
            risultato = num1 / num2;
            break;
        default:
            risultato = "errore";
    }
    
    document.getElementById("campo").value = risultato;
}