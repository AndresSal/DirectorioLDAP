/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDAP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class MultiThreadServer extends Thread {
    private Socket socket = null;

    public MultiThreadServer(Socket socket) 
    {
        super("MultiThreadServer");
        this.socket = socket;
    }
    
    public void run()
    {
        try
        (
            //medio para enviar lo que escribo
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            //medio para recibir lo que manda el cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        )     
        {
            //string escrito
            String inputline;
            //string leido
            String outputline="";
            //hasta que lea todo el string sea leido
            while ((inputline = in.readLine())!=null)
            {
                //--------------------------------------------------------------
                //AQUI LA CONEXION A LA BASE DE DATOS
                
                LogIn nuevaconexion = new LogIn();
                nuevaconexion.Conectar(inputline, inputline);
                
                
                //--------------------------------------------------------------
                
                //imprime lo que manda el cliente
                System.out.println(inputline);
                //medio para escribir en archivo
                PrintWriter database = new PrintWriter(new FileWriter ("03.txt",true));
                //escribo lo que el cliente mando
                database.println(inputline);
                //instancia de la clase cesar
                CeasarEncryption cesar = new CeasarEncryption();
                //escribo en el socket el mensaje cifrado
                out.println(cesar.Encriptar(inputline));
                //lo hago hasta que lea salir
                if (inputline.equals("salir"))
                {
                    outputline="chao";
                    out.println(outputline);
                    break;
                }
                    
                //escribo en el archivo el cifrado
                database.println(cesar.Encriptar(inputline));
                //cierro el archivo
                database.close();
            }
            //cierro el socket
            socket.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
