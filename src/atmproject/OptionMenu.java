package atmproject;



import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class OptionMenu  extends AccountInfo{
		Scanner menuInput =  new Scanner(System.in);
		DecimalFormat moneyFormat =  new  DecimalFormat("'Rs'###,##0.00");
		
		HashMap<Integer, Integer> data = new HashMap <Integer, Integer>();
		
		/*Validate login Information  , customer  number  & login number */
	
		public void getLogin() throws IOException{
			int x = 1;
			displayWelcome();
		
			do{
				try {
					
					data.put(1234567, 1234);
					data.put(9876543, 9876);
					data.put(4567890, 1234);
					
		
					System.out.println("Enter your Customer number: ");
					setCustmorNumber(menuInput.nextInt());
					
					System.out.println("Enter Your Pin Number: ");
					setPinNumber(menuInput.nextInt());
					} catch (Exception e) { 	
						System.out.println("\n "+"Invalid Characters(s).Only numbers."+"\n");
						x=2;
					}
				/*
				for (Map.Entry<Integer, Integer> entry : data.entrySet() ){
					if (entry.getKey()==getCustomerNumber() && entry.getValue() ==getPinNumber());
					{
					getAccountType();
				}}	*/
				int cn = getCustomerNumber();
				int pn = getPinNumber();
				if (data.containsKey(cn)&& data.get(cn)==pn) {
					getAccountType();
				}
				System.out.println("\n"+"Wrong  Customer Number or  Pin Number"+"\n");
				
				
			
		} while (x==1);
} 
	
		
		/*Display Account Type Menu with  Selection  */
		public void getAccountType() {
			System.out.println("--------------------------------------");
			System.out.println("Select the Account you want to Access:  ");
			System.out.println("\t\tType:1 Checking Account" );
			System.out.println("\t\tType:2 Saving Account");
			System.out.println("\t\tType:3 Exit");
			System.out.println("Enter your Choice: ");
				selection = menuInput.nextInt();
				
				switch(selection) {
				case 1: getChecking();
				break;
				case 2: getSaving();
				break;
				case 3: System.out.println("Thank You for Using This ATM Bye!");
				break;
				default:System.out.println("\n"+"Invalid Choice"+"\n");
				getAccountType();
				}
		}
		public static void displayWelcome()
	    {
	        System.out.println("====================================================");
	        System.out.println("\t\tWelcome to ABC Bank ATM! ");
	        System.out.println("====================================================");
	        System.out.println("\t\t Developed by Mr.Sagar Godambe ");
	        System.out.println("----------------------------------------------------");
	    }
		/*Display Checking Account Menu with selection */
		public void getChecking() {

			System.out.println("--------------------------------------");
			System.out.println("Checking Account ");
			System.out.println("Type 1-View Balance ");
			System.out.println("Type 2-Withdraw Funds ");
			System.out.println("Type 3-Deposite Fund  ");
			System.out.println("Type 4-Exit");
			
			selection =menuInput.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Checking Account Balance:"+moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
			case 2:
				getCheckingWithdrawInput();
				getAccountType();
				break;
			case 3:
				getCheckingDepositeInput();
				getAccountType();
			case  4:
				System.out.println("Thanks you for using this ATM, bye.!");
			break;
			default:
				System.out.println("\n"+"Invalid choice"+"/n");
				getChecking();
				}
		}
		/*Display Saving Account Menu with selection */
		public void getSaving() {

			System.out.println("--------------------------------------");
			System.out.println("Saving Account: ");
			System.out.println("Type 1-View Balance ");
			System.out.println("Type 2-Withdraw  Funds ");
			System.out.println("Type 3-Deposite Funds ");
			System.out.println("Type 4-Exit ");
			System.out.println("Choice ");
			
			selection = menuInput.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
			case 3:
				getSavingDepositeInput();
				getAccountType();
				break;
			case 4:
				System.out.println("Thank  You for Using ATM Bye! ");
				break;
			default:
				System.out.println("\n"+"Invalid Choice"+"/n");
				getSaving();
			}
	
	}
	
			
		int selection;
				
	}
	

