/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Bill;
import model.BookedCar;
import model.ClientStat;
import model.Contract;

/**
 *
 * @author Son Vu
 */
public class BillDAO extends DAO {

	public BillDAO() {
		super();
	}

	public static ArrayList<Bill> searchClientBill(Date sd, Date ed, ClientStat ct) {
		ArrayList<Bill> list = new ArrayList<>();
		String query = "SELECT a.id, a.payment_day, b.id AS idconstract, b.saleoff, IFNULL((SELECT SUM(f.total) FROM (SELECT c.idcontract,(SELECT SUM(d.penalty + e.value) FROM tblcompensation d, tblbreakdown e WHERE d.idbreakdown = e.id AND d.idbookedcar = c.id AND c.checkin > ? AND c.checkout < ?) AS total FROM tblbookedcar c) f WHERE f.idcontract = b.id),0) as total_pen, (SELECT SUM(c.price) FROM tblbookedcar c WHERE c.checkin > ? AND c.checkout < ? AND c.idcontract = b.id) as total_rent_money, (SELECT COUNT(c.id) FROM tblbookedcar c WHERE c.checkin > ? AND c.checkout < ? AND c.idcontract = b.id) AS total_rent_car FROM tblbill a, tblcontract b WHERE b.idclient = ? AND b.id = a.idcontract ORDER BY a.payment_day ASC";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sdf.format(sd));
            ps.setString(2, sdf.format(ed));
			ps.setString(3, sdf.format(sd));
			ps.setString(4, sdf.format(ed));
            ps.setString(5, sdf.format(sd));
			ps.setString(6, sdf.format(ed));
            ps.setInt(7, ct.getId());
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()) {
				Bill rB = new Bill();
                rB.setId(rs.getInt("id"));
                rB.setPayment_date(rs.getDate("payment_day"));
                Contract rC = new Contract();
				rC.setId(rs.getInt("idconstract"));
				rC.setSaleoff(rs.getFloat("saleoff"));
				BookedCar rBC = new BookedCar();
				rBC.setId(rs.getInt("idbookedcar"));
				rBC.setCheckin(rs.getDate("checkin"));
				rBC.setCheckout(rs.getDate("checkout"));
				rBC.setPrice(rs.getFloat("price"));
				
//                list.add(r);
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }	
		return list;
	}
}
