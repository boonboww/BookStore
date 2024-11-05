package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.Util;

import database.CustomerDAO;
import model.Customer;
import util.MaHoa;
import util.Mail;
import util.OTPCode;

/**
 * Servlet implementation class Customer_Controlller
 */
@WebServlet("/customer-controller")
public class Customer_Controlller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Customer_Controlller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// config UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		  String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		String activity = request.getParameter("event");
		// check event
		/*
		 * if (activity.equals("Signin")) { Signin(request, response); } else if
		 * (activity.equals("Logout")) { Logout(request, response); } else if
		 * (activity.equals("Register")) { Register(request, response); } else if
		 * (activity.equals("ChangePassword")) { ChangePassword(request, response); }
		 * else if (activity.equals("ChangeInfoUser")) { ChangeInfoUser(request,
		 * response); } else if (activity.equals("SendMailCustomer")) {
		 * SendMailCustomer(request, response); } else if
		 * (activity.equals("SendMailCustomerInSupport")) {
		 * SendMailCustomerInSupport(request, response); } else if
		 * (activity.equals("CheckVerifyInfomation")) { CheckVerifyInfomation(request,
		 * response); }
		 */
		
		switch (activity) {
		  case "Signin":
		    Signin(request, response);
		    break;
		  case "Logout":
		    Logout(request, response);
		    break;
		  case "Register":
		    Register(request, response);
		    break;
		  case "ChangePassword":
		    ChangePassword(request, response);
		    break;
		  case "ChangeInfoUser":
		    ChangeInfoUser(request, response);
		    break;
		  case "SendMailCustomer":
		    SendMailCustomer(request, response);
		    break;
		  case "SendMailCustomerInSupport":
		    SendMailCustomerInSupport(request, response);
		    break;
		  case "CheckVerifyInfomation":
		    CheckVerifyInfomation(request, response);
		    break;
		  case "SendVerifyOTP":
			  SendVerifyOTP(request, response);
		  
		  
		  default:
		   
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void Signin(HttpServletRequest request, HttpServletResponse response) {
		try {
			 String urlfix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
			String tenTaiKhoan = request.getParameter("inputAccount");
			String matKhau = request.getParameter("inputPassword");
			// mã hóa pass hiện tại để check với pass trong DB
			matKhau = MaHoa.toSHA_1(matKhau);

			String msg_error = "";
			CustomerDAO customerDAO = new CustomerDAO();
			Customer cs = customerDAO.selectByName(tenTaiKhoan);

			// tmp
			String tmp = "";

			// check taikhoan va matkhau
			if (cs == null) {
				String tenTaiKhoan_error = "";
				msg_error += "*Tài khoản không đúng!";
				request.setAttribute("tenTaiKhoan", tenTaiKhoan_error);

			} else if (!matKhau.equals(cs.getMatKhau())) {

				request.setAttribute("tenTaiKhoan", tenTaiKhoan);
				msg_error += "*Sai mật khẩu!";
			} else {
				// tk và pass đúng thì set user vào session
				HttpSession session = request.getSession(true);
				session.setAttribute("taiKhoan", cs);
				tmp = session.getId();
			}

			request.setAttribute("msg_error", msg_error);
			request.setAttribute("tmp", tmp);
			String url = "";
			if (msg_error.length() > 0) {
				url = "/customer_view/signin.jsp";
			} else {
				url ="/home.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			// hủy bỏ tất cả các session
			session.invalidate();
			
			// chuẩn link
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
			// quay lại trang chủ
			response.sendRedirect( url +"/index.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Register(HttpServletRequest request, HttpServletResponse response) {
		try {
			// config UTF-8
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String tenTaiKhoan = request.getParameter("inputAccount");
			String matKhau = request.getParameter("inputPassword");
			String matKhauCheck = request.getParameter("inputPasswordCheck");
			String tenKhachHang = request.getParameter("inputName");
			String gioiTinh = request.getParameter("inputGioiTinh");
			String ngaySinh = request.getParameter("inputNgaySinh");
			String soDienThoai = request.getParameter("inputSDT");
			String eMail = request.getParameter("inputEmail");
			String diaChi = request.getParameter("inputDiaChi");
			String diaChiNhanHang = request.getParameter("inputDiaChiNhanHang");
			String diaChiMuaHang = request.getParameter("inputDiaChiMuaHang");

			// save data để hiển thị lại khi sai
			request.setAttribute("tenTaiKhoan", tenTaiKhoan);
			request.setAttribute("tenKhachHang", tenKhachHang);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("soDienThoai", soDienThoai);
			request.setAttribute("eMail", eMail);
			request.setAttribute("diaChi", diaChi);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);

			String msg_error = "";

			CustomerDAO ctmDAO = new CustomerDAO();
			if (ctmDAO.checkTenTaiKhoan(tenTaiKhoan)) {
				msg_error += "Tài khoản đã tồn tại. <br>";
			}
			if (!matKhau.equals(matKhauCheck)) {
				msg_error += "Mật khẩu không trùng khớp. <br>";
			} else {
				// đúng mã hóa mật khẩu
				matKhau = MaHoa.toSHA_1(matKhau);
			}

			request.setAttribute("msg_error", msg_error);
			String url = "";
			if (msg_error.length() > 0) {
				url = "/customer_view/register.jsp";
			}

			// nếu không lỗi thì insert vào DB
			else {
				// random id bất kì cho user mới

				Random rand = new Random();
				String maKhachHang = "KH" + String.valueOf(System.currentTimeMillis() + rand.nextInt(10));
				Customer cusNew = new Customer(maKhachHang, tenTaiKhoan, matKhau, tenKhachHang, gioiTinh,
						Date.valueOf(ngaySinh), soDienThoai, eMail, diaChi, diaChiNhanHang, diaChiMuaHang);
				if(ctmDAO.insert(cusNew) == 1) {
					String maOTP = OTPCode.CreateOTP();
					Date timeOutOTP = OTPCode.timeOutOTP();
					Boolean trangThaiXacThuc = false;
					
					cusNew.setMaOTP(maOTP);
					cusNew.setTimeOutOTP(timeOutOTP);
					cusNew.setTrangThaiXacThuc(trangThaiXacThuc);   
					if(ctmDAO.updateXacThucThongTin(cusNew)) {
						// gửi email xác nhận mã OTP
						Mail.SendMail(cusNew.getEmail(), "Xác Nhận Tài Khoản BookStore", getContentEmail(cusNew));
					}
					
				}
				
				
				
				
				url = "/home.jsp";

			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void ChangePassword(HttpServletRequest request, HttpServletResponse response) {
		try {

			String oldPass = request.getParameter("OldPassword");
			String newPass = request.getParameter("NewPassword");
			String checkNewPass = request.getParameter("checkNewPassword");
			// mã hóa mk cũ vừa nhập
			String OldPassEncrypted = MaHoa.toSHA_1(oldPass);

			String error = "";
			String url = "";

			HttpSession session = request.getSession();
			CustomerDAO csd = new CustomerDAO();
			Object obj = session.getAttribute("taiKhoan");
			Customer cs = null;
			if (obj != null) {
				cs = (Customer) obj;
			}
			// nếu = null thì chưa đăng nhập
			if (cs == null) {

				error = "Chưa đăng nhập!";
				url = "/signin.jsp";

			} else {
				// get mk trong DB lên check với mk cũ nhập
				String checkOldPassCrypted = cs.getMatKhau();

				if (!OldPassEncrypted.equals(checkOldPassCrypted)) {
					error = "Mật khẩu cũ không đúng!";
					url = "/customer_view/changePassword.jsp";
				} else {
					// kiểm tra mật khẩu mới có khớp không
					if (!newPass.equals(checkNewPass)) {
						error = "Mật khẩu mới không khớp!";
						url = "/customer_view/changePassword.jsp";
					} else {
						String newPassCrypted = MaHoa.toSHA_1(newPass);
						// lưu vào DB
						if (csd.chagePassword(cs, newPassCrypted)) {
							error = "Thay đổi thành công!";
							url = "/customer_view/changePassword.jsp";
						} else {
							error = "Thay đổi thất bại";
							url = "/customer_view/changePassword.jsp";
						}

					}
				}
			}

			if (error.length() > 0) {

				request.setAttribute("msg_error_chagePass", error);
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ChangeInfoUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			// config UTF-8
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String tenTaiKhoan = request.getParameter("inputAccount");
			String tenKhachHang = request.getParameter("inputName");
			String gioiTinh = request.getParameter("inputGioiTinh");
			String ngaySinh = request.getParameter("inputNgaySinh");
			String soDienThoai = request.getParameter("inputSDT");
			String eMail = request.getParameter("inputEmail");
			String diaChi = request.getParameter("inputDiaChi");
			String diaChiNhanHang = request.getParameter("inputDiaChiNhanHang");
			String diaChiMuaHang = request.getParameter("inputDiaChiMuaHang");

			//lấy user trong session ra để update
			String error = "";
			String url = "/customer_view/changeInfoUser.jsp";
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("taiKhoan");
			Customer cs = null;
			if (obj != null) {
				cs = (Customer) obj;
			}
			if (cs != null) {
				String maKhachHang = cs.getMaKhachHang();
				Customer customer = new Customer(maKhachHang, tenTaiKhoan, "123", tenKhachHang, gioiTinh,
						Date.valueOf(ngaySinh), soDienThoai, eMail, diaChi, diaChiNhanHang, diaChiMuaHang);
				CustomerDAO csd = new CustomerDAO();
				if (csd.updateInfoUser(customer)) {
					error = "*Cập nhật thành công!";
					
					// đồng bộ lại session
					Customer cs2 = csd.selectById(cs);
					session.setAttribute("taiKhoan", cs2);
				} else {
					error = "*Cập nhật thất bại!";
				}

			}

			request.setAttribute("msg_error_changeInfoUser", error);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void SendMailCustomer(HttpServletRequest request, HttpServletResponse response) {
		String cusMail = request.getParameter("mailCustomer");
		String error = "";
		try {
			if(!cusMail.endsWith("@gmail.com")) {
				error = "Vui lòng nhập đúng email!";
			}
			else {
				error = "Gửi phản hồi thành công!";
				Mail mail = new Mail();
				mail.SendMail(cusMail, "BookStore Xin chào quý khách !!! ", "<html><body><h1 style=color:pink;>Chúc mừng bạn trúng 2 tỷ</h1</body></html>");
			}
			
			String url = "/home.jsp";
			request.setAttribute("msg_error_email", error);
					
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private void SendMailCustomerInSupport(HttpServletRequest request, HttpServletResponse response) {
		String cusMailInSupport = request.getParameter("mailCustomerInSupport");
		String error = "";
		try {
			if(!cusMailInSupport.endsWith("@gmail.com")) {
				error = "Vui lòng nhập đúng email!";
			}
			else {
				error = "Gửi phản hồi thành công!";
				Mail mail = new Mail();
				mail.SendMail(cusMailInSupport, "BookStore Xin chào quý khách !!! ", "<html><body><h1 style=color:red;>Chúc Mừng bạn trúng 2 tỷ</h1</body></html>");
			}
			 String urlFix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
			String url ="/customer_view/support.jsp";
			request.setAttribute("msg_error_email_inSupport", error);
					
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getContentEmail(Customer cs) {
		String content = "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\" />\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "  <link rel=\"stylesheet\" href=\"style.css\" />\r\n"
				+ "  <title>Browser</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "  <h1>\r\n"
				+ "   BookStore Chúc mừng bạn đã đăng kí thành công \r\n"
				+ "  </h1>\r\n"
				+ "  <p>\r\n"
				+ "    Đây là mã OTP xác nhận tài khoản <span style=\"color:green; \"> " + cs.getMaOTP() + " <span>\r\n"
				+ "  </p>\r\n"
				+ "  <script src=\"script.js\"></script>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>";
		return content;
	}

	private void CheckVerifyInfomation(HttpServletRequest request , HttpServletResponse response) {
		try {
			String iOTP = request.getParameter("iOTP");
			String msg_e_otp = "";
			String url = "";
			HttpSession session = request.getSession();
			
			// lấy thông tin account trong session
			Customer cs = (Customer)session.getAttribute("taiKhoan");
			
			if(!iOTP.equals(cs.getMaOTP())) {
				
				msg_e_otp = "Mã xác nhận không đúng";
				url = "/customer_view/VerifyInformation.jsp";
			}
			else {
				//check timeout của otp 
				if (!cs.getTimeOutOTP().before(OTPCode.timeNow())) {
				cs.setTrangThaiXacThuc(true);
				CustomerDAO csDao = new CustomerDAO();
				csDao.updateTrangThaiXacThuc(cs);
				
				
				//đồng bộ session
				session.setAttribute("taiKhoan",cs);
				
				msg_e_otp = "Xác nhận thành công";
				url = "/home.jsp";
				}
				else {
					msg_e_otp = "Mã xác nhận hết hạn";
					url = "/customer_view/VerifyInformation.jsp";
				}
			}
			request.setAttribute("msg_e_otp", msg_e_otp);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void SendVerifyOTP(HttpServletRequest request , HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			CustomerDAO csDAO = new CustomerDAO();
			Customer cs = (Customer)session.getAttribute("taiKhoan");
			if(cs == null) {
				System.out.println("cs null");
			}
			else {
				
				String maOTP = OTPCode.CreateOTP();
				Date timeOutOTP = OTPCode.timeOutOTP();
				Boolean trangThaiXacThuc = false;
				
				cs.setMaOTP(maOTP);
				cs.setTimeOutOTP(timeOutOTP);
				cs.setTrangThaiXacThuc(trangThaiXacThuc);
				// update OTP mới cho customer
				if(csDAO.updateXacThucThongTin(cs)) {
					util.Mail.SendMail(cs.getEmail(), "Xác Nhận Tài Khoản BookStore " , getContentEmail(cs) );
					System.out.println("đã send otp");
				}
			}
			String msg_VerifyOTP = "Đã gửi";
			String url = "/customer_view/VerifyInformation.jsp";
			request.setAttribute("msg_VerifyOTP", msg_VerifyOTP);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
