/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Emm
 */
public class LogPhaseListener implements PhaseListener, Serializable {
    
    
	private static final long serialVersionUID = -1064930936747939511L;

	@Override
    public void afterPhase(PhaseEvent pe) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
       
            System.out.println("FASE: " + pe.getPhaseId());

    }

    @Override
    public PhaseId getPhaseId() {
  
    return PhaseId.ANY_PHASE;
           
    }
    
}
