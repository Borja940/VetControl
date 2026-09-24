/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.VeterinarioModel;
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
public class VeterinarioDAO {
    
       public void insertar(VeterinarioModel v) throws SQLException {
         String sql = "insert into veterinario(nombre, colegiado, especialidad, telefono, id_usuario) values (?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getColegiado());
            ps.setString(3, v.getEspecialidad());
            ps.setString(4, v.getTelefono());
            ps.setInt(5, v.getIdUsuario());
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    v.setIdVeterinario(rs.getInt(1));
                }
            }
        }
    }
    
        public VeterinarioModel buscarporId(int idVeterinario) throws SQLException{
        String sql ="select idVeterinario, nombre, colegiado, especialidad, telefono, id_usuario from veterinario where id_veterinario=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idVeterinario);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new VeterinarioModel(
                        rs.getInt ("idVeterinario"),
                        rs.getString("nombre"),
                        rs.getString("colegiado"), 
                        rs.getString("especialidad"),
                        rs.getString("telefono"),
                        rs.getInt("idUsuario")
                        
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<VeterinarioModel> listar() throws SQLException {
        List<VeterinarioModel> lista = new ArrayList<>();
        String sql = "select idVeterinario, nombre, colegiado, especialidad, telefono, id_usuario from veterinario";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new VeterinarioModel(
                        rs.getInt("idHistorial"),
                        rs.getString("nombre"),
                        rs.getString("colegiado"),  
                        rs.getString("especialidad"),
                        rs.getString("telefono"),
                         rs.getInt("idUsuario")
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (VeterinarioModel v) throws SQLException{
        String sql = "update veterianrio set nombre=?, colegiado=?, especialidad=?, telefono=?, id_usuario=? where id_veterinario=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getColegiado());
            ps.setString(3, v.getEspecialidad());
            ps.setString(4, v.getTelefono());
            ps.setInt(5, v.getIdUsuario());
            
            ps.executeUpdate();
                     
        }
        }
        
        
        
        public void eliminar(int idVeterinario) throws SQLException{
        String sql= "delete from veterinario where id_Veterinario=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idVeterinario);
            ps.executeUpdate();
        }
        }
}
        
    
