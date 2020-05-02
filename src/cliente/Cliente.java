/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.net.*;
import java.io.*;

public class Cliente {
    

    public static void main(String args[]) throws IOException {
        Socket s = new Socket("localhost",1230);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        System.out.println("Servidor conectado");
        String mensaje = "";
        System.out.println("Envie mensaje: ");
        mensaje = in.readLine();
        bw.write(mensaje+"\n");     
        bw.flush();
        
        String line = "";
        while ((line = br.readLine()) != null){
               System.out.println("Mensaje del servidor:"+line);
        }

        bw.close();
        br.close();
        s.close();
    }
}