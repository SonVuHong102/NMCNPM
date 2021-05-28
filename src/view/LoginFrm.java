/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package view;

import dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author Son Vu
 */
public class LoginFrm extends javax.swing.JFrame implements ActionListener {

	/**
	 * Creates new form LoginFrm
	 */
	public LoginFrm() {
		setTitle("Đăng nhập Thống kê");
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
		btnLogin.addActionListener(this);
		btnLogin.setActionCommand("btnLogin");
		setVisible(true);
	}
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập Hệ thống");

        jLabel2.setText("username :");

        jLabel3.setText("password :");

        btnLogin.setText("Đăng Nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnLogin)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnLogin")) {
			btnLoginClick();
		}
	}
	
	private void btnLoginClick() {
		User u = new User();
		u.setUsername(txtUsername.getText());
		u.setPassword(txtPassword.getText());
		UserDAO ud = new  UserDAO();
		if(ud.checkLogin(u)) {
			if(u.getPosition().equalsIgnoreCase("manager") || u.getPosition().equalsIgnoreCase("admin")) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Info", JOptionPane.INFORMATION_MESSAGE);
				new ManagerHomeFrm(u);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Chỉ Manager hoặc Admin được sử dụng chức năng hiện tại"
						, "Warring", JOptionPane.WARNING_MESSAGE);
			}	
		} else {
			JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác", "Warring", JOptionPane.WARNING_MESSAGE);
		}
	}
}
