/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Son Vu
 */
public class BookedCar implements Serializable {
	private int id;
	private Date checkin;
	private Date checkout;
	private float price;
	private Car car;
	private List<Compensation> compensation;

	public BookedCar() {
		super();
	}

	public BookedCar(Date checkin, Date checkout, float price, Car car, List<Compensation> compensation) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
		this.car = car;
		this.compensation = compensation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Compensation> getCompensation() {
		return compensation;
	}

	public void setCompensation(List<Compensation> compensation) {
		this.compensation = compensation;
	}
	
}
