package com.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.IMovieDao;

@RunWith(SpringRunner.class)
@SpringBootTest
 //@ContextConfiguration(classes=MovieDaoImpl.class)
public class SpringUnitTestDao {
	@Autowired
	private IMovieDao dao;
	@Test
	public void testFindAllMovies()
	{
		assertEquals(20, dao.findAll().size());
	}

}
