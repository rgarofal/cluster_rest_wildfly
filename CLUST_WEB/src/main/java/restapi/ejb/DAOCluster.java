package restapi.ejb;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;

@Stateless
public class DAOCluster {
	@PersistenceContext
    private EntityManager em;

    public List<Cluster> getAllCluster() {
        return em.createQuery("SELECT c FROM Cluster c", Cluster.class ).getResultList();
    }
    //[rg] Optional indica un container che contiene o meno un valore se non nullo 
    public Optional<Cluster> findCluster(String account) {
		return Optional.ofNullable(em.find(Cluster.class, account));
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
