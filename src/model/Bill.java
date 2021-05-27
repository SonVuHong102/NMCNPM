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
	
	
}
