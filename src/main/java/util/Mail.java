package util;


import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	//bjorntzmine@gmail.com
	//mk : iiwohmokkmdcvmkt
	
	static final String from = "bjorntzmine@gmail.com";
	static final String passwordEmail = "iiwohmokkmdcvmkt";
	

	public static boolean SendMail(String emailReciprient,String title, String content) {
		
		
		
	// Properties : khai báo các thuộc tính  
	Properties props = new Properties(); 
	props.put("mail.smtp.host", "smtp.gmail.com"); // STMP HOST
	props.put("mail.smtp.port", "587"); // STL-587 SSL-465
	props.put("mail.smtp.auth", "true"); // check đăng nhập
	props.put("mail.smtp.starttls.enable", "true"); // khởi động giao thức TSL
	
	

	//create authenticator 
	Authenticator auth = new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new PasswordAuthentication(from, passwordEmail);
		}
	
	};
	
	//phiên làm việc
	Session session = Session.getInstance(props,auth);
	
	
	//tạo message
	MimeMessage msg = new MimeMessage(session);
	try {
		//kiểu dữ liệu gửi
		msg.addHeader("Content-type", "text/HTML; charset=utf-8");
		
		//người gửi
		msg.setFrom(from);
		
		//người nhận (Type send mail,check address)
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReciprient,false));
		
		// tiêu đề
		msg.setSubject(title);
		
		// Nội dung
		msg.setContent(content,"text/html; charset=utf-8");
		
		// gửi mail
		Transport.send(msg);
		System.out.println("Process Success");
		return true;
	} catch (Exception e) {
		System.out.println("Tiến trình thất bại");
		e.printStackTrace();
		return false;
	}
	
	
	
	
	}
	public static void main(String[] args) {
		String to = "phukun0404@gmail.com";
		String content = "<html><body> " + 
			 " <a href=\"https://sex.vlxyz.vc/\"> <h1  style=color:red; text-decoration: none; > Bạn đã tham gia nhóm <br> </h1>  <img alt=\"\" src=\"https://bedental.vn/wp-content/uploads/2022/11/hot-girl.jpg\"> </a> </body></html>";
		
		
		for (int i = 0; i < 1; i++) {
			String title = "Động đỹ" ;
			SendMail(to, title, content);
		}
		
		
	}
	
}
