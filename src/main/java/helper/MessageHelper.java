package helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

public class MessageHelper {

	
	@Inject 
	private FacesContext context;
	
	private FacesMessage message;
	
	@Inject
	private Flash flash;

	

	/*
	@Inject
	public MessageHelper(FacesContext context, Flash flash) {
		super();
		this.context = context;
		this.flash = flash;
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
        flash.setKeepMessages(true);
        return this;
    }
	
	    
    
}
