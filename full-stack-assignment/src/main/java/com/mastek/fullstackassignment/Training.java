package com.mastek.fullstackassignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="JPA_Training")
@XmlRootElement
public class Training {
	
	
	int trainingId;
	
	@FormParam("title")
	String trainingTitle;
	
	@FormParam("description")
	String trainingDescription;
	
	@FormParam("leader")
	String trainingLeader;
	
	@FormParam("date")
	String trainingDate;
	
	@FormParam("start")
	String trainingStartTime;
	
	@FormParam("duration")
	double trainingDuration;
	
	@FormParam("location")
	String trainingLocation;
	
	@FormParam("spacestot")
	int trainingSpacesTotal;
	
	int trainingSpacesAvailable;
	
	
	Set<Participant> participants = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingTitle() {
		return trainingTitle;
	}
	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}
	public String getTrainingDescription() {
		return trainingDescription;
	}
	public void setTrainingDescription(String trainingDescription) {
		this.trainingDescription = trainingDescription;
	}
	public String getTrainingLeader() {
		return trainingLeader;
	}
	public void setTrainingLeader(String trainingLeader) {
		this.trainingLeader = trainingLeader;
	}
	public String getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	public String getTrainingStartTime() {
		return trainingStartTime;
	}
	public void setTrainingStartTime(String trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}
	public double getTrainingDuration() {
		return trainingDuration;
	}
	public void setTrainingDuration(double trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
	public String getTrainingLocation() {
		return trainingLocation;
	}
	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	public int getTrainingSpacesTotal() {
		return trainingSpacesTotal;
	}
	public void setTrainingSpacesTotal(int trainingSpacesTotal) {
		this.trainingSpacesTotal = trainingSpacesTotal;
	}
	public int getTrainingSpacesAvailable() {
		return trainingSpacesAvailable;
	}
	public void setTrainingSpacesAvailable(int trainingSpacesAvailable) {
		this.trainingSpacesAvailable = trainingSpacesAvailable;
	}
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="JPA_ParticipantTrainingRelations",
				joinColumns = {@JoinColumn(name = "FK_TrainingId")},
				inverseJoinColumns = {@JoinColumn(name = "FK_ParticipantId")})
	@XmlTransient
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingTitle=" + trainingTitle + ", trainingDescription="
				+ trainingDescription + ", trainingLeader=" + trainingLeader + ", trainingDate=" + trainingDate
				+ ", trainingStartTime=" + trainingStartTime + ", trainingDuration=" + trainingDuration
				+ ", trainingLocation=" + trainingLocation + ", trainingSpacesTotal=" + trainingSpacesTotal
				+ ", trainingSpacesAvailable=" + trainingSpacesAvailable + ", participants=" + participants + "]";
	}
	
	public int calcSpacesAvailable() {
		int total = getTrainingSpacesTotal();
		int taken = getParticipants().size();
		int available = total-taken;
		System.out.println("total: "+total+", taken: "+taken+", available: "+available);
		return available;
	}
	

}
