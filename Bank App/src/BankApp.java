import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


/*  ASSIGNMENT OBJECT ORIENTED PROGRAMMING 
 * 
 *  MOHAMAD NAUFAL AZIM BIN MOHD FAUZAY 2200957
 * 
 * 	SYED ALIFF HAKIMI  2191080 
 * 
 *  18/6/2021
 */



public class BankApp  {

	private JFrame frame;
	private JTextField customerField;
	private JTextField dateField;
	private JTextField balanceField;
	private JComboBox accountDropDown;
	private ImageIcon picture;
	
	
	
	
	
//=============== Array list on Utility ============================:  
	
	
	ArrayList<Account> accounts = Utility.readFile("accounts.txt");
	Account currentAccount;
	
	
//============ FILE READER SISTEM ========================
	
	
	private void initiateAccount() {
	
	for (Account a : accounts) {
		accountDropDown.addItem(a);
	}
	
	}
	
	
	
	
//============= APPLICATION SYSTEM ======================
	
	
	public BankApp() {
		initialize();
		initiateAccount();
	}

	
	
	
	
	
//======================== CONTENT GUI =============================
	
	
	private void initialize() {
		
		
		frame = new JFrame("Crypto Currency");
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 563, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//================= JLABEL AREA ====================
		
		
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
		
		JLabel Label4 = new JLabel("Balance (\u0243)");
		Label4.setHorizontalAlignment(SwingConstants.CENTER);
		Label4.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label4.setBounds(73, 257, 104, 45);
		frame.getContentPane().add(Label4);
		
		JLabel titleBank = new JLabel("Crypto Bank");
		titleBank.setHorizontalAlignment(SwingConstants.CENTER);
		titleBank.setFont(new Font("Serif", Font.BOLD, 30));
		titleBank.setBounds(158, 11, 193, 53);
		frame.getContentPane().add(titleBank);
		
		
		//================== JTEXTFIELD PART ===========================
		
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
		
		
		
		//================= JCOMBOBOX PART ========================
		
		accountDropDown = new JComboBox();
		accountDropDown.addActionListener(new ActionListener() {
			
			
		//=========================== Action Performed for JCOMBOBOX ==================================
			
			
			public void actionPerformed(ActionEvent e) {
				
			currentAccount = (Account) accountDropDown.getSelectedItem(); 
			customerField.setText(currentAccount.getAccountHolder()); 
			dateField.setText(currentAccount.getoDate()); 
		    balanceField.setText(String.valueOf(currentAccount.getBalance()));
				
			}
		});
			accountDropDown.setFont(new Font("Tahoma", Font.PLAIN, 13));
			accountDropDown.setBackground(new Color(255, 255, 204));
			accountDropDown.setBounds(185, 118, 166, 22);
			frame.getContentPane().add(accountDropDown);
		
		
		
		//==============DEPOSIT BUTTON:=====================
		
		
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			try {
				
			if(true) {
				String amountString = JOptionPane.showInputDialog(depositButton, "Enter amount deposit: ", "Deposit", JOptionPane.PLAIN_MESSAGE);
				double amount = Double.parseDouble(amountString);
				currentAccount.deposit(amount);
				balanceField.setText(String.valueOf(currentAccount.getBalance()));
				Utility.writeFile(accounts, "accounts.txt");
			  }
			}
			
			catch(Exception e1) {
				JOptionPane.showMessageDialog(depositButton, "Please put numbers only!","Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			}
		});
		
		
		
		//==========GUI DEPOSIT Button ===============
		depositButton.setForeground(new Color(0, 0, 0));
		depositButton.setBackground(new Color(255, 222, 173));
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		depositButton.setBounds(39, 179, 100, 45);
		frame.getContentPane().add(depositButton);
		
		
		
		
		//==============WITHDRAW Button==================
		
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
			if(true) {
				String amountString = JOptionPane.showInputDialog(withdrawButton,"Enter amount to withdraw: ", "Withdraw", JOptionPane.PLAIN_MESSAGE);
				double amount = Double.parseDouble(amountString);
				currentAccount.withdraw(amount);
				balanceField.setText(String.valueOf(currentAccount.getBalance()));
				Utility.writeFile(accounts, "accounts.txt");
				}
			
			} catch(Exception e1) {
				JOptionPane.showMessageDialog(withdrawButton, "Please put numbers only!","Error", JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		
		
		
		//=================WITHDRAW BUTTON GUI=====================
		
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		withdrawButton.setBackground(new Color(255, 228, 181));
		withdrawButton.setForeground(Color.BLACK);
		withdrawButton.setBounds(386, 179, 100, 45);
		frame.getContentPane().add(withdrawButton);
		
		
		
		
		
		
		// ===== Button TRANSFER====
		
		JButton transferButton = new JButton("Transfer");
		transferButton.addActionListener(new ActionListener() {
			
			
			
			//====================SISTEM TRANSFER MONEY==========================
			
			
			public void actionPerformed(ActionEvent e) {
				
			//==============Enter Account Number=====================:
				
				
				String accountNumber = JOptionPane.showInputDialog(transferButton,"Enter account number: ", "Transfer", JOptionPane.PLAIN_MESSAGE);
				Account transferAccount = null;
				
				for(Account a : accounts) {
					if(a.toString().equals(accountNumber)) {
						transferAccount = a;
						break;
					}
				}
				
				String amountString = JOptionPane.showInputDialog(transferButton,"Enter amount transfer: ",
						"Transfer", JOptionPane.PLAIN_MESSAGE);
				double amount = Double.parseDouble(amountString);
				if(transferAccount != null) {
					currentAccount.transfer(transferAccount, amount);
					balanceField.setText(String.valueOf(currentAccount.getBalance()));
					
				}
			
			}
			
		});
		
		
		//=================Transfer Button GUI====================
		
		transferButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		transferButton.setBounds(215, 179, 100, 45);
		frame.getContentPane().add(transferButton);
		
		JButton exit = new JButton("Logout");
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		
		
		exit.setBackground(Color.PINK);
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		exit.setBounds(437, 293, 100, 45);
		frame.getContentPane().add(exit);
		
		JLabel labelbaru = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Logo.jpg"));
		labelbaru.setIcon(img);
		labelbaru.setBounds(168, 11, 372, 253);
		frame.getContentPane().add(labelbaru);
		

	}
	
	
	
	//============Application Launch!===============
	
	public static void main(String[] args) {
		
		BankApp window = new BankApp();
		window.frame.setVisible(true);

		
	}
}


//Copyright by Naufal Azim 2021