package me.huynhducphu.producer.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Admin 1/21/2026
 *
 **/

@RestController
public class ProducerController {

    private final StreamBridge streamBridge;

    public ProducerController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish")
    public ResponseEntity<Void> publishMessage() {


        String msg = "Hi, mình là Huỳnh Đức Phú - 22653551";

        streamBridge.send("huynhDucPhu-out-0", msg);
        System.out.println("Đã gửi tin nhắn đến consumer");

        return ResponseEntity.ok().build();
    }
}