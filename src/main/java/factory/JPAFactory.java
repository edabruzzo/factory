package factory;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ApplicationScoped
public class JPAFactory implements Serializable{
	
	private static final long serialVersionUID = 3624552482708677645L;

	//existe outra forma de criar um gerenciador de entidades,  
	//utilizando uma ou até mais unidades de persistencia?
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
	
	
    
    @PreDestroy
    public void preDestroy() {
    	if (emf.isOpen()) {
    		
    		emf.close();
    	}
    	
    	    	
    }
	
}
