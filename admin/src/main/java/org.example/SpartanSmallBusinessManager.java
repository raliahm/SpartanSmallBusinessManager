package admin.src.main.java.org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpartanSmallBusinessManager {

    public static void main(String[] args) {
        SpringApplication.run(SpartanSmallBusinessManager.class, args);
    }

}