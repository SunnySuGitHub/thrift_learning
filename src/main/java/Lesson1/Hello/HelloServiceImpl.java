package Lesson1.Hello;

import org.apache.thrift.TException;
import thrift_generated.Hello;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/5/23
 */
public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return para;
    }
}
