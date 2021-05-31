/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package view;

import dao.BillDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.ClientStat;
import model.User;

/**
 *
 * @author Son Vu
 */
public class ClientDetailFrm extends javax.swing.JFrame implements ActionListener {

	/**
	 * Creates new form ClientDetailFrm
	 */
	private User user;
	private Date sd;
	private Date ed;
	private ClientStat ct;
	
	public ClientDetailFrm(User user,ClientStat ct,Date sd,Date ed) {
		this.user = user;
		this.sd = sd;
		this.ed = ed;
		this.ct = ct;
		setTitle("Thống kê chi tiết");
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
		btnBack.addActionListener(this);
		btnBack.setActionCommand("btnBack");
		start();
		
		setVisible(true);
	}
	
	private void start() {
		BillDAO bd = new BillDAO();
		List<Bill> list = bd.searchClientBill(sd,ed,ct);
		DefaultTableModel model = (DefaultTableModel) tblBill.getModel();
		for(Bill b : list) {
			model.addRow(b.toObject());
		}
	}
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Xem Thống kê chi tiết");

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "id Hóa đơn", "Khách hàng", "Ngày thuê", "Ngày trả",
                "Số xe thuê","Số tiền thuê","Số tiền phạt","Tổng thu"
            }
        ));
        jScrollPane1.setViewportView(tblBill);

        btnBack.setText("Quay lại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(319, 319, 319))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnBack)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnBack")) {
			new ManagerHomeFrm(user);
			this.dispose();
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBill;
    // End of variables declaration//GEN-END:variables
}
