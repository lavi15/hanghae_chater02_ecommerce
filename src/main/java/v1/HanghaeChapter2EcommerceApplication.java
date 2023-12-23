package v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "v1.controller.order","v1.controller.user","v1.controller.product",
                                "v1.domain.order","v1.domain.user","v1.domain.product",
                                "v1.entity.order", "v1.entity.user", "v1.entity.product"})
@EntityScan({ "v1.entity.order", "v1.entity.user", "v1.entity.product", "v1.entity"})
@EnableJpaRepositories({ "v1.entity.order", "v1.entity.user", "v1.entity.product"})
@EnableJpaAuditing
public class HanghaeChapter2EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeChapter2EcommerceApplication.class, args);
    }

}
