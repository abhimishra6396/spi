package iaik.at.groupsignature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApp {
    public static void main(String[] args){
        //MainActivity sg = new MainActivity();
        //sg.getSign();

        SpringApplication.run(ClientApp.class, args);
    }
}
