package factory;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil implements Serializable{
	
	private static final long serialVersionUID = 3624552482708677645L;

	private EntityManagerFactory emf =  Persistence.createEntityManagerFactory( "ControleFinanceiroPU" );

    @Produces
	@RequestScoped
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public void close(@Disposes EntityManager em) {
    	if (em.isOpen()) {
    		em.close();
    	}
    }
	
		
	
}
