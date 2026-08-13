package com.iispl.reporting;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class BatchProcessingSummaryRunner {
	public static void generateBatchProcessingSummary() {
		try {

			Connection connection = DBConnection.getConnection();

			String jrxml = "report/batch_summary_report.jrxml";

			String pdf = "output/batch_summary_report.pdf";

			// Compile JRXML
			JasperReport report = JasperCompileManager.compileReport(jrxml);

			// Parameters
			Map<String, Object> parameters = new HashMap<>();

			// Fill report
			JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);

			// Export PDF
			JasperExportManager.exportReportToPdfFile(print, pdf);

			connection.close();

			System.out.println("Batch summary report generated successfully!");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
