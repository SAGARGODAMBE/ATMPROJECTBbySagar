package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

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
	
	}

