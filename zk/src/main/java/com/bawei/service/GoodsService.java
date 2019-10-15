package com.bawei.service;

import java.util.List;

import com.bawei.entity.Goods;

public interface GoodsService {

	List<Goods> getList(Integer pageNum, Integer pageSize);

	List<Goods> getSellList(Integer pageNum, Integer pageSize);

	Integer getCounts();
	
	
}
