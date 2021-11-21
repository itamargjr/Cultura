package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import entity.Ctrl_usuarios;
import persistence.Ctrl_usuariosDao;
import persistence.Dao;

/**
 * Bean de controle de acesso.
 * Todas as funções relativas
 * ao acesso do sistema
 * 
 * @author itamar
 *
 */

@ManagedBean
@SessionScoped
public class AcessoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8268179366139876532L;

	public Ctrl_usuarios usuarios; 
	
	private Boolean renderizarBotaocadastrarUsuario;
	private Boolean renderizarBotaoAtualizarUsuario;
	private Boolean renderizarBotaoExcluirUsuario;
	
	private List<Ctrl_usuarios> usuarioslista;
	
	/* Função que mostra em qual banco a aplicação está conectada e retorna a String */
	public String banco(){
		
		String cam;
		Dao db = new Dao();
		
		cam = db.caminho(); 

		return cam.substring(cam.length()-18, cam.length());
	}
	
	/* Função que mostra o usuário logado */
	public String usuariologado(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
		
		if (session.getAttribute("loginusulogado")==null) {
			return "";
		} else {
			return session.getAttribute("loginusulogado").toString();

		}
		
	}
	
	public AcessoBean() {
		usuarios = new Ctrl_usuarios();
		
		usuarioslista = new ArrayList<Ctrl_usuarios>();
		
		renderizarBotaocadastrarUsuario = false;
		renderizarBotaoAtualizarUsuario = false;
		renderizarBotaoExcluirUsuario = false;
	}
	
	public Boolean getRenderizarBotaocadastrarUsuario() {
		return renderizarBotaocadastrarUsuario;
	}

	public void setRenderizarBotaocadastrarUsuario(Boolean renderizarBotaocadastrarUsuario) {
		this.renderizarBotaocadastrarUsuario = renderizarBotaocadastrarUsuario;
	}

	public Boolean getRenderizarBotaoAtualizarUsuario() {
		return renderizarBotaoAtualizarUsuario;
	}

	public void setRenderizarBotaoAtualizarUsuario(Boolean renderizarBotaoAtualizarUsuario) {
		this.renderizarBotaoAtualizarUsuario = renderizarBotaoAtualizarUsuario;
	}

	public Boolean getRenderizarBotaoExcluirUsuario() {
		return renderizarBotaoExcluirUsuario;
	}

	public void setRenderizarBotaoExcluirUsuario(Boolean renderizarBotaoExcluirUsuario) {
		this.renderizarBotaoExcluirUsuario = renderizarBotaoExcluirUsuario;
	}

	public List<Ctrl_usuarios> getUsuarioslista() {
		return usuarioslista;
	}

	public void setUsuarioslista(List<Ctrl_usuarios> usuarioslista) {
		this.usuarioslista = usuarioslista;
	}

	public Ctrl_usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Ctrl_usuarios usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Função de acesso ao sistema.
	 * recebe login e senha do 
	 * usuário e critica a 
	 * existência
	 * 
	 */

	public String login(){
		
		Ctrl_usuariosDao ad = new Ctrl_usuariosDao();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		try {
			Ctrl_usuarios usuariologado = ad.login(usuarios);
			
			if (usuariologado.getLogin_usu()==null) {						
				FacesMessage msg = new FacesMessage("Login não efetuado", "Usuário inexistente, ou senha inválida!");
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
				session.setAttribute("idusulogado", 0);
				
				return null;
			}else {
				
				usuarios = new Ctrl_usuarios();
				
				FacesMessage msg = new FacesMessage("Bem vindo", usuariologado.getLogin_usu());
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
							
				session.setAttribute("loginusulogado", usuariologado.getLogin_usu());
				session.setAttribute("idusulogado", usuariologado.getId_usu());
				
				if (usuariologado.getTipo_usu().equalsIgnoreCase("A")) {
					session.setAttribute("usuadm", "S");
				}
				
				return "principal.xhtml?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage msg = new FacesMessage("Erro ao efetuar login",e.getMessage());
				
			FacesContext.getCurrentInstance().addMessage(null, msg);			
					
			session.setAttribute("idusulogado", 0);
			
			return null;
		}
		
	}
	
	/**
	 * Função de saída do sistema
	 * que limpa os dados da sessão
	 * e redireciona o usuário para a 
	 * tela de login
	 * 
	 */

	public String logout(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		session.setAttribute("idusulogado", 0);
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "index.xhtml?faces-redirect=true";
		
	}
	
	/**
	 * Função para confirmar se
	 * existe algum usuário logado
	 * 
	 * A lógica é: se o atributo
	 * login_usu da classe acessousuarios
	 * não está nulo, então ele está
	 * logado 
	 * 
	 */
	
	public boolean isLogado(){
		//return usuarios.getLogin_usu() != null;
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Integer usulog = (Integer) session.getAttribute("idusulogado");
		
		//System.out.println("usulog:" + usulog);
		
		return usulog !=null;
	}
	
	
	public String validausu(Integer item) throws Exception{
		// alterar o AcessoBean para guardar também a variável de sessão usuadm - login()   
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Integer usulog = (Integer) session.getAttribute("idusulogado");
		String adm = (String) session.getAttribute("usuadm");
		
		String desabilita;
		
		if ((adm != null) && (adm.equals("S"))) 		 		
			desabilita = "false"; // Administrador - habilita tudo
		else{			
			Ctrl_usuariosDao valida = new Ctrl_usuariosDao();
			desabilita = valida.validaItemUsuario(usulog, item);
		}

		return desabilita;	
			
	}
	
	public void buscarusuario() {
		
		//System.out.println("vou buscar");
		
		Ctrl_usuariosDao ud = new Ctrl_usuariosDao();
		
		try {
			
			usuarioslista = ud.findAll(usuarios);
			
			//System.out.println(usuarioslista);
			
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}
	
	public String listarusuario() {
		Ctrl_usuariosDao ud = new Ctrl_usuariosDao();
		
		try {
			
			usuarioslista = ud.findAll(usuarios);
			
			return "ListarusuariosRel.xhtml?faces-redirect=true";
			
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		return null;
		
	}
	
	public void LimparUsuario() {
		usuarios = new Ctrl_usuarios();
		
		usuarioslista = new ArrayList<Ctrl_usuarios>();
	}
	
	public void AbreDialogoEditar(){
		renderizarBotaoAtualizarUsuario = true;
		renderizarBotaocadastrarUsuario = false;
		renderizarBotaoExcluirUsuario = false;
		
		PrimeFaces.current().executeScript("PF('dialogUsuarios').show();");		
	}
	
	public void AbreDialogoCadastrar(){
		renderizarBotaoAtualizarUsuario = false;
		renderizarBotaocadastrarUsuario = true;
		renderizarBotaoExcluirUsuario = false;
		
		PrimeFaces.current().executeScript("PF('dialogUsuarios').show();");		
	}
	
	public void AbreDialogoExcluir(){
		renderizarBotaoAtualizarUsuario = false;
		renderizarBotaocadastrarUsuario = false;
		renderizarBotaoExcluirUsuario = true;
		
		PrimeFaces.current().executeScript("PF('dialogUsuarios').show();");		
	}
	
	public void cadastrarusuario() {
		
		Ctrl_usuariosDao ud = new Ctrl_usuariosDao();
		
		try {
			
			ud.gravarusuario(usuarios);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário gravado com sucesso!", ""));
			
			usuarios = new Ctrl_usuarios();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}
	
	public void AtualizarUsuario() {
		
		Integer linhas = 0;
		
		Ctrl_usuariosDao ud = new Ctrl_usuariosDao();
		
		try {
			
			linhas = ud.alterarusuario(usuarios);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário gravado com sucesso! " + linhas + " registros alterados", ""));
			
			usuarios = new Ctrl_usuarios();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}
	
	public void ExcluirUsuario() {
		
		Integer linhas = 0;
		
		try {
			
			linhas = new Ctrl_usuariosDao().excluirUsuario(usuarios);
			
			usuarios = new Ctrl_usuarios();
			
			buscarusuario();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluído com sucesso! " + linhas + " registros alterados", ""));

		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

}
