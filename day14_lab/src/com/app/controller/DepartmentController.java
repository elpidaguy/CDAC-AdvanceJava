package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IDepartmentDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private IDepartmentDao idd;
	
	public DepartmentController() {
		System.out.println("inside Department Controller");
	}
	
	@GetMapping("/list")
	public String getDepartmentList(Model map)
	{
		List<Department> l1 = idd.getAllDepartments();
		System.out.println("inside getDepartList"+ map +" " + l1);
		 map.addAttribute("deptList", l1);
		 return "/department/list";
	}
	
	@GetMapping("/addEmployee")
	public String addNewEmployee(Model map)
	{
		System.out.println("inside AddNewEmployee :"+ map);
		idd.addNewEmployee((Integer)map.getAttribute("dept_id"), (Employee)map.getAttribute("emp"));
		return "redirect:/department/list";
	}
	
}
