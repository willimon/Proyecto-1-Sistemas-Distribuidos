function ListadoProfesores() {
    d3.json("http://localhost:8089/rest/clientes", function(json) {
      var content = d3.select("#content");
      content.selectAll("div").remove();
      var div = content.append("div");
      div.append("h2").text("Listado de clientes");
      var table = div.append("table");
      var thead = table.append("thead");
      thead.append("th").text("Nombre");
      thead.append("th").text("Apellido");
      thead.append("th").text("Provincia");
      thead.append("th").text("Ciudad");
      var tr = table.selectAll("tr")
                  .data(json.profesor)
                  .enter().append("tr")
                  .attr("onClick","DetalleCliente(this)");
      tr.attr("id",function(d) {return d.id;});
      tr.append("td").text(function(d) {return d.nombre;});
      tr.append("td").text(function(d) {return d.apellido;});
      tr.append("td").text(function(d) {return d.provincia;});
      tr.append("td").text(function(d) {return d.ciudad;});
      div.append("input").attr("type","button")
         .attr("value","Agregar").attr("id","button")
         .attr("onClick","AgregarCliente(this)");
    });
  }