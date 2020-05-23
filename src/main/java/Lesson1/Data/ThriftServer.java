package Lesson1.Data;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift_generated.PersonService;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/3/14
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception{

        PersonServiceImpl service = new PersonServiceImpl();
        TProcessor processor = new PersonService.Processor<>(service);
        new Thread(() -> {
            try {
                test1(processor);
            } catch (TTransportException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static void test1(TProcessor processor) throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(9000);
        THsHaServer.Args args = new THsHaServer.Args(socket).processor(processor).protocolFactory(new TCompactProtocol.Factory());
        THsHaServer server = new THsHaServer(args);
        System.out.println("server start!");
        server.serve();
    }
}
