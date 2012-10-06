function DetalleCliente(row) {
    d3.json("http://localhost:8089/rest/clientes/"+row.id, function(cliente) {
      var content = d3.select("#content");
      content.selectAll("div").remove();
      var div = content.append("div");
      div.append("input")
        .attr("value",cliente.id)
        .attr("id","id").
        attr("type","hidden");
      div.append("h2").text("Detalle de cliente");
      var table = div.append("table");
      var tr = table.append("tr");
      tr.append("td").text("Nombre:");
      tr.append("td").append("input")
        .attr("value",cliente.nombre)
        .attr("id","nombre");
      tr = table.append("tr");
      tr.append("td").text("Apellido:");
      tr.append("td").append("input")
        .attr("value",cliente.apellido)
        .attr("id","apellido");;
      tr.append("td").text("Provincia:");
      tr.append("td").append("input")
        .attr("value",cliente.provincia)
        .attr("id","provincia");;
      tr = table.append("tr");
      tr.append("td").text("Ciudad:");
      tr.append("td").append("input")
        .attr("value",cliente.ciudad)
        .attr("id","ciudad");;
      tr.append("td").text("Telefono:");
      tr.append("td").append("input")
        .attr("value",cliente.telefono)
        .attr("id","telefono");;
      div.append("input").attr("type","button")
         .attr("value","Actualizar").attr("id","button")
         .attr("onClick","ActualizarProfesor(this)");
      div.append("input").attr("type","button")
         .attr("value","Eliminar").attr("id","button")
         .attr("onClick","EliminarProfesor(this)");
    });
  }