/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Modelo;

/**
 *
 * @author andy-
 */
public class VeterinarioModel {
    
    private int idVeterinario;
    private String nombre;
    private String colegiado;
    private String especialidad;
    private String telefono;
    private int idUsuario;

    public VeterinarioModel() {
    }

    public VeterinarioModel(int idVeterinario, String nombre, String colegiado, String especialidad, String telefono, int idUsuario) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.colegiado = colegiado;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegiado() {
        return colegiado;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
   
    
}
