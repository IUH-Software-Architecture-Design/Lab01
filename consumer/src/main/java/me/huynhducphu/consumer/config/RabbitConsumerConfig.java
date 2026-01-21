package me.huynhducphu.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * Admin 1/21/2026
 *
 **/
@Configuration
public class RabbitConsumerConfig {

    @Bean
    public Consumer<String> huynhDucPhu() {
        return message -> {
            System.out.println("Nhận tin nhắn từ producer: " + message);
        };
    }

}
