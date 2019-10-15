package com.bawei.entity;

import java.io.Serializable;

public class Goods implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8422483747320647462L;
	private Integer id;
	private String name;
	private Double price;
	private Double sell;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSell() {
		return sell;
	}
	public void setSell(Double sell) {
		this.sell = sell;
	}
	public Goods(Integer id, String name, Double price, Double sell) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sell = sell;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", sell=" + sell + "]";
	}
	
	
}
