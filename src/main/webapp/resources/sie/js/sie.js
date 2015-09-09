var SIE = {};

SIE.aplicarMascaras = function () {
    $(".cpf").mask('999.999.999-99');
    $(".cnpj").mask('99.999.999/9999-99');
    $(".data").mask('99/99/9999');
    $(".cep").mask('99.999-999');
    $(".telefone").mask('(99) 9999-99999');
    $(".ano").mask('9999');
};

(function () {
    $(document).ready(SIE.aplicarMascaras);

    if (typeof jsf != "undefined") {

        jsf.ajax.addOnEvent(SIE.aplicarMascaras);
        jsf.ajax.addOnEvent(function(data){

            var ajaxStatus = data.status;
            var ajaxloaderContainer = $('.ajaxloaderContainer').hide();

            switch (ajaxStatus){
                case "begin":
                    ajaxloaderContainer.show();
                    break;
                case "complete":
                    ajaxloaderContainer.hide();
                    break;
                case "sucess":
                    break;
            }
        });
    }
})();

