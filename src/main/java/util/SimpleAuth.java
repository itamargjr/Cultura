package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/** clase que retorna uma autenticacao para ser enviada e verificada pelo servidor smtp 
 *
 *  @author itamar
 */  
class SimpleAuth extends Authenticator {  
  public String username = null;  
  public String password = null;  


  public SimpleAuth(String user, String pwd) {  
      username = user;  
      password = pwd;  
  }  

  protected PasswordAuthentication getPasswordAuthentication() {  
      return new PasswordAuthentication (username,password);  
  }  
}
