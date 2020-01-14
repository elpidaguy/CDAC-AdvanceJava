package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.IMovieDao;
import com.app.pojos.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private IMovieDao dao;

	@GetMapping
	public List<Movie> testMe() {
		return dao.findAll();
	}

	@PostMapping
	public String addMovie(@RequestBody Movie m) {
		System.out.println("rest server : add movie " + m);
		dao.save(m);
		return "Movie added";
	}

	/*
	 * formData.append('imageFile', file); formData.append('title', title);
	 * formData.append('description', description); formData.append('rating', '' +
	 * rating); formData.append('genre', genre);
	 */
	@PostMapping("/upload")
	public String addMovieWithImage(@RequestParam MultipartFile imageFile, @RequestParam String title,
			@RequestParam String description, @RequestParam double rating, @RequestParam String genre) {
		System.out.println("movie with image " + title);

		Movie m = new Movie(title, description, genre, rating);
		try {
			m.setImageFile(imageFile.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}
		dao.save(m);
		return "Movie added with Image";
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable int id) {
		System.out.println("in delete movie " + id);
		if (dao.existsById(id))
			dao.deleteById(id);
		else
			return new ResponseEntity<String>("Movie deletion failed : Invalid id", HttpStatus.NOT_FOUND);
		return new ResponseEntity<String>("Movie deleted", HttpStatus.OK);
	}
}
