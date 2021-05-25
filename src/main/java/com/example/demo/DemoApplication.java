package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        builder.bannerMode(Banner.Mode.CONSOLE);
//        return super.configure(builder);
        return builder.sources(SpringApplication.class);
    }

    public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class, args);
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        app.run(args);
    }

//    @Bean  //앱 구동 후 바로 동작
//    public ApplicationListener<ContextRefreshedEvent> startupListener() {
//        return new ApplicationListener<ContextRefreshedEvent>() {
//            public void onApplicationEvent(ContextRefreshedEvent event) {
//                System.out.println(" - Start to listen : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
//                System.out.println(" - Porject build : 하하하");
//            }
//        };
//    }

}
