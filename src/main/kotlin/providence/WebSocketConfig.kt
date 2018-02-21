package providence

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker


@EnableWebSocketMessageBroker
@Configuration
open class WebSocketConfig : AbstractWebSocketMessageBrokerConfigurer() {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/providence").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry?) {
        registry!!.setApplicationDestinationPrefixes("/app")
        registry.enableSimpleBroker("/topic")
    }
}