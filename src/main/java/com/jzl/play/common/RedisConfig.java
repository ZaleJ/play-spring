package com.jzl.play.common;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/8/16 17:33
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class RedisConfig {
    @Bean
    public RedisTemplate<Integer, Object> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<Integer, Object> template = new RedisTemplate<>();

        template.setKeySerializer(new MyRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    class MyRedisSerializer implements RedisSerializer<Integer> {
        @Override
        public byte[] serialize(java.lang.Integer integer) throws SerializationException {
            return integer.toString().getBytes();
        }

        @Override
        public Integer deserialize(byte[] bytes) throws SerializationException {
            String s = new String(bytes);
            return java.lang.Integer.valueOf(s);
        }
    }

//    class MyValueRedisSerializer<T> implements RedisSerializer<T> {
//
//        @Override
//        public byte[] serialize(T t) throws SerializationException {
//            return JSON.toJSONString(t).getBytes();
//        }
//
//        @Override
//        public T deserialize(byte[] bytes) throws SerializationException {
//            JSON.parseArray()
//            return null;
//        }
//    }
}
