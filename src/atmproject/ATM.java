package atmproject;

import java.io.IOException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ATM  extends OptionMenu{

	public static void main(String[] args) throws IOException{
		OptionMenu optionMenu =new OptionMenu();
		optionMenu.getLogin();
	}
	//-----------------------------------account info----------
	public class AccountInfo {
		private int customerNumber;
		private int pinNumber;
		private double checkingBalance=0;
		private double savingBalance=0;
		
		Scanner input = new Scanner(System.in);
		DecimalFormat moneyFormat =new DecimalFormat("'Rs'###,##0.00");
		
		/*Set  Customer number */
		public int setCustmorNumber( int customerNumber) {
			this.customerNumber = customerNumber;
			return customerNumber;
		}
		/*Get Customer number*/
		public int getCustomerNumber() {
			return customerNumber;
		}
		/*Set pin Number */
		public int setPinNumber(int pinNumber ) {
			this.pinNumber=pinNumber;
			return  pinNumber;
		}
		/*get the pin number */
		public int getPinNumber() {
			return pinNumber;
		}
		/*get checking account balance */
		public double getCheckingBalance() {
			return checkingBalance;
		}
		/*get saving account balance */
		public double getSavingBalance() {
			return savingBalance;
		}
		/*Calculating checking account withdrawal */
		public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance-amount);
			return checkingBalance;
		}	
	/*Calculate saving account withdrawal */
		public double calcSavingWithdraw(double amount) {
			savingBalance = (savingBalance - amount);
			return savingBalance;
		}
		/*Calculate checking account deposit */
		public double calcCheckingDeposite(double amount) {
			checkingBalance = (checkingBalance + amount);
			return checkingBalance;
		}
		/*calculate Saving account deposit */
		public double calcSavingDeposite(double amount) {
				savingBalance = (savingBalance + amount);
				return  savingBalance;
		}
		/*customer checking account withdraw input */
		public void getCheckingWithdrawInput() {
			System.out.println("Cecking Account Balance : "+ moneyFormat.format(checkingBalance));
			System.out.println("Amount you want  to withdraw from chekcing account : ");
			double amount = input.nextDouble();
			
			if ((checkingBalance-amount)>0) {
				calcCheckingWithdraw(amount);
				System.out.println("New Checking Account Balance : "+moneyFormat.format(checkingBalance));
				} else {
					System.out.println("Balance can not be negative"+"\n");
				}
		}
	 /*customer saving account withdraw input */
		public void getSavingWithdrawInput( ) {
			System.out.println("Saving Account Balance : "+ moneyFormat.format(savingBalance));
			System.out.println("Amount you want  to withdraw from saving account : ");
			double amount = input.nextDouble();
			
			if ((savingBalance-amount)>0) {
				calcSavingWithdraw(amount);
				System.out.println("New saving Account Balance : "+ savingBalance + "\n");
				} else {
					System.out.println("Balance can not be negative"+"\n");
				}
		}
		/*customer checking account  deposit input */
		public void getCheckingDepositeInput() {
			System.out.println("Cecking Account Balance : "+ moneyFormat.format(checkingBalance));
			System.out.println("Amount you want  to deposite from chekcing account : ");
			double amount = input.nextDouble();
			
			if ((checkingBalance+amount)>0) {
				calcCheckingDeposite(amount);
				System.out.println("New Checking Account Balance : "+moneyFormat.format(checkingBalance));
				} else {
					System.out.println("Balance can not be negative"+"\n");
				}
		}
		/*customer saving account deposit input */
		public void getSavingDepositeInput() {
			System.out.println("saving Account Balance : "+ moneyFormat.format(savingBalance));
			System.out.println("Amount you want  to withdraw from saving account : ");
			double amount = input.nextDouble();
			
			if ((savingBalance+amount)>0) {
				calcSavingDeposite(amount);
				System.out.println("New saving Account Balance : "+moneyFormat.format(savingBalance));
				} else {
					System.out.println("Balance can not be negative"+"\n");
				}
		}
//----------------------------option menu-------------		
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
					int	selection = menuInput.nextInt();
						
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
					
				int	selection =menuInput.nextInt();
					
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
					
					int selection = menuInput.nextInt();
					
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
			}
		}
}
