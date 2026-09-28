/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcontrol.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author andy-
 */
public class Encriptador {
    
    
        public static String convertToSHA256(String passwordTextoPlano) {
        try {
           //invoca el motor encriptador nativo de java configurado con las reglas de SHA-256.
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
           //concivierte el texto plano en un arreglo de bytes utilizando la codificación universal UTF-8
            byte[] hash = digest.digest(passwordTextoPlano.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            
            //Recorremos cada uno de los 32 bytes resultantes para formatearlos a formato Hexadecimal Base 16: 0-9 y A-F.
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                
                // le agregamos un cero a la izquierda ("0a") para que todos los bloques midan exactamente lo mismo.
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);//Pegamos el par de caracteres al texto final que se está construyendo
            }
            return hexString.toString();  //Retorna la cadena de texto de 64 caracteres en minúsculas lista para enviarse a la base de datos de Aiven.
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }
}

    
    
    

