import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;



import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hotel {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	
	
	/**
	 * Launch the application.
	 */
	
	public void updateTable() {
//		conn = hotelData.ConnectDB();
		//hotelData sqlConnect = new hotelData();
		conn = hotelData.connect();
		if(conn !=null) {
			String sql="Select cusRef,firstName,SurName,sddress,PostCode,Mobile,Email,Gender,DOB,Nationality,ProveofID,DateIn,DateOut,RoomType,RoomNo,RoomExt from hoteldb";
			
			
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[16];
				
				while(rs.next()) {
					columnData[0] = rs.getString("cusRef");
					columnData[1] = rs.getString("firstName");
					columnData[2] = rs.getString("SurName");
					columnData[3] = rs.getString("sddress");
					columnData[4] = rs.getString("PostCode");
					columnData[5] = rs.getString("Mobile");
					columnData[6] = rs.getString("Email");
					columnData[7] = rs.getString("Gender");
					columnData[8] = rs.getString("DOB");
					columnData[9] = rs.getString("Nationality");
					columnData[10] = rs.getString("ProveofID");
					columnData[11] = rs.getString("DateIn");
					columnData[12] = rs.getString("DateOut");
					columnData[13] = rs.getString("RoomType");
					columnData[14] = rs.getString("RoomNo");
					columnData[15] = rs.getString("RoomExt");
					model.addRow(columnData);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "connection Error");System.out.println("Failed2");
				e.printStackTrace();
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel window = new Hotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();System.out.println("Failed3");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hotel() {
		initialize();
		
		Object col[] = {"cusRef","firstName","SurName","sddress","PostCode","Mobile","Email","Gender","DOB","Nationality","ProveofID","DateIn","DateOut","RoomType","RoomNo","RoomExt"};
				model.setColumnIdentifiers(col);
				table.setModel(model);
				
				JLabel lblNewLabel_1 = new JLabel("Hotel Record System");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
				lblNewLabel_1.setBounds(726, 33, 407, 37);
				frame.getContentPane().add(lblNewLabel_1);
				conn = hotelData.connect();
				updateTable();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		frame.setBounds(0, 0, 1470, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 363, 608);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Ref");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 38, 113, 17);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 33, 200, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblfirstName = new JLabel("First Name");
		lblfirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblfirstName.setBounds(20, 71, 113, 17);
		panel.add(lblfirstName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 66, 200, 29);
		panel.add(textField_1);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSurname.setBounds(20, 104, 113, 17);
		panel.add(lblSurname);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(131, 99, 200, 29);
		panel.add(textField_2);
		
		JLabel lblsddress = new JLabel("sddress");
		lblsddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsddress.setBounds(20, 137, 113, 17);
		panel.add(lblsddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 132, 200, 29);
		panel.add(textField_3);
		
		JLabel lblPostCode = new JLabel("Post Code");
		lblPostCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostCode.setBounds(20, 170, 113, 17);
		panel.add(lblPostCode);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(131, 165, 200, 29);
		panel.add(textField_4);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(20, 203, 113, 17);
		panel.add(lblMobileNo);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 198, 200, 29);
		panel.add(textField_5);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(20, 236, 113, 17);
		panel.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(131, 231, 200, 29);
		panel.add(textField_6);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(20, 269, 113, 17);
		panel.add(lblGender);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNationality.setBounds(20, 302, 113, 17);
		panel.add(lblNationality);
		
		JLabel lblProveOfId = new JLabel("Prove of ID");
		lblProveOfId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProveOfId.setBounds(20, 335, 113, 17);
		panel.add(lblProveOfId);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth.setBounds(20, 368, 113, 17);
		panel.add(lblDateOfBirth);
		
		JLabel lblInDate = new JLabel("Date In");
		lblInDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInDate.setBounds(20, 401, 113, 17);
		panel.add(lblInDate);
		
		JLabel lblOutDate = new JLabel("Date Out ");
		lblOutDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOutDate.setBounds(20, 434, 113, 17);
		panel.add(lblOutDate);
		
		JLabel lblMeal = new JLabel("Meal");
		lblMeal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMeal.setBounds(20, 467, 113, 17);
		panel.add(lblMeal);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoomType.setBounds(20, 500, 113, 17);
		panel.add(lblRoomType);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoomNo.setBounds(20, 533, 113, 17);
		panel.add(lblRoomNo);
		
		JLabel lblRoomExtNo = new JLabel("Room Ext. No");
		lblRoomExtNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoomExtNo.setBounds(20, 566, 113, 17);
		panel.add(lblRoomExtNo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Female", "Male"}));
		comboBox.setBounds(131, 264, 200, 29);
		panel.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select ID Proof", "Passport", "Aadhar", "Driving License"}));
		comboBox_2.setBounds(131, 330, 200, 29);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Select Menu", "Breakfast", "Lunch", "Dinner"}));
		comboBox_3.setBounds(131, 462, 200, 29);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select Room Type", "Single", "Double", "Family"}));
		comboBox_4.setBounds(131, 495, 200, 29);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Select Room No", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"}));
		comboBox_5.setBounds(131, 528, 200, 29);
		panel.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Select Room Extension No", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"}));
		comboBox_6.setBounds(131, 561, 200, 29);
		panel.add(comboBox_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 363, 200, 29);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(131, 396, 200, 29);
		panel.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(131, 429, 200, 29);
		panel.add(dateChooser_2);
		
		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(131, 297, 200, 29);
		panel.add(localeChooser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(383, 102, 1061, 517);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1041, 586);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CustomerRef", "firstName", "Surname", "sddress", "Post Code", "Mobile", "Email", "Gender", "Date of Birth", "Nationality", "Proof of Id", "Date In", "Date Out", "Room type", "Room No", "Room Extension No"
			}
		));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 630, 1434, 120);
		frame.getContentPane().add(panel_2);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setLayout(null);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTax.setBounds(20, 16, 113, 17);
		panel_2.add(lblTax);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(131, 11, 200, 29);
		panel_2.add(textField_17);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubTotal.setBounds(20, 49, 113, 17);
		panel_2.add(lblSubTotal);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(131, 44, 200, 29);
		panel_2.add(textField_18);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(20, 82, 113, 17);
		panel_2.add(lblTotal);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(131, 77, 200, 29);
		panel_2.add(textField_19);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double SingleRoom = 400;
				double DoubleRoom = 600;
				double FamilyRoom = 1000;
				double oneMeal = 90;
				double twoMeal = 170;
				double threeMeal = 170;
				/*****             Breakfast                       *****/
				try {
					if(comboBox_3.getSelectedItem().equals("Breakfast") && comboBox_4.getSelectedItem().equals("Single") ) {
						double q = (SingleRoom+oneMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Breakfast") && comboBox_4.getSelectedItem().equals("Double") ) {
						double q = (DoubleRoom+oneMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Breakfast") && comboBox_4.getSelectedItem().equals("Family") ) {
						double q = (FamilyRoom+oneMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					
					
					
					/*****             LUNCH                        ******/
					if(comboBox_3.getSelectedItem().equals("Lunch") && comboBox_4.getSelectedItem().equals("Family") ) {
						double q = (FamilyRoom+twoMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Lunch") && comboBox_4.getSelectedItem().equals("Double") ) {
						double q = (DoubleRoom+twoMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Lunch") && comboBox_4.getSelectedItem().equals("Single") ) {
						double q = (SingleRoom+twoMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					
					
					
					/*****             Dinner                        ******/
					if(comboBox_3.getSelectedItem().equals("Dinner") && comboBox_4.getSelectedItem().equals("Family") ) {
						double q = (FamilyRoom+threeMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Dinner") && comboBox_4.getSelectedItem().equals("Double") ) {
						double q = (DoubleRoom+threeMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
					if(comboBox_3.getSelectedItem().equals("Dinner") && comboBox_4.getSelectedItem().equals("Single") ) {
						double q = (SingleRoom+threeMeal);
						double i = (q*14)/100;
						String tax = String.format("₹ %.2f", i);
						textField_17.setText(tax);
						
						String subTotal = String.format("₹ %.2f", q);
						textField_18.setText(subTotal);
						
						String total = String.format("₹ %.2f", q+i);
						textField_19.setText(total);
						
						
						
					}
				}
				catch(Exception ev){
					
				}
				
			}
		});
		btnTotal.setBackground(Color.GRAY);
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTotal.setBounds(402, 37, 135, 40);
		panel_2.add(btnTotal);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO hoteldb(cusRef,firstName,SurName,sddress,PostCode,Mobile,Email,Gender,DOB,Nationality,ProveofID,DateIn,DateOut,RoomType,RoomNo,RoomExt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					
					pst.setString(8, (String) comboBox.getSelectedItem());
					pst.setString(10, (String) comboBox_2.getSelectedItem());
					pst.setString(11, (String) comboBox_3.getSelectedItem());
					pst.setString(14, (String) comboBox_4.getSelectedItem());
					pst.setString(15, (String) comboBox_5.getSelectedItem());
					pst.setString(16, (String) comboBox_6.getSelectedItem());
					
					pst.setString(9, dateChooser.getDateFormatString());
					pst.setString(12, dateChooser_1.getDateFormatString());
					pst.setString(13, dateChooser_2.getDateFormatString());
					
					pst.execute();
					rs.close();
					pst.close();
					
					
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev);System.out.println("Failed4");
				}
				
				if(table.getSelectedRow()==-1) {
					if(table.getSelectedRow()==0) {
						JOptionPane.showConfirmDialog(frame, "Hotel data Updated","Hotel System",JOptionPane.OK_OPTION);
					}
				}
				
				updateTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.setBounds(575, 37, 135, 40);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				
				if(table.getSelectedRow()==-1) {
					if(table.getSelectedRow()==0) {
						JOptionPane.showConfirmDialog(frame, "No data to be deleted","Hotel System",JOptionPane.OK_OPTION);
					}
					else {
						JOptionPane.showConfirmDialog(frame, "Select row to delete","Hotel System",JOptionPane.OK_OPTION);
					}
				}
				else {
					mod.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(Color.GRAY);
		btnDelete.setBounds(747, 37, 135, 40);
		panel_2.add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("no printer found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBackground(Color.GRAY);
		btnPrint.setBounds(1094, 37, 135, 40);
		panel_2.add(btnPrint);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					
					textField_17.setText(null);
					textField_18.setText(null);
					textField_19.setText(null);
					
					comboBox.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					comboBox_5.setSelectedIndex(0);
					comboBox_6.setSelectedIndex(0);
					
					dateChooser.setDate(null);
					dateChooser_1.setDate(null);
					dateChooser_2.setDate(null);
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev);
				}
			}
			
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(Color.GRAY);
		btnReset.setBounds(921, 37, 135, 40);
		panel_2.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Hotel System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(Color.GRAY);
		btnExit.setBounds(1272, 37, 135, 40);
		panel_2.add(btnExit);
	}
}