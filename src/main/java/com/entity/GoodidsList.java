package com.entity;

import java.util.List;

public class GoodidsList {
	private List<Integer> list;

	@Override
	public String toString() {
		return "GoodidsList [list=" + list + "]";
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public GoodidsList(List<Integer> list) {
		super();
		this.list = list;
	}

	public GoodidsList() {
		super();
		// TODO Auto-generated constructor stub
	}

}
