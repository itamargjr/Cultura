package manager;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;

import entity.Cult_matr_candidato;
import entity.Cult_segmento;
import entity.Edu_matr_responsavel;
import entity.End_endereco;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.Cult_matr_candidatoDao;
import persistence.Cult_segmentoDao;
import persistence.Edu_matr_responsavelDao; 
import persistence.End_enderecoDao;
import report.DSReportCandidato;
import util.Biblioteca;
import util.SendMail;

@ManagedBean
@ViewScoped
public class Cult_matr_candidatoBean {
	
	public Cult_matr_candidato candidato;
	public Edu_matr_responsavel responsavel;
	
	public End_endereco endereco;
	
	public Cult_segmento segmento;
	
	public List<Cult_matr_candidato> candidatolista;
	public List<Cult_segmento> segmentoslista;
	public List<Cult_segmento> segmentoselecionadolista;
	
	public List<String> diaslista;
	public List<String> segmentolista;
	
	public Integer idade;
	
	public Boolean necespec;
	
	public Cult_matr_candidatoBean() {
		
		candidato = new Cult_matr_candidato();
		segmento = new Cult_segmento();
		responsavel = new Edu_matr_responsavel();
		endereco = new End_endereco();
		
		segmentoselecionadolista = new ArrayList<Cult_segmento>();
		candidatolista = new ArrayList<Cult_matr_candidato>();
		
		idade = 0;
		
		necespec = false;
		
		try {
			diaslista = new Cult_matr_candidatoDao().findDias();

			segmentolista = new Cult_segmentoDao().findSegmentos();
			
			segmentoslista = new Cult_segmentoDao().listar();
			
			//System.out.println(segmentolista);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}	
		
	}
	
	@PostConstruct
	public void init() {
		carregalistadasession();
		
		limpalistadasession();		
	}
	
	@SuppressWarnings("unchecked") // isso é necessário para o eclipse não colocar warning na atribuição abaixo porque não entende que o objeto retornado é realmente uma lista
	public void carregalistadasession() {					
		candidatolista = (List<Cult_matr_candidato>) new PaginasBean().GetPropriedadeSessionScope("candidatolista");
	}
	
	public void limpalistadasession() {					
		new PaginasBean().RemovePropriedadeSessionScope("candidatolista");
	}
	
	public List<Cult_segmento> getSegmentoslista() {
		return segmentoslista;
	}

	public void setSegmentoslista(List<Cult_segmento> segmentoslista) {
		this.segmentoslista = segmentoslista;
	}

	public List<String> getDiaslista() {
		return diaslista;
	}

	public void setDiaslista(List<String> diaslista) {
		this.diaslista = diaslista;
	}

	public Boolean getNecespec() {
		return necespec;
	}

	public void setNecespec(Boolean necespec) {
		this.necespec = necespec;
	}

	public List<Cult_segmento> getSegmentoselecionadolista() {
		return segmentoselecionadolista;
	}

	public void setSegmentoselecionadolista(List<Cult_segmento> segmentoselecionadolista) {
		this.segmentoselecionadolista = segmentoselecionadolista;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cult_matr_candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Cult_matr_candidato candidato) {
		this.candidato = candidato;
	}

	public Edu_matr_responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Edu_matr_responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public End_endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(End_endereco endereco) {
		this.endereco = endereco;
	}

	public Cult_segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Cult_segmento segmento) {
		this.segmento = segmento;
	}

	public List<Cult_matr_candidato> getCandidatolista() {
		return candidatolista;
	}

	public void setCandidatolista(List<Cult_matr_candidato> candidatolista) {
		this.candidatolista = candidatolista;
	}

	public List<String> getSegmentolista() {
		return segmentolista;
	}

	public void setSegmentolista(List<String> segmentolista) {
		this.segmentolista = segmentolista;
	}

	public void calculaidade() {
		if (!candidato.getNascimento_candidato().equalsIgnoreCase("")) {
			
			idade = Biblioteca.retornaIdade(candidato.getNascimento_candidato());//, "31/03/2022").toString();
			
			candidato.setTipo_candidato("C"); // Setando tipo para candidato da cultura
			
			preenchelistas();
			
		}
	}
	
