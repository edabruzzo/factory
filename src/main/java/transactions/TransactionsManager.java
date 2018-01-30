package transactions;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;


@Interceptor
public class TransactionsManager {
	
	EntityManager em;

	
	@Inject
	public TransactionsManager(EntityManager em) {
		super();
		this.em = em;
	}
	
	
	@AroundInvoke
	public Object executaComtransacao(InvocationContext context) {
        
		em.getTransaction().begin();
		
		try {
		
		Object resultadoTransacao =	context.proceed();
		em.getTransaction().commit();
		return resultadoTransacao;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}

        
}
	

}
