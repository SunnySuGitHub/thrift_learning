package Lesson1.Hello;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift_generated.Hello;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/5/23
 */
public class HelloClient {
    public static void main(String[] args) {
        TTransport tTransport = null;
        try{
            // 创建客户端Socket
            tTransport = new TSocket("localhost", 7911);
            tTransport.open();

            //创建TProtocal对象
            TProtocol protocol = new TBinaryProtocol(tTransport);

            //创建需要调用服务的客户端对象，客户端只需要由生成的Hello文件即可，不需要拥有实现Hello的ServiceImpl类
            Hello.Client client = new Hello.Client(protocol);
            System.out.println(client.helloString("suxinyu"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tTransport.close();
        }
    }
}
