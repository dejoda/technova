package gm.technova;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123*"));
        System.out.println(encoder.encode("vendedor123*"));
        System.out.println(encoder.encode("cliente123*"));
    }
}