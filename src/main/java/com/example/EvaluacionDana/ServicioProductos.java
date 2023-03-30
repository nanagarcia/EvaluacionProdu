package com.example.EvaluacionDana;

import java.util.ArrayList;

public class ServicioProductos {
    private ArrayList<Productos> lista = new ArrayList<>();
    private ArrayList<Productos> buscar = new ArrayList<>();

    public ServicioProductos(){
        lista.add(new Productos(1,"Durazno","Frutas",5500,13,0,0));
        lista.add(new Productos(2,"Manzana","Frutas",6500,10,0,0));
        lista.add(new Productos(3,"Banano","Frutas",400,21,0,0));
        lista.add(new Productos(4,"Cepillo","Aseo",2500,10,0,0));
        lista.add(new Productos(5,"Jabon","Aseo",2000,20,0,0));
        lista.add(new Productos(6,"Crema","Aseo",4000,5,0,0));
        lista.add(new Productos(7,"Cuaderno","Utiles",2800,15,0,0));
        lista.add(new Productos(8,"Lapiz","Utiles",1000,20,0,0));
        lista.add(new Productos(9,"Borrador","utiles",500,35,0,0));
        lista.add(new Productos(10,"Anillos","Joyas",25000,8,0,0));
    }

    public  ArrayList<Productos>mostrar(){
        return lista;
    }

    public ArrayList<Productos>BuscarCategoria(String categoria){
        buscar.clear();
        String prodc = null;
        for (Productos u: lista){
            if (u.getCategoria().equals(categoria)){
                buscar.add(u);
            }
        }
        return buscar;
    }

    public String obtenerTotal(){

        for (int i = 0; i < lista.size(); i++) {
            Double total = lista.get(i).getPrecio() * lista.get(i).getCantidad();

            lista.get(i).setTotal(total);
            lista.set(i, lista.get(i));
        }
        return "SE A REALIZADO EL CAMBIO";
    }

    public String obtenerTotalIva(){
        for (int i = 0; i < lista.size(); i++) {
            Double totalIva = (lista.get(i).getTotal() * 19) / 100;

            lista.get(i).setTotal_iva(totalIva);
            lista.set(i, lista.get(i));
        }
        return "se a sumado el iva";
    }

}
