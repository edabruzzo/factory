package phaseListenerAnnotations;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3114259252576023709L;

	private Phases phases;
	
	
	public PhaseLiteral(PhaseId phaseId) {
		
		phases = Phase.Phases.valueOf(phaseId.getName());

	}


	@Override
	public Phases value() {

		return null;
	}

}
