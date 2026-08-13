package com.iispl.reporting;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperRejectedReportRunner {
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
