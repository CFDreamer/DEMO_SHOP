package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Test;
import com.mapper.TestMapper;

@Service
public class TestService {
  @Autowired
  private TestMapper t;
  public Test selectOne(Integer id) {
	  return t.seletOne(id);
  }
}
