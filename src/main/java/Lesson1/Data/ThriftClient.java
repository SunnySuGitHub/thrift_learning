package Lesson1.Data;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift_generated.Person;
import thrift_generated.PersonService;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/3/14
 */
public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", 9000), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try{
            transport.open();
            Person person = client.getPersonByUsername("suxinyu");
            System.out.println(person.isMarried());
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            transport.close();
        }
    }
}
