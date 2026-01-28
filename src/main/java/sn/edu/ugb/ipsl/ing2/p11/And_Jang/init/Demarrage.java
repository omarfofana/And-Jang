package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Demarrage implements CommandLineRunner {
    @Value("${And_Jang.admin.name}")
    private String adminName;

    @Value("${And_Jang.admin.email}")
    private String adminEmail;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Demarrage de l'application");
        System.out.println("Envoie notification à " + adminName+ " "+ adminEmail);

    }
}
