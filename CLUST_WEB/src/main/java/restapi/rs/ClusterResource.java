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
	@GET
	@Path("/attivi")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClusterInfo> getClusterActiveAllAccount() {

		List<ClusterInfo> list_of_clust = dbService
				.getAllClusterActive().stream().
				map( ce ->
				new ClusterInfo(ce.getCustomerNo(), ce.getCustomerClass(),ce.getTechDescr(),ce.getCentro(), ce.getStatus(), ce.getCustomerActivationDate() )
						).collect(Collectors.toList());
		if (list_of_clust == null )
			 throw new WebApplicationException(Response.Status.NOT_FOUND);
		return list_of_clust;
	}

	@GET
	@Path("/attivi/{account}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClusterInfo> getClusterActiveAccount(@PathParam("account") String account) {

		List<ClusterInfo> list_of_clust = dbService
				.findClusterAccountAttivi(account).stream().
				map( ce ->
				new ClusterInfo(ce.getCustomerNo(), ce.getCustomerClass(),ce.getTechDescr(),ce.getCentro(), ce.getStatus(), ce.getCustomerActivationDate() )
						).collect(Collectors.toList());
		if (list_of_clust == null )
			 throw new WebApplicationException(Response.Status.NOT_FOUND);
		return list_of_clust;
	}

}
