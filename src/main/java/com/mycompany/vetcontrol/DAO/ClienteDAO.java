/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.ClienteModel;
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
class ClienteDAO {
    
    public void insertar(ClienteModel c) throws SQLException {
         String sql = "insert into cliente(nombre, direccion, telefono, correo) values (?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setIdCliente(rs.getInt(1));
                }
            }
        }
    }
    
        public ClienteModel buscarporId(int idCliente) throws SQLException{
        String sql ="select id, nombre, direccion, telefono, correo from cliente where id_cliente=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idCliente);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new ClienteModel(
                        rs.getInt ("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("direccion"), 
                         rs.getString("telefono"),
                        rs.getString("correo")   
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<ClienteModel> listar() throws SQLException {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "select idCliente, nombre, direccion, telefono, correo from cliente";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new ClienteModel(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),  
                         rs.getString("telefono"),
                        rs.getString("correo") 
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (ClienteModel c) throws SQLException{
        String sql = "update cliente set nombre=?, direccion=?, telefono=?, correo=? where id_cliente=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getDireccion());
        ps.setString(3, c.getTelefono());
        ps.setString(4, c.getCorreo());
        ps.executeUpdate();
                     
        }
        }
        
        
        
        public void eliminar(int idCliente) throws SQLException{
        String sql= "delete from cliente where id_cliente=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idCliente);
            ps.executeUpdate();
        }
        }
}
        

           
        
    
         
    
         
         
         
         
     
    
  
