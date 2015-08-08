var SIE = {};

SIE.aplicarMascaras = function () {
    $(".cpf").mask('999.999.999-99');
    $(".cnpj").mask('99.999.999/9999-99');
    $(".data").mask('99/99/9999');
    $(".cep").mask('99.999-999');
};

(function () {
    $(document).ready(SIE.aplicarMascaras);

    if (typeof jsf != "undefined") {
        jsf.ajax.addOnEvent(SIE.aplicarMascaras);
    }
})();