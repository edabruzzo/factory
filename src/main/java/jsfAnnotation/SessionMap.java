package jsfAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/*https://cursos.alura.com.br/course/cdi-usando-umas-das-principais-espeficacoes-do-javaee/task/21557
 *ANOTAÇÃO CRIADA POR CONTA DA AMBIGUIDADE ENTRE OS MÉTODOS PRODUTORES DE 
 *SESSION MAPS, DO JSFFACTORY, COMO O GETFLASH() E O SESSIONMAP() 
 * */



@Qualifier
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SessionMap {

}
