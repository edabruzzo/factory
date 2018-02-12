package phaseListener;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import phaseListenerAnnotations.After;
import phaseListenerAnnotations.Before;
import phaseListenerAnnotations.Phase;

public class phaseListenerObserver implements Serializable {

	
	
	private static final long serialVersionUID = -5639038416365258130L;
	
	
	@Inject
    private Event<PhaseEvent> observer;
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
        observer.select(momento).select(new AnnotationLiteral<Phase>() {}).fire(phaseEvent);
    }


}
