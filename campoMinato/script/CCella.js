class CCella {
    constructor(x, y) {
        this.colonna = y;
        this.riga = x;
        this.mina = false;
        this.mineAdiacenti = 0;
        this.visitata = false;
    }

    valCella() {
        let cella = $('.cella[data-row=' + this.riga + '][data-col=' + this.colonna + ']');
        cella.css('background-color', 'white');
        if (this.mina) {
            cella.css('background-color', 'red');
            cella.text("X");
        } else if (this.mineAdiacenti != 0) {
            cella.text(this.mineAdiacenti);
        }
        this.visitata = true;
    }

    getAdiacenti(campo) {
        let celleAdiacenti = [];
        for (let i = this.riga - 1; i <= this.riga + 1; i++) {
            for (let j = this.colonna - 1; j <= this.colonna + 1; j++) {
                if (i >= 0 && i < campo.length && j >= 0 && j < campo[i].length && !(i == this.riga && j == this.colonna)) {
                    celleAdiacenti.push(campo[i][j]);
                }
            }
        }
        return celleAdiacenti;
    }

    calcolaMineAdiacenti(campo) {
        let celleAdiacenti = this.getAdiacenti(campo);
        let mineAdiacenti = 0;
        for (let i = 0; i < celleAdiacenti.length; i++) {
            if (celleAdiacenti[i].mina) {
                mineAdiacenti++;
            }
        }
        this.mineAdiacenti = mineAdiacenti;
    }

    liberaCelleAdiacenti(campo) {
        this.visitata = true;
        this.valCella();
      
        if (this.mineAdiacenti == 0) {
          let celleAdiacenti = this.getAdiacenti(campo);
          for (let i = 0; i < celleAdiacenti.length; i++) {
            let adiacente = celleAdiacenti[i];
            if (!adiacente.visitata && !adiacente.mina) {
              adiacente.liberaCelleAdiacenti(campo);
            }
          }
        }
      }
}
