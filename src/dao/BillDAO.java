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
import java.util.List;
import model.Bill;
import model.BookedCar;
import model.Breakdown;
import model.ClientStat;
import model.Compensation;
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
		String query1 = "SELECT a.id AS idbill,a.payment_day,b.id AS idconstract,b.saleoff FROM tblbill a, tblcontract b, tblbookedcar c WHERE b.idclient = ? AND b.id = a.idcontract AND c.idcontract = b.id AND c.checkin > ? AND c.checkout < ? GROUP BY b.id ORDER BY a.payment_day ASC";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1,ct.getId());
            ps1.setString(2, sdf.format(sd));
			ps1.setString(3, sdf.format(ed));
            ResultSet rs1 = ps1.executeQuery();
             
            while(rs1.next()) {
				Bill rBill = new Bill();
                rBill.setId(rs1.getInt("idbill"));
                rBill.setPayment_date(rs1.getDate("payment_day"));
                Contract rContract = new Contract();
				rContract.setId(rs1.getInt("idconstract"));
				rContract.setSaleoff(rs1.getFloat("saleoff"));
				
				String query2 = "SELECT c.id AS idbookedcar, c.checkin, c.checkout, c.price FROM tblcontract b, tblbookedcar c WHERE b.id = ? AND c.idcontract = b.id AND c.checkin > ? AND c.checkout < ?";
				PreparedStatement ps2 = con.prepareStatement(query2);
				ps2.setInt(1,rContract.getId());
				ps2.setString(2, sdf.format(sd));
				ps2.setString(3, sdf.format(ed));
				ResultSet rs2 = ps2.executeQuery();
				List<BookedCar> listBookedCar = new ArrayList<>();
				while(rs2.next()) {
					BookedCar rBookedCar = new BookedCar();
					rBookedCar.setId(rs2.getInt("idbookedcar"));
					rBookedCar.setPrice(rs2.getFloat("price"));
					rBookedCar.setCheckin(rs2.getDate("checkin"));
					rBookedCar.setCheckout(rs2.getDate("checkout"));
					
					String query3 = " SELECT d.id,d.penalty,e.value FROM tblbookedcar c, tblcompensation d, tblbreakdown e WHERE d.idbookedcar = c.id AND d.idbreakdown = e.id AND c.id = ? AND c.checkin > ? AND c.checkout < ?";
					PreparedStatement ps3 = con.prepareStatement(query3);
					ps3.setInt(1,rBookedCar.getId());
					ps3.setString(2, sdf.format(sd));
					ps3.setString(3, sdf.format(ed));
					ResultSet rs3 = ps3.executeQuery();
					List<Compensation> listComensation = new ArrayList<>();
					while(rs3.next()) {
						Compensation rCompensation = new Compensation();
						rCompensation.setId(rs3.getInt("id"));
						rCompensation.setPenalty(rs3.getFloat("penalty"));
						Breakdown rBreakdown = new Breakdown();
						rBreakdown.setValue(rs3.getFloat("value"));
						
						rCompensation.setBreakdown(rBreakdown);
						listComensation.add(rCompensation);
					}
					rBookedCar.setCompensation(listComensation);
					listBookedCar.add(rBookedCar);
				}
				rContract.setBookedCar(listBookedCar);
				rContract.setClient(ct);
				rBill.setContract(rContract);
				
				rBill.setTotal_car_rent(rBill.getContract().getBookedCar().size());
			
				float temp1 = 0,temp2 = 0;
				for(BookedCar bc : rBill.getContract().getBookedCar()) {
					for(Compensation c : bc.getCompensation()) {
						temp1+=(c.getPenalty() + c.getBreakdown().getValue());
					}
					temp2+=(bc.getPrice()*(bc.getCheckout().getTime()-bc.getCheckin().getTime())/86400000);
				}
				rBill.setTotal_pen(temp1);
				rBill.setTotal_rent_money(temp2);
				rBill.setTotal(temp1+temp2);
                list.add(rBill);
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }	
		return list;
	}
}
