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
public class Ensured implements Serializable {
	private int id;
	private int amount;
	private float value;
	private Date duration;
	private Collateral collateral;

	public Ensured() {
		super();
	}

	public Ensured(int amount, float value, Date duration, Collateral collateral) {
		this.amount = amount;
		this.value = value;
		this.duration = duration;
		this.collateral = collateral;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Collateral getCollateral() {
		return collateral;
	}

	public void setCollateral(Collateral collateral) {
		this.collateral = collateral;
	}
	
}
