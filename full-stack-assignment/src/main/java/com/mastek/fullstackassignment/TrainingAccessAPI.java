package com.mastek.fullstackassignment;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/training/")
public class TrainingAccessAPI {
	
	TrainingJPARepository repository;
	
	public TrainingJPARepository getRepository() {
		return repository;
	}
	
	@Autowired
	public void setRepository(TrainingJPARepository repository) {
		this.repository = repository;
	}
	
	ParticipantJPARepository participantRepository;
	
	public ParticipantJPARepository getParticipantRepository() {
		return participantRepository;
	}
	
	@Autowired
	public void setParticipantRepository(ParticipantJPARepository pRepository) {
		this.participantRepository = pRepository;
	}
	
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Training> listTrainings(){
		return getRepository().findAll();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Training addTraining(@BeanParam Training newTraining) {
		getRepository().save(newTraining);
		return newTraining;
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Training deleteTraining(int trainingId) {
		Training deleteTraining = getRepository().findById(trainingId).get();
		getRepository().delete(deleteTraining);
		return deleteTraining;
	}
	
	@POST
	@Path("/register-to-existing")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	public void addParticipanttoTraining(@FormParam("pid")int partId, @FormParam("tid")int trainId){
		Participant p = getParticipantRepository().findById(partId).get();
		Training t = getRepository().findById(trainId).get();
		
		if(!t.getParticipants().contains(p)){
			t.getParticipants().add(p);
		}
		
		getRepository().save(t);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/participants")
	@Transactional
	public Set<Participant> getParticipants(@QueryParam("tid")int trainingId){
		Training t = getRepository().findById(trainingId).get();
		if(!t.getParticipants().isEmpty()) {
			return t.getParticipants();
		}else {
			return null;
		}
	}

}
