package com.carl.bio.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: RPC
 * @description: 服务端'
 * @author: Mr.Carl
 **/
public class demo1 {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line ;
        if ((line=br.readLine())!=null){
            System.out.println(line);
        }
        inputStream.close();
        br.close();

    }
}