	private void preenchelistas() {

		if (idade < 4) {
					
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Idade inválida!",  "O  candidato deverá ter a partir de 4 anos") );				
		
		} else {
			
			try {
				segmento.setIdadebusca(idade);
				
				//segmentolista = new Cult_segmentoDao().findAll(segmento);
				
				segmentoselecionadolista = new ArrayList<Cult_segmento>();
				
				//System.out.println("segmentolista: " + segmentolista);
				
			} catch (Exception e) {
				e.printStackTrace();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			}					
			
		}
		
	}
	
	public void ConcluirInscricao() {
		
		candidato.setAno_candidato(2022);
		candidato.setTipo_candidato("C");
		
		try {						
			
			Cult_matr_candidatoDao cd = new Cult_matr_candidatoDao();
			
			Boolean Candidatojaexiste = cd.testaCandidatoJaExiste(candidato);
			
			if (Candidatojaexiste) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este candidato já possui inscrição", "")); // passa a mensagem
			} else if (segmento.getId_segmento()==null) {//(segmentoselecionadolista.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alguma opção deve ser escolhida", "")); // passa a mensagem
			//} else if (segmentoselecionadolista.size()>5) {
			//	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Por favor, selecione no máximo 5 (CINCO) opções de segmentos", "")); // passa a mensagem
			} else {
				
//				for (int i = 0; i < segmentoselecionadolista.size(); i++) {
//					if (i==0) {
//						candidato.setId_segmento1(segmentoselecionadolista.get(i).getId_segmento());
//					} else if (i==1) {
//						candidato.setId_segmento2(segmentoselecionadolista.get(i).getId_segmento());
//					} else if (i==2) {
//						candidato.setId_segmento3(segmentoselecionadolista.get(i).getId_segmento());
//					} else if (i==3) {
//						candidato.setId_segmento4(segmentoselecionadolista.get(i).getId_segmento());
//					} else  {
//						candidato.setId_segmento5(segmentoselecionadolista.get(i).getId_segmento());
//					} 								
//				}
				
				candidato.setId_segmento1(segmento.getId_segmento());
				
				if (necespec) {
					candidato.setNecespec_candidato("S");
				} else {
					candidato.setNecespec_candidato("N");
				}
				
				Edu_matr_responsavelDao rd = new Edu_matr_responsavelDao();
				
				Integer idresp = rd.gravar(responsavel);
				
				candidato.setId_responsavel(idresp);	
				
				//System.out.println("candidato: " + candidato);
				
				Integer idcandidato = cd.gravar(candidato);
				
				endereco.setIdentidade_endereco(idcandidato);
				endereco.setTipo_endereco("U");
				endereco.setUf_endereco("RJ");
				endereco.setCodigo_municipio("3303203");
				
				End_enderecoDao ed = new End_enderecoDao();
				
				ed.gravar(endereco);
							
				enviaremailcandidato(idcandidato);
				
				if (idcandidato == 0) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Houve um erro na gravação do candidato", "")); // passa a mensagem
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidato gravado com sucesso", "")); // passa a mensagem
		
		
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); // passa a mensagem
		}
		
	}
	
	public void buscarcandidato() {
		try {
			
			//System.out.println("Buscando candidato: " + candidatoreport);
			
			candidato = new Cult_matr_candidatoDao().findCandidatoConsulta(candidato);
			
			if (candidato.getId_segmento1()==null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Candidato não encontrado com os dados fornecidos", "")); // passa a mensagem
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); 	
		}
	}
	
	public void buscarcandidatos() {
		try {
			candidatolista = new Cult_matr_candidatoDao().buscarCandidatos(candidato);
			
			new PaginasBean().SetPropriedadeSessionScope("candidatolista", candidatolista);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); 	
		}
	}
	
	public void buscarcandidatosclass() {
		try {

			if ((candidato.getId_segmento() == null)||(candidato.getId_segmento() == 0)) {
				throw new Exception("Dados inválidos, refaça a busca");
			} else {

				Cult_matr_candidatoDao cd = new Cult_matr_candidatoDao();
				
				candidatolista = cd.findCandidatoClass(candidato.getId_segmento());
				
				if (candidatolista.size()>0) {
					candidato.setAno_candidato(candidatolista.get(0).getAno_candidato());
					candidato.setAno_candidato(candidatolista.get(0).getAno_candidato());				
  					candidato.setDescricao_segmento(candidatolista.get(0).getDescricao_segmento());				
  					candidato.setIdademin_segmento(candidatolista.get(0).getIdademin_segmento());			
  					candidato.setIdademax_segmento(candidatolista.get(0).getIdademax_segmento());				
  					candidato.setDia_segmento(candidatolista.get(0).getDia_segmento());
  					candidato.setTurno_segmento(candidatolista.get(0).getTurno_segmento());									
				}
				
				new PaginasBean().SetPropriedadeSessionScope("candidatoreportlista", candidatolista);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); // passa a mensagem
		}
	}
	
	public void imprimirInscricao(){
		imprimeCandidato(candidato.getId_candidato());
	}
	
	public String imprimeclassificacao(){
		
		if ((candidatolista.size()==0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhum candidato encontrado para enviar imprimir", "")); // passa a mensagem
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			
			try{		
				
				DSReportCandidato ds = new DSReportCandidato(candidatolista);
				
				InputStream arquivo = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream("/classificacaocultura.jasper");	

				byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
					
				HttpServletResponse res = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext().getResponse();
					
				res.setContentType("application/pdf");
				
				res.setContentLength(pdf.length);
					
				OutputStream out = res.getOutputStream();

				out.write(pdf, 0, pdf.length);

				out.flush();	
				
				out.close();
				
				FacesContext.getCurrentInstance().responseComplete();
				
				OutputStream fileout = new FileOutputStream("classificacao.pdf");	
				
				fileout.write(pdf, 0, pdf.length);

				fileout.flush();	

				fileout.close();	
				
			} catch (Exception e) {
				e.printStackTrace();
				
				fc.addMessage("formimprimirclass", new FacesMessage("Erro ao enviar: " + e.getMessage()));	
			}
		}
		
		return null;
	}
	
	public void reenviarInscricao() {
		try {
			enviaremailcandidato(candidato.getId_candidato());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado com sucesso", ""));
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void cancelarInscricao() {
		try {
			Cult_matr_candidatoDao cd = new Cult_matr_candidatoDao();
			
			cd.cancelaInscricao(candidato);
			
			candidato = new Cult_matr_candidato();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inscrição cancelada!", "")); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "")); 
		}
	}
	

	
	public void enviaremailcandidato(Integer IdCandidato){
		
		if ((IdCandidato==null)||(IdCandidato==0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhum candidato encontrado para enviar email", "")); // passa a mensagem
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			
			try{		
				
				List<Cult_matr_candidato> lista = new Cult_matr_candidatoDao().findCandidato(IdCandidato);
				
				candidato = lista.get(0);
				
				//System.out.println("candidato: " +candidato);

				DSReportCandidato ds = new DSReportCandidato(lista);
				
				InputStream arquivo = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream("/candidatoCultura.jasper");	

				byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
					
				String dest = "";
				
				if ((candidato.getEmail_candidato()!=null)&&(!candidato.getEmail_candidato().equalsIgnoreCase(""))) {
					dest = candidato.getEmail_candidato();
				} else if (candidato.getEmail_responsavel()!=null) {
					dest = candidato.getEmail_responsavel();
				}
				
				SendMail sm = new SendMail();
				
				String dadosemailhtml = "<br /> <strong>SECRETARIA DE CULTURA NILÓPOLIS 2022 - INSCRIÇÃO CANDIDATO <label>" +
		           		 "</label> </strong><br /> <br />" +
		           		 "<br /> Esta é uma confirmação da sua CANDIDATURA aos Segmentos na Secretaria de Cultura do município de Nilópolis <br />" +
		           		 "<hr />" +
		           		 "<br /><br />Candidato         : " + candidato.getNome_candidato() +
		           		 "<br /><br />Data de Nascimento: " + candidato.getNascimento_candidato() +
		           		 "<br /><br />Bairro            : " + candidato.getBairro_candidato() +
		           		 "<br /><br />" + 
		           		 "<br /><br />Responsável       : " + candidato.getNome_responsavel() +
		           		 "<br /><br />" + 		           		 
		           		 "<br /><br />Opções de Escola  : " + 
		           		 "<br /><br />" + 
		           		 "<br /><br />Opção Escolhida   : " + candidato.getDescricao_segmento1() +		           		 		           		
		           		 "<br /><br />Dias              : " + candidato.getDia_segmento1() +
		           		 "<br /><br />Turno             : " + candidato.getTurno_segmento1() +
		           		 "<br /><br />" + 
		           		 "Você realizou a inscrição para concorrer a vagas na " +
		           		 "<br />" +
		           		 "Secretaria de Cultura do Município de Nilópolis em 2022. O resultado final  (Classificação) estará " +
		           		 "<br />" +
		           		 "disponível no mesmo endereço eletrônico." +
		           		 "<br />" +
		           		 "(www.nilopolisdigital.com/matriculasonline)"+
		           		 "<div style='border:none;border-bottom:solid windowtext 1.0pt;padding:0cm 0cm 1.0pt 0cm'>" +
		           		 
		           		 "<table align='center'><tr>"+
		           		 "<td align='center'><img src='http://nilopolisdigital.com/imagens/cultura.jpg' alt='Matrículas On Line 2022' /><br /><br />"+
		           		 "<strong>Sistema de Matrículas On Line 2022 - Prefeitura Municipal de Nilópolis</strong>"+
		           		 "</td></tr></table>";
	
				
				String[] to = {dest, candidato.getEmail_responsavel()}; 
				
				//System.out.println("para: " + to);
							
				sm.sendMailAttachment("inscricaoeducacaonilopolis@gmail.com", to, "Matrícula Nilópolis 2022 - Candidato", dadosemailhtml, pdf);

				//fc.addMessage("enviaremailprepedidos", new FacesMessage("Email enviado com sucesso! "));	
				
			} catch (Exception e) {
				e.printStackTrace();
				
				fc.addMessage("enviaremailprepedidos", new FacesMessage("Erro ao enviar: " + e.getMessage()));	
			}
		}
	}
	
	public String imprimeCandidato(Integer IdCandidato){
		
		if ((IdCandidato==null)||(IdCandidato==0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nenhum candidato encontrado para enviar email", "")); // passa a mensagem
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			
			try{		
				
				List<Cult_matr_candidato> lista = new Cult_matr_candidatoDao().findCandidato(IdCandidato);
				
				candidato = lista.get(0);

				DSReportCandidato ds = new DSReportCandidato(lista);
				
				InputStream arquivo = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream("/candidatoCultura.jasper");	

				byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
					
				HttpServletResponse res = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext().getResponse();
					
				res.setContentType("application/pdf");
				
				res.setContentLength(pdf.length);
					
				OutputStream out = res.getOutputStream();

				out.write(pdf, 0, pdf.length);

				out.flush();	
				
				out.close();
				
				FacesContext.getCurrentInstance().responseComplete();
				
				OutputStream fileout = new FileOutputStream("relatoriopreped.pdf");	
				
				fileout.write(pdf, 0, pdf.length);

				fileout.flush();	

				fileout.close();	
				
			} catch (Exception e) {
				e.printStackTrace();
				
				fc.addMessage("enviaremailprepedidos", new FacesMessage("Erro ao enviar: " + e.getMessage()));	
			}
		}
		
		return null;
	}
	
	public void mostradialogocandidato() {

		PrimeFaces.current().executeScript("PF('Dialogo').show();");
	}
	
	public String imprimelistainscricoes() {
		
		return "consultarInscricoesMatriculaRel.xhtml?faces-redirect=true";	
	}
}
