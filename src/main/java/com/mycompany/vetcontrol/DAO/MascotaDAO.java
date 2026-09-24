/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.DAO;

import com.mycompany.vetcontrol.Modelo.ClienteModel;
import com.mycompany.vetcontrol.Modelo.MascotaModel;
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
public class MascotaDAO {
    
      public void insertar(MascotaModel m) throws SQLException {
         String sql = "insert into cliente(nombre, especie, raza, edad, duenio) values (?,?,?,?,?)";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getDuenio());
            
            ps.executeUpdate();
            try (ResultSet rs =  ps.getGeneratedKeys()) {
                if (rs.next()) {
                    m.setIdMascota(rs.getInt(1));
                }
            }
        }
    }
      
       public MascotaModel buscarporId(int idMascota) throws SQLException{
        String sql ="select idMascota, nombre, especie, raza, edad from cliente where id_mascota=?";
        try(Connection con = conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt(1, idMascota);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                return new MascotaModel(
                        rs.getInt ("idMascota"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),   
                        rs.getInt("duenio") 
                );        
            }
        }
        return null; 
        }
    }   
        public List<MascotaModel> listar() throws SQLException {
        List<MascotaModel> lista = new ArrayList<>();
        String sql = "select idMascota, nombre, especie, raza, edad, duenio from mascota";
        try (Connection con = conexion.obtener(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new MascotaModel(
                        rs.getInt ("idMascota"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),   
                        rs.getInt("duenio")      
                ));
            }

        }
        return lista;
    }
  
                   
public void actualizar (MascotaModel m) throws SQLException{
        String sql = "update mascota set nombre=?, especie=? raza=? edad=? duenio=? where id_mascota=?";
        try(Connection con = conexion.obtener();
        PreparedStatement ps = con.prepareCall(sql)){
        ps.setString(1, m.getNombre());
        ps.setString(2, m.getEspecie());
        ps.setString(3, m.getRaza());
        ps.setInt(4, m.getEdad());
        ps.setInt(5, m.getDuenio());
     ;
        ps.executeUpdate();
                     
        }
}

public void eliminar(int idMascota) throws SQLException{
        String sql= "delete from mascota where id_mascota=?";
        try(Connection con =conexion.obtener();
                PreparedStatement ps = con.prepareStatement (sql)){
            ps.setInt (1, idMascota);
            ps.executeUpdate();
        }
}
 
      
      
      
      
      
      
    
    
    
    
}
