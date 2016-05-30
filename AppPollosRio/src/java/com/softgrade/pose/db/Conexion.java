/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softgrade.pose.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Gabriela
 */
public class Conexion {
    private final static Logger log = Logger.getLogger(Conexion.class);
    public static Conexion instance; 
    private Connection cnn;
    
    private Conexion(){
        try {
            PropertyConfigurator.configure("log4j.properties");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //driver cambiar a archivo
            cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=acuerdate_HS__CHS", "aweb","aweb123.");
        } catch (ClassNotFoundException ex) {
            log.error(ex); //configurar Log
        } catch (SQLException ex) {
            log.error(ex);
        }
    }
   
    public synchronized static Conexion conectar(){
        if(instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
}
