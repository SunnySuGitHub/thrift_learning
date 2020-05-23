package Lesson1.Data;

import org.apache.thrift.TException;
import thrift_generated.DataException;
import thrift_generated.Person;
import thrift_generated.PersonService;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/3/14
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws TException {
        System.out.println("get method got info from client");
        Person person = new Person();
        person.setAge(23);
        person.setMarried(false);
        person.setUsername("suxinyu");
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("void method got info from client");
        System.out.println(person.getAge());
        System.out.println(person.getUsername());
        System.out.println(person.isMarried());
    }
}
