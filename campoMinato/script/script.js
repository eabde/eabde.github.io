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
    $('.cella').click(function () {
        $(this).css('background-color', 'red');
    });
});
