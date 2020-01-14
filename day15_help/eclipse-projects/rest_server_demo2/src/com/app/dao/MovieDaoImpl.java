package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Movie;

@Repository
@Transactional
public class MovieDaoImpl implements IMovieDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Movie> findAll() {
		String jpql = "select m from Movie m";
		return sf.getCurrentSession().createQuery(jpql, Movie.class).getResultList();
	}

	@Override
	public String addMovie(Movie m) {
		sf.getCurrentSession().save(m);
		return "Movie added successfully with ID " + m.getId();
	}

	@Override
	public String deleteMovie(int id) {
		Session hs = sf.getCurrentSession();
		Movie m = hs.get(Movie.class, id);
		if (m != null) {
			hs.delete(m);
			return "Movie with ID " + id + " deleted";
		} else 
			return "Movie deletion failed";
	}

}
