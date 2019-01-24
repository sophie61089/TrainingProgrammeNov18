package com.mastek.fullstackassignment;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="JPA_Participant")
@XmlRootElement
public class Participant {
	
	
	int employeeId;
	
	@FormParam("name")
	String employeeName;
	
	Set<Training> trainings = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@ManyToMany(mappedBy = "participants")
	@XmlTransient
	public Set<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	
	
	@Override
	public String toString() {
		return "Participant [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	
	

}
