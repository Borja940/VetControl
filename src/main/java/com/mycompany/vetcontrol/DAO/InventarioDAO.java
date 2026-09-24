/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.InventarioModel;
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
public class InventarioDAO {
    
     public void insertar(InventarioModel i) throws SQLException {
         String sql = "insert into inventario (id_producto, tipo_movimiento, cantidad,  fecha, id_usuario values (?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, i.getIdProducto());
            ps.setString(2, i.getTipoMovimiento());
            ps.setInt(3, i.getCantidad());
            ps.setDate(4, java.sql.Date.valueOf(i.getFecha()));
            ps.setInt(5, i.getIdUsuario());
            
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    i.setIdInventario(rs.getInt(1));
                }
            }
        }
    }
    
        public InventarioModel buscarporId(int idInventario) throws SQLException{
        String sql ="select id_inventario, id_prodcuto, tipo_movimiento, cantidad, fecha, id_usuario, from inventario where id_inventario=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idInventario);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new InventarioModel(
                        rs.getInt ("idInventario"),
                        rs.getInt ("idProducto"),
                        rs.getString("tipoMovimiento"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("idUsuario") 
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<InventarioModel> listar() throws SQLException {
        List<InventarioModel> lista = new ArrayList<>();
        String sql = "select id_inventario tipo_mpvimiento, cantidad, fecha, id_usuario from inventario";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new InventarioModel(
                           rs.getInt ("idInventario"),
                        rs.getInt ("idProducto"),
                        rs.getString("tipoMovimiento"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("idUsuario") 
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (InventarioModel i) throws SQLException{
        String sql = "update inventario set id_producto=?, tipo_movimiento=?, cantidad=?, id_usuario=? where id_inventario=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
            ps.setInt(1, i.getIdProducto());
            ps.setString(2, i.getTipoMovimiento());
            ps.setInt(3, i.getCantidad());
            ps.setDate(4, java.sql.Date.valueOf(i.getFecha()));
            ps.setInt(5, i.getIdUsuario());
            
        ps.executeUpdate();
                     
        }
        }
       
        
        public void eliminar(int idInventario) throws SQLException{
        String sql= "delete from inventario where id_inventario=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idInventario);
            ps.executeUpdate();
        }
        }
}
        
   
