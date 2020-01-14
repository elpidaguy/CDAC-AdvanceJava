package com.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.service.SomeBusinessService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringUnitTestService {
	@Autowired
	private SomeBusinessService service;

	@Test
	public void testCalcSum() {
		assertEquals(service.calcSum(1, 2, 3, 4), 10);
	}

}
