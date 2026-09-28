/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.HistorialClinicoModel;
import com.mycompany.vetcontrol.Util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy-
 */
public class HistorialClinicoDAO {
    
    public void insertar(HistorialClinicoModel h) throws SQLException {
         String sql = "insert into historial_clinico (id_mascota, fecha_atencion, diagnostico, tratamiento, vacunas, id_veterinario) values (?,?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, h.getIdMascota());
            ps.setDate(2, java.sql.Date.valueOf(h.getFechaAtencion()));
            ps.setString(3, h.getDiagnostico());
            ps.setString(4, h.getTratamiento());
            ps.setString(5, h.getVacunas());
            ps.setInt(6, h.getIdVeterinario());
         
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    h.setIdHistorial(rs.getInt(1));
                }
            }
        }
    }
    
        public HistorialClinicoModel buscarporId(int idHistorial) throws SQLException{
        String sql ="select id_historial, id_mascota, fecha_atencion, diagnostico, tratamiento, vacunas, id_veterinario from historial_clinico where id_historial=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idHistorial);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new HistorialClinicoModel(
                        rs.getInt ("id_historial"),
                        rs.getInt ("id_Mascota"),
                        rs.getDate("fecha_atencion").toLocalDate(),
                        rs.getString("diagnostico"),
                        rs.getString("tratamiento"), 
                        rs.getString("vacunas"),
                        rs.getInt("id_veterinario")
                        
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<HistorialClinicoModel> listar() throws SQLException {
        List<HistorialClinicoModel> lista = new ArrayList<>();
        String sql = "select id_historial, id_mascota, fecha_atencion, diagnostico, tratamiento, vacunas, id_veterinario from historial_clinico";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new HistorialClinicoModel(
                        rs.getInt("id_historial"),
                        rs.getInt("id_mascota"),
                        rs.getDate("fecha_atencion").toLocalDate(), 
                         rs.getString("diagnostico"),
                        rs.getString("tratamiento"), 
                        rs.getString("vacunas"),
                        rs.getInt("id_veterinario") 
                        
                )); 
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (HistorialClinicoModel h) throws SQLException{
        String sql = "update historial_clinico set id_mascota=?, fecha_atencion=?, diagnostico=?, tratamiento=?, vacunas=?,  id_veterinario where id_historial  =?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
            
            ps.setInt(1, h.getIdMascota());
            ps.setDate(2, java.sql.Date.valueOf(h.getFechaAtencion()));
            ps.setString(3, h.getDiagnostico());
            ps.setString(4, h.getTratamiento());
            ps.setString(3, h.getVacunas());
            ps.setInt(5, h.getIdVeterinario());
    
            ps.executeUpdate();
                     
        }
        }
        
        
        public void eliminar(int idHistorial) throws SQLException{
        String sql= "delete from historial_clinico where id_historial=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idHistorial);
            ps.executeUpdate();
        }
        }
}
    
