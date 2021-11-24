package Client;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Client {
    private static int counter = 0;
    private int id;
    private String name;
    private int age;
    private Gender sex;
    private String Email = "";

    public Client(String email, String name) {
        id = counter;
        counter++;
        this.Email = email;
        this.name = name;
    }
}
