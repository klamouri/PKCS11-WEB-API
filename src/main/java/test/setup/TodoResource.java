package test.setup;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.setup.beans.Todo;

@Path("/todo")
public class TodoResource {
  // This method is called if XMLis request
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Todo getJSONOrXML() {
    Todo todo = new Todo();
    todo.setSummary("AutoBinding JSON to Bean");
    todo.setDescription("Json To Bean Ok");
    return todo;
  }
  @POST
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Todo postJSONorXML(Todo td) {
	  td.setDescription("AutoBinding JSON to Bean");
	  td.setSummary("Bean To JSON Ok");
	  return td;
  }

} 