
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;


public class Email {
	
	

	  private static final String MEU_EMAIL = "roger.martins@routesecurity.com.br";
	  private static final String MINHA_SENHA  = "Ceuazul25";
	  private static final String SMTP_ROUTE =  "smtp.routesecurity.com.br";
	
	 
	  
	  public Email(String nome, String emailSpv) {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(SMTP_ROUTE);
		email.setAuthenticator(new DefaultAuthenticator(MEU_EMAIL, MINHA_SENHA));
		email.setSSLOnConnect(false);
		email.setSmtpPort(587);
		
		LocalDateTime data = LocalDateTime.now();
		long hora = 1 * data.toEpochSecond(ZoneOffset.ofHours(-3));
		long segundosDiaAnterior = hora - 86400;
		
		Date dataDiaAnterior = new Date(segundosDiaAnterior * 1000);
				
		Date dataInicioGrafana = new Date(dataDiaAnterior.getYear(), dataDiaAnterior.getMonth(), dataDiaAnterior.getDate(), 0, 0, 0);
		Date dataFimGrafana = new Date(dataDiaAnterior.getYear(), dataDiaAnterior.getMonth(), dataDiaAnterior.getDate(), 23, 59, 59);
			
		LocalDateTime inicio = LocalDateTime.ofInstant(dataInicioGrafana.toInstant(), ZoneOffset.ofHours(-3));
		LocalDateTime fim = LocalDateTime.ofInstant(dataFimGrafana.toInstant(), ZoneOffset.ofHours(-3));
		

		try {

			email.setFrom(MEU_EMAIL);
			email.setSubject("Relatorio de hosts");
			email.setHtmlMsg("Olá Sr. "+ nome +" segue relatório diário registrado pelo sistema de monitoramento da <b>Route Security</b>.<p>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<p>\r\n" + 
					"<a href=\"http://189.39.46.177:3000/d/0fEh8MAZk/listagem?orgId=1&var-page_status=Ranking&var-page_tipo=Camera&var-page_supervisor="+ nome +"&var-client=dhl&from="+ inicio +"&to="+ fim + "\"> Ranking de oscilação das câmeras. </a><p>\r\n" + 
					"\r\n" + 
					"<p>\r\n" + 
					"<a href=\"http://189.39.46.177:3000/d/0fEh8MAZk/listagem?orgId=1&var-page_status=Ranking&var-page_tipo=Servidor&var-page_supervisor="+ nome +"&var-client=dhl&from="+ inicio +"&to="+ fim +"\"> Ranking de oscilação dos servidores </a><p><p>\r\n" + 
					"\r\n" + 
					"<p>\r\n" + 
					"<a href=\"http://189.39.46.177:3000/d/0fEh8MAZk/listagem?orgId=1&var-page_status=Ranking&var-page_tipo=Link&var-page_supervisor="+ nome +"&var-client=dhl&from="+ inicio +"&to="+ fim +"\"> Ranking de oscilação dos links </a><p><p>\r\n" + 
					"\r\n" + 
					"Este e-mail foi enviado automaticamente pelo sistema de monitoramento de links da <b>Route Security</b>. Se desejar entrar em contato com a equipe de monitoramento, responda esse e-mail ou ligue: <b>(19) 3199-7777</b>. Atendimento 24h, 7 dias por semana!");
			email.addTo(emailSpv);
			email.send();
			System.out.println("Email foi enviado com sucesso para "+ nome); 
			

		}  catch (Exception e) {
			e.printStackTrace();
		}


	
    }

		
}