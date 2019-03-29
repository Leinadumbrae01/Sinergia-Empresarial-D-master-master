package com.example.mauri.sede;

public class Usuarios {
    private String nombre;
    private String fecha;
    private String hora;
    private String area;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuarios(){

    }
    public Usuarios(String nombre, String fecha, String hora, String area,String status) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.area = area;
        this.status=status;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return fecha;
    }

    public void setInfo(String info) {
        this.fecha = info;
    }


}
