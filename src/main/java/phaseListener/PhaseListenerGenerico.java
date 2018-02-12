/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phaseListener;

import java.io.Serializable;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import phaseListenerAnnotations.After;
import phaseListenerAnnotations.Before;

/**
 *
 * @author Emm
 */
public class PhaseListenerGenerico implements PhaseListener, Serializable {
    
    
	private static final long serialVersionUID = -1064930936747939511L;

	@Inject
	private phaseListenerObserver observer;
	
	
	@Override
    public void afterPhase(PhaseEvent pe) {
      	observer.after().fire(pe);
	}
	


    @Override
    public void beforePhase(PhaseEvent pe) {
    	observer.before().fire(pe);
    }

    @Override
    public PhaseId getPhaseId() {
  
    return PhaseId.ANY_PHASE;
           
    }
    
}
