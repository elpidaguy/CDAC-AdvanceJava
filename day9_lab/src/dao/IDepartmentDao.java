package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface IDepartmentDao {

	public String createNewDeptDepartment(Department d);
	public String hireEmp(int deptId,Employee e);
	public List<Employee> listEmps(String deptName);
	public String fireEmp(int deptId,int empId);
	
}
