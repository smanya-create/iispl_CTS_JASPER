package com.iispl.reporting;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperDailyProcessingReportRunner {
	public static void generateDailyChequeReport() {
		try {
			
			Connection connection = DBConnection.getConnection();
			
			String jrxml = "report/daily_cheque_processing_report.jrxml";
			
			String pdf = "output/daily_cheque_processing_report.pdf";
			
			JasperReport report = JasperCompileManager.compileReport(jrxml);
			
			Map<String , Object> parameters = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(report, parameters , connection);
			
			JasperExportManager.exportReportToPdfFile(print,pdf);
			
			connection.close();
			
			System.out.println("Daily Cheque Processing report generated sucessfully. ");
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
