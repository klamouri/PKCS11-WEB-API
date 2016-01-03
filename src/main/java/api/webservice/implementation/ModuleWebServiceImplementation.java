package api.webservice.implementation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.ModuleBeanRequest;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.TokenException;

public class ModuleWebServiceImplementation {

	public Response setModule(HttpServletRequest req, ModuleBeanRequest m) {
		Module module;
		try {
			module = Module.getInstance(m.getPath());
		} catch (IOException e) {
			throw new WebApplicationException(
					Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Library not accessible (permision or location)")).build());
		}
		
		try {
			module.initialize(null);
		} catch (TokenException e) {
			throw new WebApplicationException(
					Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Module already initialized or not initializable")).build());
		}
		req.getSession().setAttribute("module", module);
		return Response.status(Status.NO_CONTENT).build();
	}

	public Response unsetModule(HttpServletRequest req) {
		Module m = (Module) req.getSession().getAttribute("module");
		if(m == null)
			throw new WebApplicationException(
					Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Module not initialized")).build());
		try {
			m.finalize();
		} catch (Throwable e) {
			throw new WebApplicationException(
					Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Module can't be finalized")).build());
		}
		req.removeAttribute("module");
		return Response.status(Status.NO_CONTENT).build();
	}

}
