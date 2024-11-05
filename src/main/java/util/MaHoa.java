package util;

import java.security.MessageDigest;



import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
		public static String toSHA_1(String text) {
			String codeS = "d!tconmem@yconchon@y";
			String result = null;
			text+= codeS;
			
			try {
				byte[] dataBytes = text.getBytes("UTF-8");
				System.out.println(dataBytes);
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				result = Base64.encodeBase64String(md.digest(dataBytes));
			} catch (Exception e) {
				e.printStackTrace();
		}
			return result;
}
		
		
}
