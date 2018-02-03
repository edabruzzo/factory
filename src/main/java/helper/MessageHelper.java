package helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessageHelper {

	
	@Inject 
	private FacesContext context;
	
	private FacesMessage message;

	/*
	@Inject
	public MessageHelper(FacesContext context) {
		super();
		this.context = context;
	}
	*/
	
	
	
	public void addMessage(String mensagem) {
        addMessage(null, mensagem);
    }

    public void addMessage(String clientId, String mensagem) {
		message = new FacesMessage(mensagem);
    	context.addMessage(clientId, message);
    }


    public MessageHelper onFlash() {
        context.getExternalContext().getFlash().setKeepMessages(true);
        return this;
    }
	
	    
    
}
