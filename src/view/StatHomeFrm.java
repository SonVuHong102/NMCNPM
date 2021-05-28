/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author Son Vu
 */
public class StatHomeFrm extends javax.swing.JFrame implements ActionListener{

	/**
	 * Creates new form StatHomeFrm
	 */
	private User user;
	public StatHomeFrm(User user) {
		setTitle("Thống kê");
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
		this.user = user;
		btnClientStat.addActionListener(this);
		btnClientStat.setActionCommand("btnClienStat");
		btnCarStat.addActionListener(this);
		btnCarStat.setActionCommand("btnCarStat");
		setVisible(true);
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCarStat = new javax.swing.JButton();
        btnClientStat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Xem Thống kê");

        btnCarStat.setText("Thống kê XE theo doanh thu");

        btnClientStat.setText("Thống kê KHÁCH HÀNG theo doanh thu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientStat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(103, 103, 103))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnCarStat, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(btnCarStat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientStat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarStat;
    private javax.swing.JButton btnClientStat;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnClienStat")) {
			btnClientStatClick();
		} else if (e.getActionCommand().equals("btnCarStat")){
			JOptionPane.showMessageDialog(this, "Chức năng này chưa được phát triển"
						, "Warring", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void btnClientStatClick() {
		new ClientStatFrm(user);
		this.dispose();
	} 
}
