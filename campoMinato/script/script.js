class Campo {
    constructor() {
        this.size = 10;
        this.nBombe = 5;
        this.campo = [];
    }

    creaCampo() {
        for (let i = 0; i < this.size; i++) {
            for (let j = 0; j < this.size; j++) {
                $('#campo').append('<div class="cella" onclick="cambia()"></div>');
            }
            $('#campo').append("<br>");
        }
    }
}
 
$(document).ready(function() {
   const campo = new Campo();
    campo.creaCampo();
});
