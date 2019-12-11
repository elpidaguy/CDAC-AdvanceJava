package dao;

import java.util.List;
import org.hibernate.*;

import pojos.Department;
import pojos.Employee;

import static utils.HibernateUtils.*;

public class DepartmentDaoImpl implements IDepartmentDao {

	@Override
	public String createNewDeptDepartment(Department d) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		String msg = "Department Addition Failed!!!";
		try {
			//d--transient
			hs.save(d);//persistent
			tx.commit();//ins,l1 cache destroyed, cn returned to pool
			msg = "Department Added Successfully!!!";
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String hireEmp(int deptId, Employee emp) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		
		try {
			Department d = hs.get(Department.class,deptId);
			d.addEmployee(emp);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

	@Override
	public List<Employee> listEmps(String deptName) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Department d = null;
		String jpql = "select d from Department d where d.name = :nme";
		try {
			d = (Department) hs.createQuery(jpql).setParameter("nme", deptName).getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return d.getEmps();
	}

	@Override
	public String fireEmp(int deptId, int empId) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Employee e = hs.get(Employee.class, empId);
			Department d = hs.get(Department.class,deptId);
			d.removeEmployee(e);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
