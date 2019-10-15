package com.bawei;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.entity.Goods;
import com.mmcro.common.FileUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class GoodsTest {

	@Resource
	private RedisTemplate<String, Goods> redisTemplate;
	
	
	@Test
	public void getGoods() throws IOException, NumberFormatException, ParseException {
		
		ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		
		ZSetOperations<String, Goods> opsForZSet = redisTemplate.opsForZSet();
		
		Goods goods = null;

		String string = FileUtil.readFile("123.txt");
		
		String[] split = string.split("\n");
		
		System.out.println(string);
		
		for (String str : split) {
			String[] ss = str.split(",");
			
			Double sell = (Double)NumberFormat.getPercentInstance().parse(ss[3]);
			
			goods = new Goods();
			goods.setId(Integer.parseInt(ss[0]));		
			goods.setName(ss[1]);		
			goods.setPrice(Double.parseDouble(ss[2]));	
			goods.setSell(sell);		
			
			opsForList.leftPush("goods_list", goods);
			opsForZSet.add("goods_zset", goods, sell);		
			
		}
		
		System.out.println("转换完毕");
		
		
	}
	
}
