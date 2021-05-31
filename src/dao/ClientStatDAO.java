/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package dao;

import static dao.DAO.con;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ClientStat;

/**
 *
 * @author Son Vu
 */
public class ClientStatDAO extends DAO {
	
	public ClientStatDAO() {
		super();
	}
	
	public static List<ClientStat> searchClientStat(Date sd, Date ed) {
		List<ClientStat> list = new ArrayList<ClientStat>();
		String query = "SELECT a.*, (SELECT SUM(DATEDIFF(LEAST(c.checkout, ?), GREATEST(c.checkin, ?))) FROM tblbookedcar c, tblcontract b WHERE c.idcontract = b.id AND b.idclient = a.id AND c.checkout < ? AND c.checkin > ? GROUP BY b.iduser) as total_rent_day, (SELECT COUNT(c.idcontract) FROM tblbookedcar c, tblcontract b WHERE c.checkin > ? AND c.checkout < ? AND c.idcontract = b.id AND b.idclient = a.id) as total_rent_time, (SELECT SUM(DATEDIFF(LEAST(c.checkout, ?), GREATEST(c.checkin, ?))*c.price) FROM tblbookedcar c, tblcontract b WHERE c.idcontract = b.id AND b.idclient = a.id AND c.checkout < ? AND c.checkin > ? GROUP BY b.iduser) as total_income FROM tblclient a GROUP BY a.id ORDER BY total_income DESC, total_rent_day DESC";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sdf.format(ed));
            ps.setString(2, sdf.format(sd));
			ps.setString(3, sdf.format(ed));
            ps.setString(4, sdf.format(sd));
			ps.setString(5, sdf.format(sd));
            ps.setString(6, sdf.format(ed));
			ps.setString(7, sdf.format(ed));
            ps.setString(8, sdf.format(sd));
			ps.setString(9, sdf.format(ed));
            ps.setString(10, sdf.format(sd));
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()) {
                ClientStat r = new ClientStat();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setAddress(rs.getString("address"));
                r.setEmail(rs.getString("email"));
                r.setTel(rs.getString("tel"));
                r.setNote(rs.getString("note"));
				r.setTotal_rent_day(rs.getInt("total_rent_day"));
				r.setTotal_rent_time(rs.getInt("total_rent_time"));
				r.setTotal_income(rs.getInt("total_income"));
                list.add(r);
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }	
		return list;
	}
	
}
