package com.iispl.reporting;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperReportRunner {
	public static void generateMICRReport() {

		try {

			Connection connection = DBConnection.getConnection();

			String jrxml = "report/micr_report.jrxml";

			String pdf = "output/micr_report.pdf";

			// Compile JRXML
			JasperReport report = JasperCompileManager.compileReport(jrxml);

			// Parameters
			Map<String, Object> parameters = new HashMap<>();

			// Fill report
			JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);

			// Export PDF
			JasperExportManager.exportReportToPdfFile(print, pdf);

			connection.close();

			System.out.println("MICR report generated successfully!");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static void generateRejectedChequeReport() {
		try(Connection connection = DBConnection.getConnection()) {
			JasperReport jasperReport = JasperCompileManager.compileReport("report/rejected_cheque_report.jrxml");
			Map<String,Object> parameters = new HashMap<>();
			parameters.put("P_STATUS", "REJECTED");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "output/rejected_cheque_report.pdf");
			
			System.out.println("Rejected cheque report generated successfully");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
	}

}
