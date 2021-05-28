/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package nmcnpm;

import model.User;
import view.ClientStatFrm;

/**
 *
 * @author Son Vu
 */
public class NMCNPM {
	public static void main(String[] args) {
		User u = new User("manager","manager","manager","manager");
		new ClientStatFrm(u);
	}
}
