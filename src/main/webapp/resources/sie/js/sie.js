var SIE = {};

SIE.aplicarMascaras = function () {
    $(".cpf").mask('999.999.999-99');
    $(".cnpj").mask('99.999.999/9999-99');
    $(".data").mask('99/99/9999');
    $(".cep").mask('99.999-999');
    $(".telefone").mask('(99) 9999-99999');
    $(".ano").mask('9999');
    $(".nota").mask('99.99');
};

SIE.aplicarDataTables = function () {
    $('.table').dataTable({
        "responsive": true,
        "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            }
        }
    });
};

(function () {

    $(document).ready(SIE.aplicarDataTables);
    $(document).ready(SIE.aplicarMascaras);

    if (typeof jsf != "undefined") {

        jsf.ajax.addOnEvent(SIE.aplicarMascaras);
        jsf.ajax.addOnEvent(function (data) {

            var ajaxStatus = data.status;
            var ajaxloaderContainer = $('.ajaxloaderContainer').hide();

            switch (ajaxStatus) {
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

SIE.toTop = function () {
    $("html, body").animate({scrollTop: 0}, "slow");
};

$(".navbar-sie").affix({
    offset: {
        top: 100
    }
});

$(".navbar-wrapper").height($(".navbar-sie").height());
