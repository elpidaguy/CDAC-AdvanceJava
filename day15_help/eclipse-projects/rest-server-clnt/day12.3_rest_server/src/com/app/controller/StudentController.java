package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.StudentDao;
import com.app.pojos.Student;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentDao dao;

	public StudentController() {
		System.out.println("in stud controller constr");

	}

	@GetMapping
	public List<Student> fetchAllStudents() {
		System.out.println("rest srvr : fetch all");
		return dao.getAllStudents();
	}

	@GetMapping("/{sid}")
	public ResponseEntity<?> getStudentDetails(@PathVariable int sid) {
		System.out.println("rest srvr : get stud dtls");
		Student s = dao.getStudentById(sid);
		if (s != null) {
			// valid student id
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		// invalid id
		return new ResponseEntity<>("Invalid Student ID ", HttpStatus.NOT_FOUND);
	}

	@PostMapping // creating new resource
	public ResponseEntity<String> registerStudent(@RequestBody Student s) {
		System.out.println("rest srvr : reg student " + s);
		try {
			return new ResponseEntity<>(dao.registerStudent(s), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("err in reg " + e);
			return new ResponseEntity<>("Student reg failed : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{sid}") // delete existing resource
	public ResponseEntity<String> cancelAdmission(@PathVariable int sid) {
		System.out.println("rest srvr : delete stud info " + sid);
		try {
			Student s = dao.getStudentById(sid);
			if (s != null)
				return new ResponseEntity<>(dao.deleteStudentDtls(s), HttpStatus.OK);
			else
				return new ResponseEntity<>("Student deletion failed : ", HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			System.out.println("err in deletion " + e);
			return new ResponseEntity<>("Student deletion failed : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
