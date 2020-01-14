package com.app.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "courses")
public class Course {
	private Integer courseId;
	private String name;
	private int capacity;
	private Date beginDate, endDate;
	private double fees;
	// Course HAS-A multiple stduents
	private Set<Student> students = new HashSet<>();

	public Course() {
		System.out.println("in course constr");
	}

	public Course(String name, int capacity, Date beginDate, Date endDate, double fees) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.fees = fees;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(length = 20, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "begin_date")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	//owning side
	//cascade on insert n update
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "courses_studs",joinColumns = @JoinColumn(name="c_id"),inverseJoinColumns = @JoinColumn(name="stud_id"))
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	//helper methods
	public void addStudent(Student s)
	{
		//add student to a course
		students.add(s);
		//add course to a student
		s.getSelectedCourses().add(this);
	}
	public void removeStudent(Student s)
	{
		students.remove(s);
		s.getSelectedCourses().remove(this);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", capacity=" + capacity + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", fees=" + fees + "]";
	}
	//override hashCode n equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	


}
