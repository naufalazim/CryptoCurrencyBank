import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


/*
 * PROJECT JAVA BY MOHAMAD NAUFAL AZIM 2021
 * 
 * KUMPULAN 2: CRYPTO BANK UPNM
 * 
 * AHLI KUMPULAN:
 * 
 * 1) MOHAMAD NAUFAL AZIM BIN MOHD FAUZAY (2200957)
 * 2) SYED ALIFF 
 * 
 */


public class BankApp {

	private JFrame frame;
	private JTextField customerField;
	private JTextField dateField;
	private JTextField balanceField;
	private JComboBox accountDropDown;
	
	ArrayList<Account> accounts = Utility.readFile("accounts.txt");
	Account currentAccount;
	
	
	//============File Reader:========================
	private void initiateAccount() {
	
	for (Account a : accounts) {
		accountDropDown.addItem(a);
	}
	
	}

	
	
//=============Application Launch=============================
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BankApp window = new BankApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
	}


	
	//=============Create Application======================
	
	
	public BankApp() {
		initialize();
		initiateAccount();
	}

	
	
//========================JFrame Content=============================
	private void initialize() {
		
		frame = new JFrame("Crypto Bank Pokpal");
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 563, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//=================Label Area:====================
		JLabel Label = new JLabel("Account Number");
		Label.setHorizontalAlignment(SwingConstants.LEFT);
		Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		Label.setBounds(60, 120, 115, 20);
		frame.getContentPane().add(Label);
		
		JLabel Label2 = new JLabel("Hello!");
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Label2.setBounds(86, 75, 89, 34);
		frame.getContentPane().add(Label2);
		
		JLabel Label3 = new JLabel("Open Date");
		Label3.setHorizontalAlignment(SwingConstants.CENTER);
		Label3.setFont(new Font("Tahoma", Font.BOLD, 13));
		Label3.setBounds(361, 30, 74, 20);
		frame.getContentPane().add(Label3);
		
		JLabel Label4 = new JLabel("Your Balance");
		Label4.setHorizontalAlignment(SwingConstants.CENTER);
		Label4.setFont(new Font("Tahoma", Font.BOLD, 13));
		Label4.setBounds(73, 257, 104, 45);
		frame.getContentPane().add(Label4);
		
		JLabel titleBank = new JLabel("Crypto Bank UPNM");
		titleBank.setHorizontalAlignment(SwingConstants.CENTER);
		titleBank.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		titleBank.setBounds(158, 11, 193, 53);
		frame.getContentPane().add(titleBank);
		
		
		//============JTextField Area:=============
		
		
		customerField = new JTextField();
		customerField.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		customerField.setHorizontalAlignment(SwingConstants.LEFT);
		customerField.setEditable(false);
		customerField.setBounds(185, 75, 166, 32);
		frame.getContentPane().add(customerField);
		customerField.setColumns(10);
		
		
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(445, 31, 74, 20);
		frame.getContentPane().add(dateField);
		dateField.setColumns(10);
		
		
		
		balanceField = new JTextField();
		balanceField.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		balanceField.setEditable(false);
		balanceField.setBounds(183, 258, 178, 45);
		frame.getContentPane().add(balanceField);
		balanceField.setColumns(10);
		
		
		//=============JCOMBObox Area:===============
		accountDropDown = new JComboBox();
		accountDropDown.addActionListener(new ActionListener() {
			
			
		//Action Performed for 
			public void actionPerformed(ActionEvent e) {
				
			currentAccount = (Account) accountDropDown.getSelectedItem();  //Abstract Object. So kene target Account = (Account)
			customerField.setText(currentAccount.getAccountHolder()); //Take customerName om txt.
			dateField.setText(currentAccount.getoDate()); 
		    balanceField.setText(String.valueOf(currentAccount.Balance()));
				
			}
		});
		accountDropDown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accountDropDown.setBackground(new Color(255, 255, 204));
		accountDropDown.setBounds(185, 118, 166, 22);
		frame.getContentPane().add(accountDropDown);
		
		
		//==============JButton Area:===================
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String amountString = JOptionPane.showInputDialog(depositButton, "Enter amount deposit: ", "Deposit", JOptionPane.PLAIN_MESSAGE);
				double amount = Double.parseDouble(amountString);
				currentAccount.deposit(amount);
				balanceField.setText(String.valueOf(currentAccount.Balance()));
				
			}
		});
		depositButton.setForeground(new Color(0, 0, 0));
		depositButton.setBackground(new Color(255, 222, 173));
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		depositButton.setBounds(39, 179, 100, 45);
		frame.getContentPane().add(depositButton);
		
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountString = JOptionPane.showInputDialog(withdrawButton,"Enter amount to withdraw: ", "Withdraw", JOptionPane.PLAIN_MESSAGE);
				double amount = Double.parseDouble(amountString);
				currentAccount.withdraw(amount);
				balanceField.setText(String.valueOf(currentAccount.Balance()));
				
			}
		});
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		withdrawButton.setBackground(new Color(255, 228, 181));
		withdrawButton.setForeground(Color.BLACK);
		withdrawButton.setBounds(386, 179, 100, 45);
		frame.getContentPane().add(withdrawButton);
		
		JButton transferButton = new JButton("Transfer");
		transferButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
			
			
			
		});
		transferButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		transferButton.setBounds(215, 179, 100, 45);
		frame.getContentPane().add(transferButton);
		
		JButton exit = new JButton("Logout");
		exit.addActionListener(new ActionListener() {
			//Logout Button Action:
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBackground(new Color(255, 255, 240));
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		exit.setBounds(437, 293, 100, 45);
		frame.getContentPane().add(exit);
		

	}
}