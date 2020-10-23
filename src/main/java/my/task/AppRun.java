package my.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class);
    }
}
