function clienteGet() {
    $.ajax({
        url: "http://localhost:8080/EcotiendaWS/web/json/articulo/" + document.getElementById("id").value,
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul><li>ID: ";
            body += data.id;
            body += "</li><li>Nombre: ";
            body += data.nombre;
            body += "</li></ul>";
            $("#resultado").html(body);
        }
    });
}

function clienteSel() {
    $.ajax({
        url: "http://localhost:8080/Ecotienda/web/json/articulo/",
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul>";
            for (var i = 0; i < data.length; i++) {
                body += "<li>ID: "+data[i].id;
                body += "</li><li>Nombre: ";
                body += data[i].nombre+"</li>";
            }
            body += "</ul>";
            $("#resultado").html(body);
        }
    });
}


