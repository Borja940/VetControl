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
    
  
    private static final String URL ="jdbc:mysql://localhost:3306/vetControl";
    private static final String USER = "root";
    private static final String PASSWORD ="1981borja";
   

  
     public static Connection obtener() throws SQLException{
         
        return DriverManager.getConnection(URL, USER, PASSWORD);
    
     
}
}

