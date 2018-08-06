package com.zy.mallsoa.manager.services.conf;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConf implements EnvironmentAware {

    private Environment environment;

    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(environment.getProperty("redis.host"),Integer.parseInt(environment.getProperty("redis.port")));
        return jedisPool;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
