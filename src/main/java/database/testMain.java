package database;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.a.LocalDateValueEncoder;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Customer;
import model.OrderDetails;
import model.PhanLoai;
import model.Product;
import model.TacGia;

public class testMain {
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer cs = new Customer("ds", "phukun0404vn", null, null, null, null, null, null, null, null, null);
		boolean check = customerDAO.checkTenTaiKhoan(cs.getTaiKhoan());
		System.out.println(check);
		
	}
}
