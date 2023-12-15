package v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "v1.controller.*", "v1.domain.*", "v1.entity.*"})
@EntityScan({ "v1.entity.*"})
@EnableJpaRepositories({ "v1.entity.*"})
@EnableJpaAuditing
public class HanghaeChapter2EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeChapter2EcommerceApplication.class, args);
    }

}
