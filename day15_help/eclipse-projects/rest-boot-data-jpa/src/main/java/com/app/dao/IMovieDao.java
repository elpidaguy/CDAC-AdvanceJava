package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Movie;

public interface IMovieDao extends JpaRepository<Movie, Integer> {
  
}
