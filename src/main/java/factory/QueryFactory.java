package factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.Query;

import jpaAnnotations.Query_;
import jsfAnnotation.ScopeMap;
import jsfAnnotation.ScopeMap.Scope;



public class QueryFactory {


	@Inject
	JPAFactory jpa;
	
	@SuppressWarnings("rawtypes")
	@Produces
	@Query_("")
	public Query factory(InjectionPoint pontoInjecao) {
		
	String sqlString = pontoInjecao.getAnnotated().getAnnotation(Query_.class).value();

	ParameterizedType type = (ParameterizedType) pontoInjecao.getType();
	Class classe = (Class) type.getClass();

	return jpa.getEntityManager().createNativeQuery(sqlString, classe);
		
	}
	
	
}

	
	