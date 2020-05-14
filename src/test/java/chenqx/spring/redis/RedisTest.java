package chenqx.spring.redis;

import chenqx.pojo.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chenqx 2019-09-29
 * @instruction
 */
public class RedisTest {
    @Test
    public void should_redis(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        Book book = new Book("liucx","santi");
        redisTemplate.opsForValue().set("book_1", book);
        Book book1 = (Book) redisTemplate.opsForValue().get("book_1");
        book1.service();
    }
    @Test
    public void ss(){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        JedisPoolConfig redisTemplate = context.getBean(JedisPoolConfig.class);
    }
}
