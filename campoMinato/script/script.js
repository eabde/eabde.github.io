$(document).ready(function () {
    const campo = new CCampo();
    campo.creaCampo();

    $('#gCampo').change(function () {
        campo.size = $(this).val();
        $('#campo').empty();
        campo.creaCampo();
    });
    $('#nMine').change(function () {
        campo.mine = $(this).val();
        $('#campo').empty();
        campo.creaCampo();
    });
    $('#campo').on('click', '.cella', function () {
        let riga = $(this).data('row');
        let colonna = $(this).data('col');
        let cella = campo.campo[riga][colonna];

        if (!cella.mina && cella.mineAdiacenti == 0) {
            cella.visitata = true;
            cella.valCella();
            cella.liberaCelleAdiacenti(campo.campo);
        } else {
            cella.valCella();
        }
    });
    $('#campo').on('contextmenu', '.cella', function (event) {
        event.preventDefault();
        $(this).css('background-color', 'red');
    });
});