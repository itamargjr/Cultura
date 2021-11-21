package util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;  

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;   
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.ByteArrayDataSource;
  
/**
 * Classe para envio de emails
 * utilizo javax mail
 * 
 * @author itamar
 *
 */

public class SendMail {  
	
	// 07/11/2021
	// Classe configurada para usar o gmail e funcionando!
	// Baixei o javax.mail.jar mais recente em substituição ao mail.jar que usava
	// Conforme vi neste link: https://stackoverflow.com/questions/35347269/javax-mail-authenticationfailedexception-535-5-7-8-username-and-password-not-ac
	// Que gerei um PDF e deixei na documentacao como javagmail.pdf
	// mudei na conta do gmail :
	// Two Step Verification should be turned off.
	// Allow Less Secure App(should be turned on).
	// e desabilitei o avast
      
    private String mailSMTPServer;  
    private String mailSMTPServerPort;  
      
    /* 
     * quando instanciar um Objeto ja sera atribuido o servidor SMTP do GMAIL  
     * e a porta usada por ele 
     */  
    public SendMail() { //Para o GMAIL   
        mailSMTPServer = "smtp.gmail.com"; //"199.201.88.81";//"mail.wernertecidos.com.br"; //"smtp.gmail.com";  
        mailSMTPServerPort = "465"; // 07/11/2021 Gemail usa 465. Na Werner usamos 587
    }  
    
    /* 
     * caso queira mudar o servidor e a porta, so enviar para o contrutor 
     * os valor como string 
     */  
    public SendMail(String mailSMTPServer, String mailSMTPServerPort) { //Para outro Servidor  
        this.mailSMTPServer = mailSMTPServer;  
        this.mailSMTPServerPort = mailSMTPServerPort;  
    }  
      
    public void sendMail(String from, String[] to, String subject, String message) {  
          
        Properties props = new Properties();  
  
                // quem estiver utilizando um SERVIDOR PROXY descomente essa parte e atribua as propriedades do SERVIDOR PROXY utilizado  
                /* 
                props.setProperty("proxySet","true"); 
                props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy 
                props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy 
                */  
  
        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP  
        props.put("mail.smtp.starttls.enable","true"); /** mudado para false para testar se vai pela lucanet/maxsite */  
        props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL  
        props.put("mail.smtp.auth", "true"); //ativa autenticacao  
        props.put("mail.smtp.user", from); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.port", mailSMTPServerPort); //porta  
        props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket  
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        props.put("mail.smtp.socketFactory.fallback", "false");  /** mudei para true para funcionar na locaweb/lucanet/maxsite. no gmail funciona com false */
          
        //Cria um autenticador que sera usado a seguir  
        SimpleAuth auth = null;  
        auth = new SimpleAuth ("inscricaoeducacaonilopolis@gmail.com","educacao2019");
          
        //Session - objeto que ira realizar a conexão com o servidor  
        /*Como há necessidade de autenticação é criada uma autenticacao que 
         * é responsavel por solicitar e retornar o usuário e senha para  
         * autenticação */  
        Session session = Session.getDefaultInstance(props, auth);  
        session.setDebug(true); /** Habilita o LOG das ações executadas durante o envio do email */  
  
        //Objeto que contém a mensagem  
        Message msg = new MimeMessage(session);  
  
        try {  
        	
        	InternetAddress[] addressTo = new InternetAddress[to.length];
        	
        	for (int i = 0; i < to.length; i++) {
        		
        		addressTo[i] = new InternetAddress(to[i]);
				
			}
        	
            //Setando o destinatário  
            msg.setRecipients(Message.RecipientType.TO, addressTo);  
            //Setando a origem do email  
            msg.setFrom(new InternetAddress(from));  
            //Setando o assunto  
            msg.setSubject(subject);  
            //Setando o conteúdo/corpo do email  
            msg.setContent(message,"text/html");  
  
        } catch (Exception e) {  
//            System.out.println(">> Erro: Completar Mensagem");  
            e.printStackTrace();  
        }  
          
        //Objeto encarregado de enviar os dados para o email  
        Transport tr;  
        try {  
            tr = session.getTransport("smtp"); //define smtp para transporte  
            /* 
             *  1 - define o servidor smtp 
             *  2 - seu nome de usuario do gmail 
             *  3 - sua senha do gmail 
             */  
            tr.connect(mailSMTPServer, "estamparia@wernertecidos.com.br","eemi77");
            msg.saveChanges(); // don't forget this  
            //envio da mensagem  
            tr.sendMessage(msg, msg.getAllRecipients());  
            tr.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            System.out.println(">> Erro: Envio Mensagem");  
            e.printStackTrace();  
        }  
  
    }  
    
