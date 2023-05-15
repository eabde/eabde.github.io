class Attivita{
    constructor(d,s){
        this.descrizione = d;
        this.scadenza = s;
    }
     creaToDo() {
        //creo l'elemento e ci aggiungo l'evento per eliminarlo
        const attivita = `
            <div class="elemento">
                <input type="checkbox" id="check">
                <input type='text' id='descrizione' value='${this.descrizione}' readonly></input>
                <input type="date" id="scadenza" value='${this.scadenza}' readonly>
                <button type='button' id='elimina' onclick='todoList.elimina(this)'>Elimina</button>
                <button type='button' id='modifica''>Modifica</button>
            </div>
            `;
        return attivita;
    }
}