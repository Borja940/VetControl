/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Modelo;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author andy-
 */
public class CitaModel {
    
    private int idCita;
    private LocalDate fecha;
    private Time hora;
    private String motivo;
    private int idMascota;
    private int idVeterinario;

    public CitaModel() {
    }

    public CitaModel(int idCita, LocalDate fecha, Time hora, String motivo,  int idMascota, int idVeterinario) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }
    
    
    
    
    
}
