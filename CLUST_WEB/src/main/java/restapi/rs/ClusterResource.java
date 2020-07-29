package restapi.rs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restapi.ejb.Cluster;
import restapi.ejb.DAOCluster;

// [rg] Endpoint REST (JAX-RS) le richieste arrivano da HHTP a questo endpoit e vengono
//      smistate ai metodi Java pertinenti
@Path("/cluster")
public class ClusterResource {

	@EJB
	private DAOCluster dbService;

	//[rg] Legge tutti i dati dalle entità JPA la strasforma in una collection di oggetto
	//     rappresentante il dato fisico ClusterInfo 
	//     Schema LAMBDA - Map-Reduce
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClusterInfo> getAllCluster() {
		return dbService.getAllCluster().stream().map( ce ->
		new ClusterInfo(ce.getCustomerNo(), ce.getCustomerClass(),ce.getTechDescr(),ce.getCentro(), ce.getStatus(), ce.getCustomerActivationDate() )
				).collect(Collectors.toList());
		/*
		 * 
		 * public ClusterInfo(String customerNo,  String customerClass, String techDescr, String centro,
			String status) {
		this.customerNo = customerNo;
		this.customerClass = customerClass;
		this.techDescr = techDescr;
		this.centro = centro;
		this.status = status;
		
	}
		 */
		
	}

	@GET
	@Path("/{account}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClusterInfo getClusterAccount(@PathParam("account") String account) {

		return dbService
				.findCluster(account)
				.map(
						entity -> new ClusterInfo(entity.getCustomerNo(), entity.getCustomerClass(), entity.getTechDescr(), entity.getCentro(), entity.getStatus(), entity.getCustomerActivationDate())
						)
				.orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
	}

	@PUT
	@Path("/{account}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateContact(@PathParam("account") String id, ClusterInfo c) {

		dbService
		.findCluster(id)
		//[rg] Bisogna mettere <qualificatore> altrimenti Eclipse ha un baco 
		//     https://bugs.eclipse.org/bugs/show_bug.cgi?id=540846
		.<Cluster>flatMap(
				ce -> {
					ce.setCustomerNo( c.getCustomerNo() );
					ce.setCentro( c.getCentro() );
					ce.setTechDescr( c.getTechDescr() );

					dbService.updateCluster(ce);

					return Optional.of(ce);
				}
				)
		.orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
	}

	@DELETE
	@Path("/{account}")
	public void deleteContact(@PathParam("account") String id) { dbService.deleteCluster(id); }

	
	//[rg] Nota @Valid che invocherà la validazione dei dati
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClusterInfo addCluster(@Valid ClusterInfo c) {

		Cluster ce = new Cluster();
		ce.setCustomerNo( c.getCustomerNo() );
		ce.setCentro( c.getCentro() );
		ce.setTechDescr( c.getTechDescr() );

		Cluster fromDB = dbService.addCluster(ce);

		return new ClusterInfo(fromDB.getCustomerNo(), fromDB.getCustomerClass(),fromDB.getTechDescr(),fromDB.getCentro(), fromDB.getStatus(), fromDB.getCustomerActivationDate());
	}

}
