package com.ingress.mytransactional;

import com.ingress.mytransactional.dto.StudentRequestDTO;
import com.ingress.mytransactional.services.StudentTransactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@AllArgsConstructor
@SpringBootApplication
@EnableAspectJAutoProxy
public class MytransactionalApplication implements CommandLineRunner {

    private final StudentTransactional studentTransactional;

    public static void main(String[] args) {
        SpringApplication.run(MytransactionalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentTransactional.rollbackOnlyUnchecked();

        studentTransactional.rollbackChecked();
    }
}
