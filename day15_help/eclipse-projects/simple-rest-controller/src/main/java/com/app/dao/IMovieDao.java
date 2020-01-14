package com.app.dao;

import java.util.List;

import com.app.pojos.Movie;

public interface IMovieDao  {
  List<Movie> findAll();
  String addMovie(Movie m);
  String deleteMovie(int id);
}
