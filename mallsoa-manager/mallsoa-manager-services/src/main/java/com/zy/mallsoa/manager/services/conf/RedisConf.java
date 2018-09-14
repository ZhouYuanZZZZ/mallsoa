package com.zy.mallsoa.manager.services.conf;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;


public class RedisConf implements EnvironmentAware {

    private Environment environment;


    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(environment.getProperty("redis.host"),Integer.parseInt(environment.getProperty("redis.port")));
        return jedisPool;
    }


    public JedisCluster jedisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        for (int i = 0; i <6 ; i++) {
            String host = environment.getProperty("redis.host" + i);
            String port = environment.getProperty("redis.port"+i);
            nodes.add(new HostAndPort(host,Integer.parseInt(port)));
        }
        JedisCluster jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
