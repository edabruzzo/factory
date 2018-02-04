package factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class JSFFactory {
	
	
	@Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }


	@Produces
	@RequestScoped
	public Flash getFlash() {
	    return getExternalContext().getFlash();
	}


	@Produces
	public Map<String, Object> sessionMap() {
	    return getExternalContext().getSessionMap();
	}

	
	
	private ExternalContext getExternalContext() {
		
		return 	getFacesContext().getExternalContext();
		
	}
	

}
	


