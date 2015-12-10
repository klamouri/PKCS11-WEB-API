package api.test;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {
  // This method is called if XMLis request
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Todo getJSONOrXML() {
    Todo todo = new Todo();
    todo.setSummary("This is my first todo");
    todo.setDescription("This is my first todo Description");
    return todo;
  }
  @POST
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Todo postJSONorXML(Todo td) {
	  td.setSummary("Modified Summary");
	  return td;
  }

} 