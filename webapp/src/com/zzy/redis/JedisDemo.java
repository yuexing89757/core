package com.zzy.redis;

import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class JedisDemo {  

    @SuppressWarnings("unchecked") 
    public void testDeom(){

        Jedis  jedis = new Jedis ("localhost",6379);//连接redis 
        // 向key-->name中放入了value-->minxr  
        jedis.set("name", "minxr");  
        String ss = jedis.get("name");  
        System.out.println(ss);  

        // 很直观，类似map 将jintao append到已经有的value之后  
        jedis.append("name", "jintao");  
        ss = jedis.get("name");  
        System.out.println(ss);  

        // 2、直接覆盖原来的数据  
        jedis.set("name", "jintao");  
        System.out.println(jedis.get("jintao"));  

        // 删除key对应的记录  
        jedis.del("name");  
        System.out.println(jedis.get("name"));// 执行结果：null  

        /** 
         * mset相当于 jedis.set("name","minxr"); jedis.set("jarorwar","aaa"); 
         */  
        jedis.mset("name", "minxr", "jarorwar", "aaa");  
        System.out.println(jedis.mget("name", "jarorwar"));  
    }
    
    
    private void testKey() {  
    	   Jedis  jedis =JedisUtil.getInstance().getJedis("localhost",6379);//new Jedis ("localhost",6379);
        System.out.println("=============key==========================");  
        // 清空数据  
        System.out.println(jedis.flushDB());  
        System.out.println(jedis.echo("foo"));  
        // 判断key否存在  
        System.out.println(jedis.exists("foo"));  
        jedis.set("key", "values");  
        System.out.println(jedis.exists("key"));  
        
        
        // 追加数据  
        jedis.append("foo", " hello, world");  
        System.out.println(jedis.get("foo"));  
        // 设置key的有效期，并存储数据  
        jedis.setex("foo", 2, "foo not exits");  
        System.out.println(jedis.get("foo"));  
        try {  
            Thread.sleep(3000);  
        } catch (InterruptedException e) {  
        }  
        System.out.println(jedis.get("foo"));  
        // 获取并更改数据  
        jedis.set("foo", "foo update");  
        System.out.println(jedis.getSet("foo", "foo modify"));  
        
        
  
    }  
    
    
   void testList(){
	   Jedis  jedis = new Jedis ("localhost",6379);
	   System.out.println(jedis.flushDB());  
       // 添加数据  
        jedis.lpush("lists", "vector");  
        jedis.lpush("lists", "ArrayList");  
        jedis.lpush("lists", "LinkedList");  
        // 数组长度  
        System.out.println(jedis.llen("lists"));  
        // 排序  
       // System.out.println(jedis.sort("lists"));  
        // 字串  
        System.out.println(jedis.lrange("lists", 0, 3));  
        
        
        // 修改列表中单个值  
        jedis.lset("lists", 0, "hello list!");  
        // 获取列表指定下标的值  
        System.out.println(jedis.lindex("lists", 0)); 
        
        
        // 删除列表指定下标的值  
        System.out.println(jedis.lrem("lists", 1, "vector"));  
        // 删除区间以外的数据  
        System.out.println(jedis.ltrim("lists", 0, 1));  
        
        // 列表出栈  
        System.out.println(jedis.lpop("lists"));  
        // 整个列表值  
        System.out.println(jedis.lrange("lists", 0, -1));  
   }
    
    
    
    public static void main(String[] args)  throws Exception{         
        JedisDemo jedis = new JedisDemo();  
       // jedis.testDeom();  
       // jedis.testKey();
        jedis.testList();
    }  
  
}