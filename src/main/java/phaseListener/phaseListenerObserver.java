package phaseListener;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import phaseListenerAnnotations.After;
import phaseListenerAnnotations.Before;
import phaseListenerAnnotations.PhaseLiteral;

public class phaseListenerObserver implements Serializable {

	
	
	private static final long serialVersionUID = -5639038416365258130L;
	
	

    private BeanManager observer = CDI.current().getBeanManager();

	private Annotation momento;

    public phaseListenerObserver after() {
        this.momento = new AnnotationLiteral<After>(){};
        return this;
    }

    public phaseListenerObserver before() {
        this.momento = new AnnotationLiteral<Before>(){};
        return this;
    }

    public void fire(PhaseEvent phaseEvent) {
        observer.fireEvent(phaseEvent, this.momento, new PhaseLiteral(phaseEvent.getPhaseId()));
    }


}
