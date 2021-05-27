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
public class Client implements Serializable{
	private int id;
	private String name;
	private String address;
	private String email;
	private String tel;
	private String note;

	public Client() {
		super();
	}

	public Client(String name, String address, String email, String tel, String note) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.note = note;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
