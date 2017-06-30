/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDAP;

/**
 *
 * @author andres
 */
public class Aplicacion {
    public static void main(String args[])
    {
        LogIn n = new LogIn();
        String nombre = "andres";
        String password = "andres";
        
        n.Conectar(nombre, password);
    }
}
