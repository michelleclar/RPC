package com.carl.consumers;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: RPC
 * @description: 消费者
 * @author: Mr.Carl
 **/
public class run {

    public static void main(String[] args) throws Exception {
        //创建端口
        Socket socket = new Socket("localhost", 8888);
        //得到socket的输出流
        OutputStream output = socket.getOutputStream();
        //序列化
        ObjectOutputStream objOutput = new ObjectOutputStream(output);
        //向输出流写入序列化对象
        //方法名
        objOutput.writeUTF("sayHello");
        //方法参数类型
        objOutput.writeObject(new Class<?>[] { String.class });
        //方法参数
        objOutput.writeObject(new Object[] { "producer" });
        //得到socket的输入流
        InputStream input = socket.getInputStream();
        //序列化
        ObjectInputStream objInput = new ObjectInputStream(input);
        //得到输入流数据   服务端--->客户端
        Object result = objInput.readObject();
        //结果进行输出
        System.out.println(result);
        //关闭流
        objInput.close();
        objOutput.close();
    }
}
