package api.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import api.beans.request.Library;
import api.beans.request.NbSlotBeanRequest;
import api.beans.response.NbSlotBeanResponse;
import api.beans.response.SlotInfoResponse;
import api.webservice.implementation.SlotWebServiceImplementation;

@Path("slot")
public class SlotWebService {
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("nbSlot")
	public NbSlotBeanResponse nbSlot(NbSlotBeanRequest b) {
		return new SlotWebServiceImplementation().nbSlot(b);

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idSlot}/info")
	public SlotInfoResponse slotInfos(Library lib, @PathParam("idSlot") int idSlot,
			@QueryParam("select") List<String> select) {
		return new SlotWebServiceImplementation().slotInfos(lib, idSlot, select);
		
	}

}
