package com.zy.mallsoa.manager.services.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(WebApplicationTests.class);

	@Resource
	private JedisPool jedisPool;

	private Jedis jedis;

	@Test
	public void contextLoads() {
	}

	@Before
	public void before(){
		jedis = jedisPool.getResource();
	}

	@After
	public void after(){
		jedis.close();
	}

	@Test
	public void testConnect(){
		//连接本地的 Redis 服务
		Jedis jedis = jedisPool.getResource();
		//查看服务是否运行，打出pong表示OK
		logger.info("connection is OK==========>: "+jedis.ping());
		jedis.close();
	}

	@Test
	public void testString(){

		for(int i=0;i<100;i++){
			jedis.set("k"+i,"v"+i);
		}

		Set<String> keys = jedis.keys("*");
		for (String key:keys) {
			logger.info(key);
		}
		logger.info("--------------------------0-----------------------------------");
		logger.info("jedis.exists====>"+jedis.exists("k2"));
		logger.info(jedis.ttl("k1")+"");
		logger.info(jedis.get("k1"));
		jedis.set("k4","k4_redis");
		logger.info(jedis.get("k4"));

		logger.info("--------------------------1-----------------------------------");
		jedis.mset("str1","v1","str2","v2","str3","v3");
		List<String> mgets = jedis.mget("str1", "str2", "str3");
		logger.info(mgets.toString());
	}

	@Test
	public void testList(){
		jedis.lpush("list1","a","b","c","d","e");
		List<String> list1 = jedis.lrange("list1", 0, -1);
		logger.info(list1.toString());
	}

	@Test
	public void testSet(){
		jedis.sadd("orders","jd001");
		jedis.sadd("orders","jd002");
		jedis.sadd("orders","jd003");

		Set<String> set1 = jedis.smembers("orders");

		logger.info(set1.toString());
	}

	@Test
	public void testHash(){
		jedis.hset("hash1","userName","lisi");
		logger.info(jedis.hget("hash1","userName"));

		Map<String,String> map = new HashMap<String,String>();
		map.put("telphone","13811814763");
		map.put("address","atguigu");
		map.put("email","abc@163.com");
		jedis.hmset("hash2",map);

		List<String> result = jedis.hmget("hash2", "telphone","email");
		for (String element : result) {
			logger.info(element);
		}

	}

	@Test
	public void testZSet(){
		//zset
		jedis.zadd("zset01",60,"v1");
		jedis.zadd("zset01",80,"v3");
		jedis.zadd("zset01",70,"v2");
		jedis.zadd("zset01",90,"v4");

		Set<String> s1 = jedis.zrange("zset01",0,-1);
		for (Iterator iterator = s1.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			logger.info(string);
		}

	}

	@Test
	public void testTransaction() {


		//监控key，如果该动了事务就被放弃
 /*3
 jedis.watch("serialNum");
 jedis.set("serialNum","s#####################");
 jedis.unwatch();*/

		Transaction transaction = jedis.multi();//被当作一个命令进行执行
		transaction.set("serialNum", "s002");
		Response<String> response = transaction.get("serialNum");
		transaction.lpush("list3", "a");
		transaction.lpush("list3", "b");
		transaction.lpush("list3", "c");

		transaction.exec();
		//2 transaction.discard();
		System.out.println("serialNum***********" + response.get());

	}


}
