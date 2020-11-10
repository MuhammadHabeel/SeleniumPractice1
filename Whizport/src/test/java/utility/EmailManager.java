package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EmailManager {

	private String toAddress = "";
	private String ccAddress = "";
	private String bccAddress = "";
	public List<String> attachmentFiles = new ArrayList<>();

	private void setToAddress(String toEmails) {
		toAddress = toEmails;
	}

	private InternetAddress[] setMultipleEmails(String emailAddress) {
		String multipleEmails[] = emailAddress.split(";");
		InternetAddress[] addresses = new InternetAddress[multipleEmails.length];
		try {
			for (int i = 0; i < multipleEmails.length; i++) {
				addresses[i] = new InternetAddress(multipleEmails[i]);
			}
		} catch (AddressException e) {
			System.out.println("Adding multiple email addresses error!    " + e.getMessage());
		
		}
		return addresses;
	}

	public void sendEmail(List<String> attachments) {
		String emailMsgBody = "Dear All - Please is find the testing Results in the attachment ."
				+ "<br><br> Regards, <br>Test Automation Team<br>";

		// list of recipients
		setToAddress("ajalal@tech-res.com");

		sendEmail("tmail.tech-res.com", "25", "ajalal@tech-res.com", "Aj@2013n", "CMS-Smoke Report", emailMsgBody,
				attachments);
	}

	public void sendEmail(String host, String port, String emailUserID, String emailUserPassword, String subject,
			String emailBody, List<String> attachments) {
		try {
			// sets SMTP server properties
			Properties prop = new Properties();
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.port", port);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.startssl.enable", "false");
			// prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.user", emailUserID);
			prop.put("mail.password", emailUserPassword);
			System.out.println("step1> preparing email configuration...");
			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailUserID, emailUserPassword);
				}
			};
			Session session = Session.getInstance(prop, auth);

			// Create a new e-mail message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailUserID));
			msg.addRecipients(Message.RecipientType.TO, setMultipleEmails(toAddress));
			if (!ccAddress.isEmpty() && !ccAddress.equals(null)) {
				msg.addRecipients(Message.RecipientType.CC, setMultipleEmails(toAddress));
			}
			if (!bccAddress.isEmpty() && !bccAddress.equals(null)) {
				msg.addRecipients(Message.RecipientType.BCC, setMultipleEmails(toAddress));
			}
			msg.setSubject(subject);
			msg.setSentDate(new Date());

			// Creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(emailBody, "text/html");
			// Creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			// Adds attachments
			if (attachments.size() > 0 && attachments != null) {
				for (String singleAttachment : attachments) {
					MimeBodyPart attachPart = new MimeBodyPart();
					try {
						attachPart.attachFile(singleAttachment);
					} catch (IOException e) {

						
						System.out.println("Attaching files to email failed ...!    " + e.getMessage());
					}
					multipart.addBodyPart(attachPart);
				}
			}

		
			System.out.println("Step2> attaching report...");
			// sets the multi-part as email's content
			msg.setContent(multipart);
			// sends email

		
			System.out.println("Step3> Seding e-mail in progress...");
			Transport.send(msg);

			
			System.out.println("Step4> Sending e-mail complete...");
		} catch (Exception e) {
			System.out.println("Sending email failed...   " + e.getMessage());
		
		}
	}

//	public static void main(String[] args) {
//		EmailManager emailSender = new EmailManager();
//		List<String> files = new ArrayList<>();
//		files.add("src/test/resources/screenshots/test1.png");
//		files.add("src/test/resources/screenshots/ticket_result_2017_12_02_09_53_34_908.png");
//		emailSender.sendEmail(files);
//	}
//	

}