    public void sendMailAttachment(String from, String[] to, String subject, String message, byte[] anexo) {  
        
        Properties props = new Properties();  
  
                // quem estiver utilizando um SERVIDOR PROXY descomente essa parte e atribua as propriedades do SERVIDOR PROXY utilizado  
                /* 
                props.setProperty("proxySet","true"); 
                props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy 
                props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy 
                */  
  
        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP  
        props.put("mail.smtp.starttls.enable","true"); /** mudado para false para testar se vai pela lucanet/maxsite */
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL  
        props.put("mail.smtp.auth", "true"); //ativa autenticacao  
        props.put("mail.smtp.user", from); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.port", mailSMTPServerPort); //porta  
        props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket  
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        props.put("mail.smtp.socketFactory.fallback", "false");  /** mudei para true para funcionar na locaweb/lucanet/maxsite. no gmail funciona com false */
          
        //Cria um autenticador que sera usado a seguir  
        SimpleAuth auth = null;  
        auth = new SimpleAuth ("inscricaoeducacaonilopolis@gmail.com","educacao2019");
          
        //Session - objeto que ira realizar a conexão com o servidor  
        /*Como há necessidade de autenticação é criada uma autenticacao que 
         * é responsavel por solicitar e retornar o usuário e senha para  
         * autenticação */  
        Session session = Session.getDefaultInstance(props, auth);  
        session.setDebug(false); /** Habilita o LOG das ações executadas durante o envio do email */  
  
        //Objeto que contém a mensagem  
        Message msg = new MimeMessage(session);  
        
        MimeBodyPart attachFilePart = new MimeBodyPart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart mp = new MimeMultipart();  
        String nomeArquivo= "candidato.pdf"; // nome do arquivo em anexo  
        
        try {  
        	
        	attachFilePart.setDataHandler(new DataHandler(new ByteArrayDataSource(anexo, "application/octet-stream")));
        	
        	attachFilePart.setFileName(nomeArquivo);
            mp.addBodyPart(attachFilePart); 
        	
        	InternetAddress[] addressTo = new InternetAddress[to.length];
        	
        	for (int i = 0; i < to.length; i++) {
        		
        		addressTo[i] = new InternetAddress(to[i]);
				
			}
        	
            //Setando o destinatário  
            msg.setRecipients(Message.RecipientType.TO, addressTo);  
            //Setando a origem do email  
            msg.setFrom(new InternetAddress(from));  
            //Setando o assunto  
            msg.setSubject(subject);  
            //Setando o conteúdo/corpo do email 
//            msg.setText(message);  
//            msg.setContent(message,"text/html");  
            
            messageBodyPart.setContent(message,"text/html");  
            
            mp.addBodyPart(messageBodyPart);
            
            msg.setContent(mp);
  
        } catch (Exception e) {  
//            System.out.println(">> Erro: Completar Mensagem");  
            e.printStackTrace();  
        }  
          
        //Objeto encarregado de enviar os dados para o email  
        Transport tr;  
        try {  
            tr = session.getTransport("smtp"); //define smtp para transporte  
            /* 
             *  1 - define o servidor smtp 
             *  2 - seu nome de usuario do gmail 
             *  3 - sua senha do gmail 
             */  
            tr.connect(mailSMTPServer, "inscricaoeducacaonilopolis@gmail.com","educacao2019");
            msg.saveChanges(); // don't forget this  
            //envio da mensagem  
            tr.sendMessage(msg, msg.getAllRecipients());  
            tr.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            System.out.println(">> Erro: Envio Mensagem");  
            e.printStackTrace();  
        }  
  
    }
    
    public void enviarMail(String destinatario, String assunto,
			String corpo) throws IOException {

		String mailUsuario = "inscricaoeducacaonilopolis@gmail.com";
		String mailSenha = "educacao2019";
		String mailPortaSMTP = "587";
		String mailHost = "smtp.gmail.com";
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", mailHost);
		props.put("mail.smtp.port", mailPortaSMTP);
		props.put("mail.smtp.socketFactory.port", mailPortaSMTP);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.ssl.trust", mailHost);
		props.put("mail.smtp.auth", true);
		props.put("mail.debug", true);

		
		SimpleAuth auth = new SimpleAuth(mailUsuario, mailSenha);
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);

		try {
			
			System.out.println("destinatario: " + destinatario);
			System.out.println("assunto: " + assunto);
			System.out.println("corpo: " + corpo);

			Address from = new InternetAddress("inscricaoeducacaonilopolis@gmail.com");
			Address to = new InternetAddress(destinatario);

			message.setFrom(from);
			message.addRecipient(RecipientType.TO, to);
			message.setSentDate(new Date());
			message.setSubject(assunto);
			message.setText(corpo);
			Transport.send(message);

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
