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
public class InventarioModel {
    
    private int idInventario;
    private int idProducto;
    private String tipoMovimiento;
    private int Cantidad;
    private LocalDate fecha;
    private int idUsuario;

    public InventarioModel() {
        
    }

    public InventarioModel(int idInventario, int idProducto, String tipoMovimiento, int Cantidad, LocalDate fecha, int idUsuario) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.tipoMovimiento = tipoMovimiento;
        this.Cantidad = Cantidad;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
       
        
       
    }

    