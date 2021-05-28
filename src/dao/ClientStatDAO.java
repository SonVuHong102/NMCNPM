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
public class ClientStatDAO {
	
	public ClientStatDAO() {
		super();
	}
	
	public static List<ClientStat> searchClientStat(Date sd, Date ed) {
		List<ClientStat> list = new ArrayList<ClientStat>();
		String query = ""; // add sth
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sdf.format(ed));
            ps.setString(2, sdf.format(sd));
            ps.setString(3, sdf.format(sd));
            ps.setString(4, sdf.format(ed));
            ps.setString(5, sdf.format(ed));
            ps.setString(6, sdf.format(sd));
            ps.setString(7, sdf.format(sd));
            ps.setString(8, sdf.format(ed));
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()) {
                ClientStat r = new ClientStat();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setAddress(rs.getString("address"));
                r.setEmail(rs.getString("email"));
                r.setTel(rs.getString("tel"));
                r.setNote(rs.getString("note"));
                list.add(r);
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }	
		return list;
	}
	
}
