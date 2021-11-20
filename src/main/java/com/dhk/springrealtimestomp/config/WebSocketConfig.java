package com.dhk.springrealtimestomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 커넥션을 위한 엔드포인트 설정
        registry.addEndpoint("/sub").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // /test이하 경로의 STOMP메시지의 destination헤더는 @MessageMapping으로 라우팅된다.
        registry.setApplicationDestinationPrefixes("/test");

        registry.enableSimpleBroker("/topic", "queue");
    }
}
