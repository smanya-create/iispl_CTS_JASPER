package com.iispl.reporting;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JasperReportRunner.generateMICRReport();
		 
		
		Scanner scanner=new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Daily Cheque Processing Report");
			System.out.println("2: Rejected Cheque Report");
			System.out.println("3: MICR Repair Report");
			System.out.println("4: High Value Cheque Report");
			System.out.println("5: Batch Processing Summary");
			System.out.println("6: CTS Daily Operations Dashboard\n");
			System.out.println("Enter your choice::");
			choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
				break;
			case 2:
				JasperRejectedReportRunner.generateRejectedChequeReport();
				break;
			case 3:
				JasperReportRunner.generateMICRReport();
				break;
			case 4:
				break;
			case 5:
				BatchProcessingSummaryRunner.generateBatchProcessingSummary();
				break;
			case 6:
				 SummaryDashboardReportRunner.generateDashboard();
				 break;
			default:System.out.println("INVALID CHOICE");
			}
		}while(choice!=7);		 

	}

}
