package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CarteInit implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Carte Init...");
    }
}
