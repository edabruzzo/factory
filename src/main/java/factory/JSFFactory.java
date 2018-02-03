package factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
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
	    return getFacesContext().getExternalContext().getFlash();
	}



}
	


