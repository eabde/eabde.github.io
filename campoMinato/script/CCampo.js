class CCampo {
    constructor() {
        this.size = 9;
        this.mine = 10;
        this.campo = [];
    }

    creaCampo() {
        for (let i = 0; i < this.size; i++) {
            this.campo[i] = [];
            for (let j = 0; j < this.size; j++) {
                this.campo[i][j] = new CCella(i, j);
                $('#campo').append(`<div class="cella" data-row="${i}" data-col="${j}"></div>`);
            }
            $('#campo').append("<br>");
        }
        this.generaMine();
    }

    generaMine() {
        for (let i = 0; i < this.mine; i++) {
            let x = Math.floor(Math.random() * this.size);
            let y = Math.floor(Math.random() * this.size);
            while (this.campo[x][y].mina == true) {
                x = Math.floor(Math.random() * this.size);
                y = Math.floor(Math.random() * this.size);
            }
            this.campo[x][y].mina = true;
        }
        this.numeroMineAdiacenti();
    }

    numeroMineAdiacenti() {
        for (let i = 0; i < this.size; i++) {
            for (let j = 0; j < this.size; j++) {
                this.campo[i][j].calcolaMineAdiacenti(this.campo);
            }
        }
    }
    scopriMine() {
        for (let i = 0; i < this.size; i++) {
            for (let j = 0; j < this.size; j++) {
                let cella = campo[i][j];
                if (cella.mina && !cella.visitata) {
                    cella.valCella();
                }
            }
        }
    }
}
