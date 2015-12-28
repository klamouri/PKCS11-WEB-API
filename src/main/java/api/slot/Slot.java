package api.slot;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.Library;
import api.beans.request.NbSlotBeanRequest;
import api.beans.response.NbSlotBeanResponse;
import api.beans.response.SlotInfoResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.TokenException;

@Path("slot")
public class Slot {
	private Logger l = Logger.getLogger(this.getClass().toString());

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("nbSlot")
	public NbSlotBeanResponse nbSlot(NbSlotBeanRequest b) {
		NbSlotBeanResponse r = new NbSlotBeanResponse();
		try {
			Module m = Module.getInstance(b.getLibraryPath());
			try {
				m.initialize(null);
			} catch (TokenException e) {
				l.info("Exception durant le initialize :" + e);
			}
			try {
				r.setNbSlot(m.getSlotList(Module.SlotRequirement.ALL_SLOTS).length);
				return r;
			} catch (TokenException e) {
				l.info("Exception durant le getSlotList :" + e);
			}
		} catch (IOException e) {

		}
		return new NbSlotBeanResponse();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idSlot}/info")
	public SlotInfoResponse slotInfos(Library lib, @PathParam("idSlot") int idSlot,
			@QueryParam("select") List<String> select) {
		SlotInfoResponse r = new SlotInfoResponse();
		try {
			Module m = Module.getInstance(lib.getPath());
			try {
				m.initialize(null);
			} catch (TokenException e) {
				l.info("Exception durant le initialize :" + e);
			}
			try {
				iaik.pkcs.pkcs11.Slot[] slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);

				if (idSlot > slots.length)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You're trying to use an out of range ID for the slot")).build());
				if (select.size() == 0)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You didn't specified any select")).build());

				if (select.contains("*")) {
					select.clear();
					select.add("manufacturerID");
					select.add("slotDescription");
					select.add("isHardwareSlot");
					select.add("isRemovableDevice");
					select.add("isTokenPresent");
				}
				

				iaik.pkcs.pkcs11.Slot s = slots[idSlot];

				if (select.contains("manufacturerID"))
					r.setManufacturerID(s.getSlotInfo().getManufacturerID().trim());
				if (select.contains("slotDescription"))
					r.setSlotDescription(s.getSlotInfo().getSlotDescription().trim());
				if (select.contains("isHardwareSlot"))
					r.setHardwareSlot(s.getSlotInfo().isHwSlot());
				if (select.contains("isRemovableDevice"))
					r.setRemovableDevice(s.getSlotInfo().isRemovableDevice());
				if (select.contains("isTokenPresent"))
					r.setTokenPresent(s.getSlotInfo().isTokenPresent());
				if (select.contains("idToken"))
					r.setIdToken(s.getToken().getTokenID());
				return r;
			} catch (TokenException e) {
				l.info("Exception durant le getSlotList :" + e);
			}
		} catch (IOException e) {

		}
		return new SlotInfoResponse();
	}

}
