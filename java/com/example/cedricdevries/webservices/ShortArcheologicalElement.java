package com.example.cedricdevries.webservices;

import java.io.Serializable;

public class ShortArcheologicalElement implements Serializable {

    private long ID;
    private String parqueArqueologico;
    private String tipo;
    private String nombre;


    // _____CONSTRUCTORS______________________________________________________________________________

    public ShortArcheologicalElement(){

    }

    public ShortArcheologicalElement(long ID,
                                     String parque_arqueologico,
                                     String elemento_archeologico,
                                     String nombre_elemento_archeologico){

        this.ID = ID;
        this.parqueArqueologico = parque_arqueologico;
        this.tipo = elemento_archeologico;
        this.nombre = nombre_elemento_archeologico;
    }


    // _____GETTERS___________________________________________________________________________________

    public long getID() {
        return ID;
    }

    public String getParqueArqueologico() {
        return parqueArqueologico;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }


    // _____SETTERS___________________________________________________________________________________

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setParqueArqueologico(String parqueArqueologico) {
        this.parqueArqueologico = parqueArqueologico;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // _____toString()________________________________________________________________________________
    @Override
    public String toString() {
        return
                "Parque Archeologico: " + getParqueArqueologico() + '\n' +
                "Tipo: " + getTipo() + '\n' +
                "Nombre: " + getNombre() + '\n';
    }
}