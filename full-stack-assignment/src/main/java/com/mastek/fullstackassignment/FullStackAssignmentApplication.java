package com.mastek.fullstackassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FullStackAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
				SpringApplication.run(FullStackAssignmentApplication.class, args);
		
		TrainingAccessAPI trainingAPI = ctx.getBean(TrainingAccessAPI.class);
		ParticipantAccessAPI participantAPI = ctx.getBean(ParticipantAccessAPI.class);
		
		Training newTraining = new Training();
		newTraining.setTrainingTitle("Grad Training");
		newTraining.setTrainingDescription("Graduate Training Session: Full Stack");
		newTraining.setTrainingLocation("Leeds");
		newTraining.setTrainingDate("18/02/19");
		newTraining.setTrainingStartTime("14:00");
		newTraining.setTrainingDuration(3);
		newTraining.setTrainingLeader("Sameer");
		newTraining.setTrainingSpacesTotal(20);
		
		
		Participant newParticipant = new Participant();
		newParticipant.setEmployeeName("Employee");
		//newParticipant.getTrainings().add(newTraining);
		
		//newTraining.getParticipants().add(newParticipant);
		
		Participant newParticipant2 = new Participant();
		newParticipant2.setEmployeeName("Employee");
		//newParticipant2.getTrainings().add(newTraining);
		
		//newTraining.getParticipants().add(newParticipant2);
		
		Participant newParticipant3 = new Participant();
		newParticipant3.setEmployeeName("Employee");
		//newParticipant3.getTrainings().add(newTraining);
		
		//newTraining.getParticipants().add(newParticipant3);
		
		
		newTraining.setTrainingSpacesAvailable(newTraining.calcSpacesAvailable());
		
		
		//trainingAPI.addTraining(newTraining);
		
		//participantAPI.addParticipant(newParticipant);
		//participantAPI.addParticipant(newParticipant2);
		//participantAPI.addParticipant(newParticipant3);
		
		//trainingAPI.addParticipanttoTraining(newParticipant.getEmployeeId(), newTraining.getTrainingId());
		//trainingAPI.addParticipanttoTraining(newParticipant2.getEmployeeId(), newTraining.getTrainingId());
		//trainingAPI.addParticipanttoTraining(newParticipant3.getEmployeeId(), newTraining.getTrainingId());
		
		
		
		
		
		
		
		System.out.println(newTraining);
		//System.out.println(trainingAPI.getParticipants(41));
		//ctx.close();
		
	}

}

