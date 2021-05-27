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
public class Compensation implements Serializable{
	private int id;
	private float penalty;
	private float total;
	private Breakdown breakdown;

	public Compensation() {
		super();
	}

	public Compensation(float penalty, float total, Breakdown breakdown) {
		super();
		this.penalty = penalty;
		this.total = total;
		this.breakdown = breakdown;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPenalty() {
		return penalty;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Breakdown getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(Breakdown breakdown) {
		this.breakdown = breakdown;
	}
	
	
}
