package api.webservice.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.response.NbSlotBeanResponse;
import api.beans.response.SlotInfoResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.TokenException;

public class SlotWebServiceImplementation {

	public NbSlotBeanResponse nbSlot(HttpServletRequest req) {
		NbSlotBeanResponse r = new NbSlotBeanResponse();
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		try {
			r.setNbSlot(m.getSlotList(Module.SlotRequirement.ALL_SLOTS).length);
			return r;
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
	}

	public SlotInfoResponse slotInfos(HttpServletRequest req, int idSlot, List<String> select) {
		SlotInfoResponse r = new SlotInfoResponse();
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		try {
			Slot[] slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);

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

			Slot s = slots[idSlot];

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
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
	}

}
