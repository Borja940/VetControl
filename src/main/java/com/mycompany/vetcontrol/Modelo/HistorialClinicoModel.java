/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Modelo;

import java.time.LocalDate;

/**
 *
 * @author andy-
 */
public class HistorialClinicoModel {
    
    private int idHistorial;
    private int  idMascota;
    private LocalDate fechaAtencion; 
    private String diagnostico;
    private String tratamiento;
    private String vacunas;
    private int idVeterinario;

    public HistorialClinicoModel() {
        
        
    }

    public HistorialClinicoModel(int idHistorial, int idMascota, LocalDate fechaAtencion, String diagnostico, String tratamiento, String vacunas, int idVeterinario) {
        this.idHistorial = idHistorial;
        this.idMascota = idMascota;
        this.fechaAtencion = fechaAtencion;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.vacunas = vacunas;
        this.idVeterinario = idVeterinario;
    }
    

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdveterinario(int idveterinario) {
        this.idVeterinario = idVeterinario;
    }
    
    
    
    
    
}
