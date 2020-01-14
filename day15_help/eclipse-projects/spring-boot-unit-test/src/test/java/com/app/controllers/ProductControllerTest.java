package com.app.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.controller.ProductController;

@RunWith(SpringRunner.class)
@WebMvcTest({ ProductController.class })
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldTest() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.get("/products/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getContentAsString()).contains("Hello Controller Testing");
	}

	// checking JSON
	@Test
	public void getProductTest() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.
				get("/products/10").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andExpect(status().isOk())
				.andExpect(content().json("{\"name\":\"Prod10\",\"price\":11000.0,\"expDate\":\"2019-06-10\"}"))
				.andReturn();

	}

}
