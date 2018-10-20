package com.entity;

public class Test {
	private Integer id;
	private String test;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Test(Integer id, String test) {
		super();
		this.id = id;
		this.test = test;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", test=" + test + "]";
	}

}
