package com.carl.producer.handler;

import com.carl.producer.HelloServiceImpl;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @program: RPC
 * @description: 处理方法
 * @author: Mr.Carl
 **/
public class HandlerThread implements Runnable{

    private HelloServiceImpl service;

    private Socket socket;

    public HandlerThread(Socket client) {
        socket = client;
        service = new HelloServiceImpl();
        new Thread(this).start();
    }
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            //输入流
            InputStream input = socket.getInputStream();
            ObjectInputStream objInput = new ObjectInputStream(input);

            //反射实现方法的调用
            String methodName = objInput.readUTF();
            //参数类型
            Class<?>[] parameterTypes = (Class<?>[]) objInput.readObject();
            //具体参数
            Object[] arguments = (Object[]) objInput.readObject();
            //获取方法对象
            Method method = service.getClass().getMethod(methodName, parameterTypes);
            //方法调用
            Object result = method.invoke(service, arguments);

            //输出流
            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(output);
            objOutput.writeObject(result);

            //释放资源
            objInput.close();
            objOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
