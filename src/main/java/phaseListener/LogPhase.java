package phaseListener;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import phaseListenerAnnotations.After;
import phaseListenerAnnotations.Phase;
import phaseListenerAnnotations.Phase.Phases;

public class LogPhase {

public void log(@Observes @After @Phase(Phases.RESTORE_VIEW) PhaseEvent phaseEvent){

	System.out.println("FASE: " + phaseEvent.getPhaseId());
	
}

}
