/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package model;

/**
 *
 * @author Son Vu
 */
public class Collateral {
	private int id;
	private String kind;
	private String description;

	public Collateral() {
		super();
	}

	public Collateral(String kind, String description) {
		super();
		this.kind = kind;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
