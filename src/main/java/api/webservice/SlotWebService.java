package api.webservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import api.beans.response.NbSlotBeanResponse;
import api.beans.response.SlotInfoResponse;
import api.webservice.implementation.SlotWebServiceImplementation;

@Path("slot")
public class SlotWebService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("nbSlot")
	public NbSlotBeanResponse nbSlot(@Context HttpServletRequest req) {
		return new SlotWebServiceImplementation().nbSlot(req);

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("info/{idSlot}")
	public SlotInfoResponse slotInfos(@Context HttpServletRequest req, @PathParam("idSlot") int idSlot,
			@QueryParam("select") List<String> select) {
		return new SlotWebServiceImplementation().slotInfos(req, idSlot, select);
		
	}

}
