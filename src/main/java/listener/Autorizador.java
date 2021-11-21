package listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import manager.AcessoBean;

/**
 * Classe que "escuta" o 
 * ciclo do JSF e implementa
 * o evento que captura a navegação entre 
 * páginas do projeto para impedir um
 * usuário não logado de acessar o
 * sistema 
 * 
 * @author itamar
 *
 */

public class Autorizador implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7165802048370933572L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		/**
		 * Se a página a ser acessada é o index.xhtml
		 * nada é feito, já que esta é a página de login
		 */
		
		if ("/index.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		/**
		 * Instancializo o acessobean pq lá está a 
		 * referência se o usuário já está logado
		 * ou não.
		 * 
		 * Isto é registrado no método booleano
		 * isLogado()
		 */
		
		AcessoBean acessoBean = context.getApplication().evaluateExpressionGet(context, "#{acessoBean}", AcessoBean.class);
		
		/**
		 * Se não estiver logado, volta pro index.xhtml
		 */
		
		if (!acessoBean.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			
			handler.handleNavigation(context, null, "index?faces-redirect=true");
			
			context.renderResponse();
		}
				

		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {

		
	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}
	

}
