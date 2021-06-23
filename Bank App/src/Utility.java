import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Utility {
	
	
	//Extends for Account Page using ArrayList!
	public static ArrayList<Account> readFile(String fileName) {  
		
		
		//========== Setup Array List ==============
		
		//create new account object
		ArrayList<Account> accounts = new ArrayList<>(); 
		
		
		//=========== File Reader & Exception Handling ==============
		
		try {
			
			FileReader read = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(read);
			String line;
			
			
			while((line= buffer.readLine())  != null) {
				
				String[] currentAccount = line.split("<>");
				String accNumber = currentAccount[0];
				String accHolder = currentAccount[1];
				String date = currentAccount[2];
				double baki = Double.parseDouble(currentAccount[3]); // Read double --> String
				
				
		//============= Create Account ===================
				
				Account acc = new Account(accNumber, accHolder, date, baki);
				accounts.add(acc);
				
			}
			
			buffer.close();
			
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		return accounts;
		
		
	}
	
	public static void writeFile(ArrayList <Account> accounts, String fileName) {
		
			try {
				
				FileWriter fw = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(fw);
				for(Account a : accounts) {
				bw.write(a.toString()+ "<>" + a.getAccountHolder() + "<>" + a.getoDate() + "<>" + String.valueOf(a.getBalance()) + "\n" );
				}
				
				bw.close();
				
			}
			
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}


//Copyright by Naufal Azim 2021
