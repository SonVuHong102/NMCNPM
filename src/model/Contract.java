/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Son Vu
 */
public class Contract implements Serializable {
	private int id;
	private float saleoff;
	private int day_book;
	private float total;
	private String note;
	private List<BookedCar> bookedCar;
	private User user;
	private Client client;
	private List<Ensured> ensured;

	public Contract() {
		super();
	}

	public Contract(float saleoff, int day_book, float total, String note, List<BookedCar> bookedCar, User user, Client client, List<Ensured> ensured) {
		super();
		this.saleoff = saleoff;
		this.day_book = day_book;
		this.total = total;
		this.note = note;
		this.bookedCar = bookedCar;
		this.user = user;
		this.client = client;
		this.ensured = ensured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(float saleoff) {
		this.saleoff = saleoff;
	}

	public int getDay_book() {
		return day_book;
	}

	public void setDay_book(int day_book) {
		this.day_book = day_book;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<BookedCar> getBookedCar() {
		return bookedCar;
	}

	public void setBookedCar(List<BookedCar> bookedCar) {
		this.bookedCar = bookedCar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Ensured> getEnsured() {
		return ensured;
	}

	public void setEnsured(List<Ensured> ensured) {
		this.ensured = ensured;
	}
	
	
}
