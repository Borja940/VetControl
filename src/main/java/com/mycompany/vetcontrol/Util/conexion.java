/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Util;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andy-
 */
public class conexion {
    
    private static final String DATABASE = "VetControl";
    
    
    private static final String URL ="";
    private static final String USER = "";
    private static final String PASSWORD ="";
    
}
    
     public static Connection obtener() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    
        
    
}
