/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andres
 */
public class LogIn {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public void Conectar(String nombre, String password)
    {
        conn = MysqlConnect.ConnectDB();
        String script = "SELECT * FROM base_CD WHERE nombrePersona='"+nombre+"' and password='"+password+"'";
        try
        {
            
            pst=conn.prepareStatement(script);
            rs=pst.executeQuery();
            if(rs.next())
            {
                System.out.println("Usuario permitido. \n Bienvenido "+nombre);
            }
            else
            {
                System.out.println("Usuario no admitido.");
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
}
