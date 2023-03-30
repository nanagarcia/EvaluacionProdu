package com.example.EvaluacionDana;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorProductos {
    ServicioProductos servi = new ServicioProductos();

    @GetMapping("/listarProducto")
    public ArrayList<Productos> list(){
        return servi.mostrar();
    }

    @GetMapping("/buscarCategoria/{cate}")
    public ArrayList<Productos>buscarCategoria(@PathVariable("cate")String categoria){
        return servi.BuscarCategoria(categoria);
    }

    @GetMapping("/TotalProducto")
    public String total(){
        return servi.obtenerTotal();
    }

    @GetMapping("/TotalProductoIVA")
    public String totalIVA(){
        return servi.obtenerTotalIva();
    }



}
