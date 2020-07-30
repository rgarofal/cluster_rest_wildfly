package restapi.ejb;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Version;

@Stateless
public class DAOCluster {
	@PersistenceContext
    private EntityManager em;

	// [rg] Usare i Criteria JPA per costruire le query (TODO)
    public List<Cluster> getAllCluster() {
        return em.createQuery("SELECT c FROM Cluster c", Cluster.class ).getResultList();
    }
    //[rg] Optional indica un container che contiene o meno un valore se non nullo 
    public Optional<Cluster> findCluster(String account) {
		return Optional.ofNullable(em.find(Cluster.class, account));
    }
    
 // [rg] Usare i Criteria JPA per costruire le query (TODO)
    public List<Cluster> getAllClusterActive() {
    	String jpqlquery_status = "SELECT c FROM Cluster c where status = :stat";
    	Query query = em.createQuery(jpqlquery_status, Cluster.class);
    	query.setParameter("stat", "CB");
        return query.getResultList();
    }

    
  //[rg] Optional indica un container che contiene o meno un valore se non nullo 
    public List<Cluster> findClusterAccountAttivi(String account) {
    	String jpqlquery_status = "SELECT c FROM Cluster c where status = :stat and customer_No = :acc";
    	Query query = em.createQuery(jpqlquery_status, Cluster.class);
    	query.setParameter("stat", "CB");
    	query.setParameter("acc", account);
		return query.getResultList();
    }
    
    public Cluster addCluster(Cluster ce) {
        em.persist( ce );
        return ce;
    }

    public void deleteCluster(String account) {
        em.remove( em.find(Cluster.class, account) );
    }

    public void updateCluster(Cluster ce) { em.merge(ce); }
}
