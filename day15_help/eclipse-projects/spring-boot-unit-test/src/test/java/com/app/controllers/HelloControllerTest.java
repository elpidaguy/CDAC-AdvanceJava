package com.app.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class) //MANDATORY
@AutoConfigureMockMvc
@SpringBootTest
public class HelloControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSimpleHelloWorld() throws Exception {
		// create mock http servlet request
		RequestBuilder builder = MockMvcRequestBuilders.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getStatus());
		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
