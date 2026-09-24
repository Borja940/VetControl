/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.UsuarioModel;
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
public class UsuarioDAO {
    
    public void insertar(UsuarioModel u) throws SQLException {
         String sql = "insert into usuario (nombre, correo, password_hash, rol) values (?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPasswordHash());
            ps.setString(4, u.getRol());
          
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setIdUsuario(rs.getInt(1));
                }
            }
        }
    }
    
        public UsuarioModel buscarporId(int idUsuario) throws SQLException{
        String sql ="select id_usuario, nombre, correo, passwordHash, rol from usuario where id_usuario=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idUsuario);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new UsuarioModel(
                        rs.getInt ("idUsuario"),
                        rs.getString("nombre"), 
                        rs.getString("correo"),
                        rs.getString("passwordHash"), 
                        rs.getString("rol")
                   
                        
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<UsuarioModel> listar() throws SQLException {
        List<UsuarioModel> lista = new ArrayList<>();
        String sql = "select id_uduario nombre, correo, passwordHash, rol  from usuario";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new UsuarioModel(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),  
                        rs.getString("passwordHash"),
                        rs.getString("rol")
                       
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (UsuarioModel u) throws SQLException{
        String sql = "update usuario set nombre=?, correo=?, password_hash=?, rol=? where id_usuario=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getCorreo());
        ps.setString(3, u.getPasswordHash());
        ps.setString(4, u.getRol());
       
        ps.executeUpdate();
                     
        }
        }
        
        
        
        public void eliminar(int idUsuario) throws SQLException{
        String sql= "delete from usuario where id_usuario=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idUsuario);
            ps.executeUpdate();
        }
        }
}
        
    
   
