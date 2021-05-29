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
		String query = 
				"SELECT e.id, e.name,e.address,e.email,e.tel,e.note,\n" +
				"	(SELECT c.times FROM\n" +
				"		((SELECT b.idclient, COUNT(b.id) as times\n" +
				"		FROM tblcontract b\n" +
				"		WHERE b.id IN (\n" +
				"			SELECT a.idcontract \n" +
				"			FROM tblbookedcar a \n" +
				"			WHERE a.checkin > ? AND a.checkout < ?)\n" +
				"		GROUP BY b.idclient) ) c\n" +
				"    WHERE c.idclient = e.id) as total_rent_time\n" +
				"FROM tblclient e"; // add sth
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sdf.format(sd));
            ps.setString(2, sdf.format(ed));

            ResultSet rs = ps.executeQuery();
             
            while(rs.next()) {
                ClientStat r = new ClientStat();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setAddress(rs.getString("address"));
                r.setEmail(rs.getString("email"));
                r.setTel(rs.getString("tel"));
                r.setNote(rs.getString("note"));
				r.setTotal_rent_time(rs.getInt("total_rent_time"));
				System.out.println(r.getTotal_rent_time());
                list.add(r);
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }	
		return list;
	}
	
}
