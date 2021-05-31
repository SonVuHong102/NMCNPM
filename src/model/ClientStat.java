/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Son Vu
 */
public class ClientStat extends Client implements Serializable {
	private int total_rent_time;
	private int total_rent_day;
	private float total_income;

	public ClientStat() {
		super();
	}

	public ClientStat(int total_rent_time, int total_rent_day, float total_income, String name, String address, String email, String tel, String note) {
		super(name, address, email, tel, note);
		this.total_rent_time = total_rent_time;
		this.total_rent_day = total_rent_day;
		this.total_income = total_income;
	}
	

	public int getTotal_rent_time() {
		return total_rent_time;
	}

	public void setTotal_rent_time(int total_rent_time) {
		this.total_rent_time = total_rent_time;
	}

	public int getTotal_rent_day() {
		return total_rent_day;
	}

	public void setTotal_rent_day(int total_rent_day) {
		this.total_rent_day = total_rent_day;
	}

	public float getTotal_income() {
		return total_income;
	}

	public void setTotal_income(float total_income) {
		this.total_income = total_income;
	}
	
	public Object[] toObject() {
		return new Object[] {
			this.getId(), this.getName(), this.getAddress(), this.getEmail(), this.getTel(), this.total_rent_time,
			this.total_rent_day, this.total_income
		};
	}
}
