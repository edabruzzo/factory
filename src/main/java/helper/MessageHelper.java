package helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessageHelper {

	
	FacesContext context;

	@Inject
	public MessageHelper(FacesContext context) {
		super();
		this.context = context;
	}
	
	
	
	public void addMessage(FacesMessage message) {
        addMessage(null, message);
    }

    private void addMessage(String clientId, FacesMessage message) {
        context.addMessage(clientId, message);
    }


    public MessageHelper onFlash() {
        context.getExternalContext().getFlash().setKeepMessages(true);
        return this;
    }
	
	    
}
