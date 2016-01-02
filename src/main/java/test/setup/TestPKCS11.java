package test.setup;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iaik.pkcs.pkcs11.Module;
import test.setup.beans.Library;

@Path("/pkcsTest")
public class TestPKCS11 {	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String toto(Library l){
		try {
			Module m = Module.getInstance(l.getPath());
			if (m != null)
				return "PKCS11 Wrapper correctly setup";
			else
				return "Oops, there was a problem with the PKCS11 Wrapper";
		} catch (IOException e) {
			return "Oops, there was a problem with the PKCS11 Wrapper";
		}
	}
}
