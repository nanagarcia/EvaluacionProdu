$(document).ready(function(){
    $('#listar').on('click', function(){
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = '<thead><th>Codigo</th><th>Nombre Producto</th><th>Categoria</th><th>Precio</th><th>Cantidad</th><th>Total</th><th>Total IVA</th></thead>';

        $.ajax({
            url:"http://localhost:8080/listarProducto",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);

                for(i=0; i <= respuesta.length; i++){

                    tabla.innerHTML += '<tr><td>' + respuesta[i].codigo + '</td><td>' 
                        + respuesta[i].nombre + '</td><td>'
                        + respuesta[i].categoria + '</td><td>' 
                        + respuesta[i].precio + '</td><td>' 
                        + respuesta[i].cantidad + '</td><td>' 
                        + respuesta[i].total +'</td><td>'
                        + respuesta[i].total_iva+ '</td></tr>'

                }
                
            }
        })
    });

    $('#Total').on('click',function(){
        
        $.ajax({
            url:"http://localhost:8080/TotalProducto",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);

                if(respuesta){
                    alert("se a añadido el total")
                }else{
                    alert("no se añadio el total")
                }
            }
        })
    });

    $('#T_iva').on('click',function(){
        
        $.ajax({
            url:"http://localhost:8080/TotalProductoIVA",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);

                if(respuesta){
                    alert("se a añadido el total con iva")
                }else{
                    alert("no se añadio el total")
                }
            }
        })
    });

    $('#categoria').on('click', function(){
        let tabla2 = document.querySelector('#tabla2')
        tabla2.innerHTML = '<thead><th>Codigo</th><th>Nombre Producto</th><th>Categoria</th><th>Precio</th><th>Cantidad</th></thead>';
        let cate = $('#catebuscar').val();

        $.ajax({
            url:"http://localhost:8080/buscarCategoria/" + cate,
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);
                for(let i = 0; i <= respuesta.length; i++){

                    tabla2.innerHTML += '<tr><td>' 
                        + respuesta[i].codigo + '</td><td>' 
                        + respuesta[i].nombre + '</td><td>'
                        + respuesta[i].categoria + '</td><td>' 
                        + respuesta[i].precio + '</td><td>' 
                        + respuesta[i].cantidad + '</td><tr>' 

                }
                
            }
        })
    });
    
})