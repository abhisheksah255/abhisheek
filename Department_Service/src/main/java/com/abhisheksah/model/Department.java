package com.abhisheksah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Department Details")
public class Department {
	
	@Id
	private long departmentID;
	private String departmentName;
	private String desc;
	private int no_of_Emp;
	
	public long getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getNo_of_Emp() {
		return no_of_Emp;
	}
	public void setNo_of_Emp(int no_of_Emp) {
		this.no_of_Emp = no_of_Emp;
	}
	public Department(long departmentID, String departmentName, String desc, int no_of_Emp) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.desc = desc;
		this.no_of_Emp = no_of_Emp;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", desc=" + desc
				+ ", no_of_Emp=" + no_of_Emp + "]";
	}
	
	
	
	
	
}