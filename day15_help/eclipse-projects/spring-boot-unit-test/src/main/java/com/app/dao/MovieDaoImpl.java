package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Movie;

@Repository
@Transactional
public class MovieDaoImpl implements IMovieDao {
	
@PersistenceContext
private EntityManager mgr;
	@Override
	public List<Movie> findAll() {
		String jpql = "select m from Movie m";
		return mgr.createQuery(jpql, Movie.class).getResultList();
	}

	@Override
	public String addMovie(Movie m) {
		mgr.persist(m);
		return "Movie added successfully with ID " + m.getId();
	}

	@Override
	public String deleteMovie(int id) {
		
		Movie m = mgr.find(Movie.class, id);
		if (m != null) {
			mgr.remove(m);
			return "Movie with ID " + id + " deleted";
		} else 
			return "Movie deletion failed";
	}

}
