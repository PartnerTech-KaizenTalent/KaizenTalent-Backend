package pe.partnertech.kaizentalent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KaizenTalentApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaizenTalentApplication.class, args);
    }

}
