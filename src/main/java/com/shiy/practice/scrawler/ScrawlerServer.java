package com.shiy.practice.scrawler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(
        basePackages = {
                "com.shiy.practice.scrawler.entity"
        }
)
@Slf4j
public class ScrawlerServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .sources(ScrawlerServer.class)
                .profiles("application.properties")
                .run(args);
    }

}
