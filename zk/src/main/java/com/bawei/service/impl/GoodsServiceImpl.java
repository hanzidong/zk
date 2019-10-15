package com.bawei.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.bawei.dao.GoodsMapper;
import com.bawei.entity.Goods;
import com.bawei.service.GoodsService;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	@Resource
	private RedisTemplate<String, Goods> redisTemplate;
	
	/**
	 * 获取列表
	 */
	@Override
	public List<Goods> getList(Integer pageNum, Integer pageSize) {
		//原来数据库的
//		List<Goods> list = goodsMapper.selectObjects();
		
		ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		
		//根据分页获取redis中数据
		List<Goods> list = opsForList.range("goods_list",(pageNum - 1) * pageSize  , pageNum  * pageSize -1);
		
		return list;
	}

	/**
	 * 根据百分比获取数据
	 */
	@Override
	public List<Goods> getSellList(Integer pageNum, Integer pageSize) {
		
		List<Goods> list = new ArrayList<Goods>();
		
		ZSetOperations<String, Goods> opsForZSet = redisTemplate.opsForZSet();
		
		//根据分页获取redis中数据
		Set<Goods> set = opsForZSet.reverseRange("goods_zset", (pageNum - 1) * pageSize  , pageNum  * pageSize -1);
		
		//存放到list中
		list.addAll(set);
		
		return list;
	}

	@Override
	public Integer getCounts() {
		ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		
		Long size = opsForList.size("goods_list");
		
		return size.intValue();
	}

}
