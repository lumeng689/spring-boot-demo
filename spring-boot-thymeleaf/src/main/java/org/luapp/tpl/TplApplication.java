package org.luapp.tpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        exclude ={
                DataSourceAutoConfiguration.class
        }
)
@ComponentScan("org.luapp.tpl")
public class TplApplication {

    public static void main(String[] args) {
        SpringApplication.run(TplApplication.class, args);
    }
}
