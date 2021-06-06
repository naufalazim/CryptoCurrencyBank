import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utility {
	
	
	
	public static ArrayList<Account> readFile(String fileName) {
		
		
		//=======Setup Array List:=======
		ArrayList<Account> accounts = new ArrayList<>();
		
		
		//===========File Reader & Exception Handling==============
		
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
				
				
				//Create Account 
				Account acc = new Account(accNumber, accHolder, date, baki);
				accounts.add(acc);
				
			}
			
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		return accounts;
		
		
	}

}
