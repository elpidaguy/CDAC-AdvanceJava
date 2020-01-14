package pojos;

import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Embeddable
public class EmpPK implements Serializable{
	private String empId,depId;
	public EmpPK() {
		System.out.println("in emp pk def constr");
	}
	public EmpPK(String empId, String depId) {
		super();
		this.empId = empId;
		this.depId = depId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depId == null) ? 0 : depId.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpPK other = (EmpPK) obj;
		if (depId == null) {
			if (other.depId != null)
				return false;
		} else if (!depId.equals(other.depId))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
	@Column(length=10,name="emp_id")
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Column(length=10,name="dept_id")
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	@Override
	public String toString() {
		return "empId=" + empId + ", depId=" + depId ;
	}
	
	
	

}
