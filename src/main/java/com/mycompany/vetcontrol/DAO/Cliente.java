/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andy-
 */
class Cliente {
    
     public void insertar(Cliente c) throws SQLException {
         String sql = "insert into cliente(nombre, telefono, correo) values (?,?,?)";
         try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
              ps.setString(1, c.getNombre());
              ps.setString(2, c,getTelefono);
              ps.setString(3, c.getCorreo());
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setId(rs.getInt(1));

         }
         
         
         
     }
    
    
    
}
