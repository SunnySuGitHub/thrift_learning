package Lesson1.Hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Component;
import thrift_generated.Hello;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/5/23
 */
public class HelloServer {

    public void init() throws TTransportException {
        //创建任意一种类型的TServerSocket
        TServerSocket serverSocket = new TServerSocket(7911);

        //server端创建protocal工厂。相比于客户端，客户端是new出来Protocal对象的
        //server端可以添加多种protocal工厂
        TCompactProtocol.Factory factory1 = new TCompactProtocol.Factory();
        TBinaryProtocol.Factory factory2 = new TBinaryProtocol.Factory();

        //创建处理器
        TProcessor processor = new Hello.Processor<>(new HelloServiceImpl());

        //构造参数形式，可在这里添加多个处理器与protocal工厂
        TThreadPoolServer.Args arg = new TThreadPoolServer
                .Args(serverSocket)
                .processor(processor)
                .protocolFactory(factory1)
                .protocolFactory(factory2);

        //创建serer端
        TServer server = new TThreadPoolServer(arg);
        System.out.println("Start server on port 7911...");
        server.serve();
    }


//    public static void main(String[] args) throws TTransportException {
//        //创建任意一种类型的TServerSocket
//        TServerSocket serverSocket = new TServerSocket(7911);
//
//        //server端创建protocal工厂。相比于客户端，客户端是new出来Protocal对象的
//        //server端可以添加多种protocal工厂
//        TCompactProtocol.Factory factory1 = new TCompactProtocol.Factory();
//        TBinaryProtocol.Factory factory2 = new TBinaryProtocol.Factory();
//
//        //创建处理器
//        TProcessor processor = new Hello.Processor<>(new HelloServiceImpl());
//
//        //构造参数形式，可在这里添加多个处理器与protocal工厂
//        TThreadPoolServer.Args arg = new TThreadPoolServer
//                .Args(serverSocket)
//                .processor(processor)
//                .protocolFactory(factory1)
//                .protocolFactory(factory2);
//
//        //创建serer端
//        TServer server = new TThreadPoolServer(arg);
//        System.out.println("Start server on port 7911...");
//        server.serve();
//    }
}
