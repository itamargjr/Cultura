package manager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ManagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417861840557215978L;	
	
	public ManagerBean() {
		
	}
	
	public String navegarmenuprincipal(){
		
		try {
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
			if (session.getAttribute("idusulogado")==null) {
				return null;
			} else if (((Integer) session.getAttribute("idusulogado"))!=0) {
				return "principal.xhtml?faces-redirect=true";				
			} else {
				return null;
			}  													
			
		} catch (Exception e) {
			e.printStackTrace();
						
			return null;
		}		
	}

}
