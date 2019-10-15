package com.bawei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bawei.entity.Goods;
import com.bawei.service.GoodsService;
import com.bawei.util.PageModel;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	/**
	 * 获取商品列表
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getList")
	public String getList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		
		//获取商品列表
		List<Goods> list = goodsService.getList(pageNum,pageSize);
		request.setAttribute("list", list);
		
		//获取商品数量
		Integer count = goodsService.getCounts();
		
		//分页
		PageModel pm = new PageModel(pageNum +"", count, pageSize);
		request.setAttribute("pm", pm);
		
		return "goods_list";
	}
	
	/**
	 * 根据销售百分比获取商品列表
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	
	@RequestMapping("/getSellList")
	public String getSellList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		
		//获取商品列表
		List<Goods> list = goodsService.getSellList(pageNum,pageSize);
		request.setAttribute("list", list);

		//获取列表数量
		Integer count = goodsService.getCounts();
		
		//分页
		PageModel pm = new PageModel(pageNum +"", count, pageSize);
		request.setAttribute("pm", pm);
		
		return "goods_sell_list";
	}

}
