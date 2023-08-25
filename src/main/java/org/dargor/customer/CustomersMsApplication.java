package org.dargor.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("org.dargor.customer.core.entity")
@ComponentScan({
        "org.dargor.customer.app.controller",
        "org.dargor.customer.app.service",
        "org.dargor.customer.app.config",
        "org.dargor.customer.app.exception",
        "org.dargor.customer.core.repository"

})
@EnableFeignClients("org.dargor.customer.app.client")
@EnableJpaRepositories("org.dargor.customer.core.repository")
@SpringBootApplication
public class CustomersMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersMsApplication.class, args);
    }

}
