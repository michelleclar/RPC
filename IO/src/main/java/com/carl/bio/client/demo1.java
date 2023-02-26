package com.carl.bio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.WritePendingException;

/**
 * @program: RPC
 * @description: 阻塞式io
 * @author: Mr.Carl
 **/
public class demo1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream pw = new PrintStream(outputStream);
        pw.println("helloIO");
        outputStream.close();
        pw.close();

    }
}
