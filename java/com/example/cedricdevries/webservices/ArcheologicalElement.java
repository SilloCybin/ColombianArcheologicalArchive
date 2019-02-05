package com.example.cedricdevries.webservices;

import java.io.Serializable;

public class ArcheologicalElement implements Serializable {

    public long ID;
    public String parque_arqueologico;
    public String elemento_arqueologico;
    public String nombre_elemento_arqueologico;
    public String descripcion;
    public String ubicacion_actual_dentro_del_parque;
    public String datos_historicos;
    public String dimensiones_visibles;
    public String tecnica_de_elaboracion;
    public String datos_bibliograficos;


    // _____CONSTRUCTORS______________________________________________________________________________

    public ArcheologicalElement(){

    }

    public ArcheologicalElement(String parque_arqueologico,
                                String elemento_arqueologico,
                                String nombre_elemento_arqueologico,
                                String descripcion,
                                String ubicacion_actual_dentro_del_parque,
                                String datos_historicos,
                                String dimensiones_visibles,
                                String tecnica_de_elaboracion,
                                String datos_bibliograficos) {

        this.parque_arqueologico = parque_arqueologico;
        this.elemento_arqueologico = elemento_arqueologico;
        this.nombre_elemento_arqueologico = nombre_elemento_arqueologico;
        this.descripcion = descripcion;
        this.ubicacion_actual_dentro_del_parque = ubicacion_actual_dentro_del_parque;
        this.datos_historicos = datos_historicos;
        this.dimensiones_visibles = dimensiones_visibles;
        this.tecnica_de_elaboracion = tecnica_de_elaboracion;
        this.datos_bibliograficos = datos_bibliograficos;
    }


    // _____GETTERS_&_SETTERS_________________________________________________________________________


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getParque_arqueologico() {
        return parque_arqueologico;
    }

    public void setParque_arqueologico(String parque_arqueologico) {
        this.parque_arqueologico = parque_arqueologico;
    }

    public String getElemento_arqueologico() {
        return elemento_arqueologico;
    }

    public void setElemento_arqueologico(String elemento_arqueologico) {
        this.elemento_arqueologico = elemento_arqueologico;
    }

    public String getNombre_elemento_arqueologico() {
        return nombre_elemento_arqueologico;
    }

    public void setNombre_elemento_arqueologico(String nombre_elemento_arqueologico) {
        this.nombre_elemento_arqueologico = nombre_elemento_arqueologico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion_actual_dentro_del_parque() {
        return ubicacion_actual_dentro_del_parque;
    }

    public void setUbicacion_actual_dentro_del_parque(String ubicacion_actual_dentro_del_parque) {
        this.ubicacion_actual_dentro_del_parque = ubicacion_actual_dentro_del_parque;
    }

    public String getDatos_historicos() {
        return datos_historicos;
    }

    public void setDatos_historicos(String datos_historicos) {
        this.datos_historicos = datos_historicos;
    }

    public String getDimensiones_visibles() {
        return dimensiones_visibles;
    }

    public void setDimensiones_visibles(String dimensiones_visibles) {
        this.dimensiones_visibles = dimensiones_visibles;
    }

    public String getTecnica_de_elaboracion() {
        return tecnica_de_elaboracion;
    }

    public void setTecnica_de_elaboracion(String tecnica_de_elaboracion) {
        this.tecnica_de_elaboracion = tecnica_de_elaboracion;
    }

    public String getDatos_bibliograficos() {
        return datos_bibliograficos;
    }

    public void setDatos_bibliograficos(String datos_bibliograficos) {
        this.datos_bibliograficos = datos_bibliograficos;
    }

    // _____toString()________________________________________________________________________________
    @Override
    public String toString() {
        return "Parque Archeologico: " + parque_arqueologico + '\n' +
                "Tipo: " + elemento_arqueologico + '\n' +
                "Nombre: " + nombre_elemento_arqueologico + '\n' +
                "Descripcion: " + descripcion + '\n' +
                "Ubicacion en el Parque: " + ubicacion_actual_dentro_del_parque + '\n' +
                "Datos Historicos: " + datos_historicos + '\n' +
                "Dimensiones: " + dimensiones_visibles + '\n' +
                "Tecnica: " + tecnica_de_elaboracion + '\n' +
                "Datos Bibliograficos: " + datos_historicos + '\n';
    }
}
