package com.mastek.fullstackassignment;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		//register the class as a Service
		register(TrainingAccessAPI.class);
		//register the class as a Service
		register(ParticipantAccessAPI.class);
		//register the CORSFilter as a Service
		register(CORSFilter.class);
	}

}
