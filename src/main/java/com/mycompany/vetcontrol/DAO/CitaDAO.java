/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.CitaModel;
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
public class CitaDAO {
    
    public void insertar(CitaModel c) throws SQLException {
         String sql = "insert into cita (fecha, hora, motivo, id_mascota, id_veterinario) values (?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           ps.setDate(1, java.sql.Date.valueOf(c.getFecha()));
            ps.setTime(2, c.getHora());
            ps.setString(3, c.getMotivo());
            ps.setInt(4, c.getIdMascota());
            ps.setInt(5,c.getIdVeterinario());
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setIdCita(rs.getInt(1));
                }
            }
        }
    }
    
        public CitaModel buscarporId(int idCita) throws SQLException{
        String sql ="select idCita, fecha, hora, motivo, id_mascota, id_veterinario from cita where id_cita=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idCita);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new CitaModel(
                        rs.getInt ("idCita"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora"), 
                        rs.getString("motivo"),
                        rs.getInt("idMascota"),
                        rs.getInt("idVeterinario")
                        
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<CitaModel> listar() throws SQLException {
        List<CitaModel> lista = new ArrayList<>();
        String sql = "select idCita fecha, hora, motivo, id_mascota, id_veterinario from cita";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new CitaModel(
                        rs.getInt("idCita"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora"),  
                         rs.getString("motivo"),
                        rs.getInt("idMascota"),
                        rs.getInt("idVeterianrio") 
                        
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (CitaModel c) throws SQLException{
        String sql = "update cita set fecha=?, hora=?, motivo=?, id_mascota=?, id_veterinario where id_cita=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
        ps.setDate(1, java.sql.Date.valueOf(c.getFecha()));
        ps.setTime(2, c.getHora());
        ps.setString(3, c.getMotivo());
        ps.setInt(4, c.getIdMascota());
        ps.setInt(5, c.getIdVeterinario());
        ps.executeUpdate();
                     
        }
        }
        
        
        
        public void eliminar(int idCita) throws SQLException{
        String sql= "delete from cita where id_cita=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idCita);
            ps.executeUpdate();
        }
        }
}
        
    
    
    
    
    
    
    
    
    
    

