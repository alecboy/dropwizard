package com.lanino.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.lanino.core.History;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	private final AtomicLong counter;
	
	public UserResource() {
		this.counter = new AtomicLong();
	}
	
    @GET
    @Timed
    @Path("{userId}")
	public List<History> getHistory(@PathParam("userId") String userId) {
    	List<History> h = new ArrayList<History>();
    	h.add(new History(counter.incrementAndGet(), "UH1"));
    	h.add(new History(counter.incrementAndGet(), "UH2"));
    	h.add(new History(counter.incrementAndGet(), "UH3"));
		return h;
	}
    
    @GET
    @Timed
    @Path("{userId}/{idDetail}")
	public History getDetail(@PathParam("userId") String userId) {
		return new History(counter.incrementAndGet(), "Detail");
	}
	
}
