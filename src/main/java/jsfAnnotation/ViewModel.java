package jsfAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Stereotype
@ViewScoped
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Named
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModel {

}
