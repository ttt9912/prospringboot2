package ch9.jms.remote.activemq.consumer;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class TodoConsumerConfig {

    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setErrorHandler(new TodoErrorHandler());
        configurer.configure(containerFactory, connectionFactory);
        return containerFactory;
    }


    /*
     * register a validator (oprional)
     */
    @Configuration
    static class MethodListenerConfig implements JmsListenerConfigurer {
        @Override
        public void configureJmsListeners(final JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar) {
            jmsListenerEndpointRegistrar.setMessageHandlerMethodFactory(todoMessageHandlerMethodFactory());
        }

        @Bean
        public DefaultMessageHandlerMethodFactory todoMessageHandlerMethodFactory() {
            DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
            factory.setValidator(new TodoValidator());
            return factory;
        }
    }
}
