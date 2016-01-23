package caesweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JsfUtil {
	public static void showInfoMessage(String msg) {
		FacesMessage message = new FacesMessage(msg);
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void showErrorMessage(String msg) {
		FacesMessage message = new FacesMessage(msg);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static String getRealPath(){
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	}
}
