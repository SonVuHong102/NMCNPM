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
public class Car implements Serializable {
	private int id;
	private String name;
	private String type;
	private String number;
	private String color;
	private String specific;
	private Date year;

	public Car() {
		super();
	}

	public Car(String name, String type, String number, String color, String specific, Date year) {
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.color = color;
		this.specific = specific;
		this.year = year;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
	
}
