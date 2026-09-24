/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.ProductoModel;
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
public class ProductosDAO {
    
     public void insertar(ProductoModel p) throws SQLException {
         String sql = "insert into cita (codigo, nombre, stock, precio, stock_minimo, fecha_vencimiento) values (?,?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getStock());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStockMinimo());
            ps.setDate(6, java.sql.Date.valueOf(p.getFechaVencimiento()));
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setIdProducto(rs.getInt(1));
                }
            }
        }
    }
    
        public ProductoModel buscarporId(int idProducto) throws SQLException{
        String sql ="select id_producto, codigo, nombre, stock, precio, stock_minimo, fecha_vencimiento from producto where id_producto=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idProducto);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new ProductoModel(
                        rs.getInt ("idProducto"),
                        rs.getString("codigo"),
                        rs.getString("nombre"), 
                        rs.getInt("stock"),
                        rs.getDouble("precio"), 
                        rs.getInt("stockMinimo"),
                        rs.getDate("fechaVencimiento").toLocalDate()
                        
                );        
                      
            }
        }
        return null; 
        }   
    } 
        
        public List<ProductoModel> listar() throws SQLException {
        List<ProductoModel> lista = new ArrayList<>();
        String sql = "select id_producto codigo, nombre, stock, precio, stock_minimo, fecha_vencimiento from producto";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new ProductoModel(
                        rs.getInt("idProducto"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),  
                        rs.getInt("stock"),
                        rs.getDouble("precio"), 
                        rs.getInt("stockMinimo"), 
                        rs.getDate("fechaVencimiento").toLocalDate()
                ));
            }

        }
        return lista;
    }
  
        
        
        public void actualizar (ProductoModel p) throws SQLException{
        String sql = "update producto set codigo=?, nombre=?, stock=?, precio=?, stock_minimo, fecha_vencimiento where id_producto=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
        ps.setString(1, p.getCodigo());
        ps.setString(2, p.getNombre());
        ps.setInt(3, p.getStock());
        ps.setDouble(4, p.getPrecio());
        ps.setInt(5, p.getStockMinimo());
        ps.setDate(6, java.sql.Date.valueOf(p.getFechaVencimiento()));
        ps.executeUpdate();
                     
        }
        }
       
        
        public void eliminar(int idProducto) throws SQLException{
        String sql= "delete from producto where id_producto=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idProducto);
            ps.executeUpdate();
        }
        }
}
        
    
    
    
    

