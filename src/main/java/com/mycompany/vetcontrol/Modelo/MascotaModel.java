/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Modelo;

/**
 *
 * @author andy-
 */
public class MascotaModel {
    private int idMacota;
    private String nombre;
    private String especie;
    private String raza;
    private String edad;
    private ClienteModel dueno;

    public MascotaModel() {
    }

    public MascotaModel(int idMacota, String nombre, String especie, String raza, String edad, ClienteModel dueno) {
        this.idMacota = idMacota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.dueno = dueno;
        
        
    }

    public int getIdMacota() {
        return idMacota;
    }

    public void setIdMacota(int idMacota) {
        this.idMacota = idMacota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public ClienteModel getDueno() {
        return dueno;
    }

    public void setDueno(ClienteModel dueno) {
        this.dueno = dueno;
    }
    
    
}
