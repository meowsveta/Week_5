import java.util.concurrent.atomic.AtomicInteger;

public class User  {

//    public User(int idUser, int age, String name, String city, Date birthday) {
//        this.idUser = idUser;
//        this.age = age;
//        this.name = name;
//        this.city = city;
//        this.birthday = birthday;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public User(int age, String name, String city, int id ) {
        this.age = age;
        this.name = name;
        this.city = city;
        this.id = id;
    }

    int age;
    String name;
    String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;



}
