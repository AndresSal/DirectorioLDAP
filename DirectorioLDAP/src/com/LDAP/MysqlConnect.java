/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDAP;
import java.sql.*;
import javax.swing.*;
 
/**
 *
 * @author andres
 */
public class MysqlConnect {
 Connection conn = null;
 public static Connection ConnectDB()
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/base_CD","root","Andres-Mysql10");
         System.out.println("Conectado a la base de datos");
     }catch(Exception e)
     {
         System.out.println(e);
     }
     return null;
 }
}
