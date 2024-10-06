package lk.ijse.possystembackendwithspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.possystembackendwithspring")
@EnableWebMvc
public class WebAppConfig {
}
