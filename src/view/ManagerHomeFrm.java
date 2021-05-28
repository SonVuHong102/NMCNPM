/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;

/**
 *
 * @author Son Vu
 */
public class ManagerHomeFrm extends javax.swing.JFrame implements ActionListener{

	/**
	 * Creates new form ManagerHomeFrm
	 */
	private User user;
	public ManagerHomeFrm(User user) {
		setTitle("Quản lý Thống kê");
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
		btnStat.addActionListener(this);
		btnStat.setActionCommand("btnStat");
		this.user = user;
		jLabel1.setText("Nhân viên : " + user.getName());
		jLabel2.setText("Chức vụ : " + user.getPosition());
		setVisible(true);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhân viên : ");

        jLabel2.setText("Thông tin nhân viên :");

        btnStat.setText("Xem Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnStat, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(btnStat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnStat")) {
			btnStatClick();
		}
	}
	private void btnStatClick() {
		new StatHomeFrm(user);
		this.dispose();
	}
}
