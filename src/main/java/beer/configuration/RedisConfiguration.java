package beer.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfiguration.class);

    private @Value("${redis.app.host}") String redisHost;
    private @Value("${redis.app.port}") int redisPort;

    /**
     * We need to inject the PropertySourcesPlaceholderConfigurer bean if we want to use
     * Values otherwise it can not find them.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        LOGGER.info("****** PROPERTIES: HOST -> {}  PORT -> {} ", redisHost,  redisPort);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisHost);
        factory.setPort(redisPort);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    StringRedisTemplate redisTemplate() {
        LOGGER.info("*** INJECTING TEMPLATE ***");
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

}
