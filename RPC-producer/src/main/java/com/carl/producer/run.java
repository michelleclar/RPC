package com.carl.producer;

import com.carl.HelloService;
import com.carl.producer.handler.HandlerThread;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: RPC
 * @description: 生产者
 * @author: Mr.Carl
 **/
public class run {
    public static void main(String[] args) throws Exception {
        //建立socket通信
        HelloService service = new HelloServiceImpl();
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server started!");

        while (true) {
            //等待连接
            Socket socket = server.accept();
            new HandlerThread(socket);
//            //输入流
//            InputStream input = socket.getInputStream();
//            ObjectInputStream objInput = new ObjectInputStream(input);
//
//            //反射实现方法的调用
//            String methodName = objInput.readUTF();
//            //参数类型
//            Class<?>[] parameterTypes = (Class<?>[]) objInput.readObject();
//            //具体参数
//            Object[] arguments = (Object[]) objInput.readObject();
//            //获取方法对象
//            Method method = service.getClass().getMethod(methodName, parameterTypes);
//            //方法调用
//            Object result = method.invoke(service, arguments);
//
//            //输出流
//            OutputStream output = socket.getOutputStream();
//            ObjectOutputStream objOutput = new ObjectOutputStream(output);
//            objOutput.writeObject(result);
//
//            //释放资源
//            objInput.close();
//            objOutput.close();
        }
    }
}
