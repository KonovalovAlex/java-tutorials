package tutorials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test  {

    public static void main(String[] args) {

    }
    public void test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Ivan","Vasya","Petr"));
        persons.add(new Person(2,"Ivan","Vasya","Petr"));
        persons.add(new Person(3,"Ivan","Vasya","Petr"));
        persons.add(new Person(4,"Ivan","Gupta","Ivan"));
        persons.add(new Person(5,"Petr","Rama","Igor"));

        Collection<Person> uniquePersons = unique(persons);
        assert  uniquePersons.size() == 3;
    }

    //Unique collection by combination first-second-patronymicName
    public static Collection<Person> unique(List<Person> persons){
      return new ArrayList<>();
    }

}
class Person {

    public Integer id;
    public String firstName;
    public String secondName;
    public String patronymicName;

    public Person(Integer id, String firstName, String secondName, String patronymicName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
    }
}

class PersonWrapper {
    public String firstName;
    public String secondName;
    public String patronymicName;
}


