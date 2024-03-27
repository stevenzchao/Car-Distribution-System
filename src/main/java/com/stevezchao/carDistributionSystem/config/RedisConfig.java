package com.stevezchao.carDistributionSystem.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
@EnableCaching
public class RedisConfig {

    //你可以将读取策略，设置为 ReadFrom.REPLICA 表示只从 slave 节点读取数据
    //然后你把 slave 节点全部停掉，然后看看是否能够读取成功
    @Bean
    public LettuceClientConfigurationBuilderCustomizer redisClientConfig() {
        //配置 redisTemplate 优先从 slave 节点读取数据，如果 slave 都宕机了，则从 master 读取
        return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);

        //配置 redisTemplate 优先从 slave 节点读取数据，如果 slave 都宕机了，则抛出异常
        //return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        //默认的Key序列化器为：JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }
}
