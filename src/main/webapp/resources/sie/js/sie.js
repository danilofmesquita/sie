var SIE = {};

SIE.aplicarMascaras = function () {
    $(".cpf").mask('999.999.999-99');
    $(".cnpj").mask('99.999.999/9999-99');
    $(".data").mask('99/99/9999');
    $(".cep").mask('99.999-999');
    $(".telefone").mask('(99) 9999-99999');
};

(function () {
    $(document).ready(SIE.aplicarMascaras);

    if (typeof jsf != "undefined") {
        jsf.ajax.addOnEvent(SIE.aplicarMascaras);
        jsf.ajax.addOnEvent(function(data){
            var ajaxStatus = data.status;
            var ajaxLoader = $('.ajaxloader');

            switch (ajaxStatus){
                case "begin":
                    ajaxLoader.show();
                    break;
                case "complete":
                    ajaxLoader.hide();
                    break;
                case "sucess":
                    break;
            }
        });
    }
})();

