package com.example.clase2.entity;

public class Alumno {

    private String nombre;
    private int codigo;

   public Alumno(String nombre,int codigo){
       this.nombre=nombre;
       this.codigo=codigo;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
