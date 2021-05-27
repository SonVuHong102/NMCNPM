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
public class Breakdown implements Serializable{
	private int id;
	private String kind;
	private float value;

	public Breakdown() {
		super();
	}

	public Breakdown(String kind, float value) {
		super();
		this.kind = kind;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}
