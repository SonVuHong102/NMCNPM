/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Son Vu
 */
public class Bill implements Serializable {
	private int id;
	private String name;
	private Date payment_date;
	private String payment_type;
	private int total_car_rent;
	private int total_rent_money;
	private float total_pen;
	private float total;
	private User user;
	private Contract contract;

	public Bill() {
		super();
	}

	public Bill(String name, Date payment_date, String payment_type, float total, User user, Contract contract) {
		super();
		this.name = name;
		this.payment_date = payment_date;
		this.payment_type = payment_type;
		this.total = total;
		this.user = user;
		this.contract = contract;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public int getTotal_car_rent() {
		return total_car_rent;
	}

	public void setTotal_car_rent(int total_car_rent) {
		this.total_car_rent = total_car_rent;
	}

	public int getTotal_rent_money() {
		return total_rent_money;
	}

	public void setTotal_rent_money(int total_rent_money) {
		this.total_rent_money = total_rent_money;
	}

	public float getTotal_pen() {
		return total_pen;
	}

	public void setTotal_pen(float total_pen) {
		this.total_pen = total_pen;
	}
	
	
}
