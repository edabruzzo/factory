package transactions;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import TransactionsAnnotations.Transacional;



/*
 * https://cursos.alura.com.br/course/cdi-usando-umas-das-principais-espeficacoes-do-javaee/task/21555
 */


@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionsManager implements Serializable{
	
	
	private static final long serialVersionUID = -8096401703398419867L;

	
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
