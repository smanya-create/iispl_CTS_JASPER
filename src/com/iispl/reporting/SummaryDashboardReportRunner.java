package com.iispl.reporting;

import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class SummaryDashboardReportRunner {
	public static void generateDashboard() {
		try {

			Connection connection = DBConnection.getConnection();

			String jrxml = "report/summarydashboard.jrxml";

			String pdf = "output/summarydashboard.pdf";

			// Compile JRXML
			JasperReport report = JasperCompileManager.compileReport(jrxml);

			// Parameters
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("p_date", Date.valueOf("2026-08-13"));
					// Fill report
			JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);

			// Export PDF
			JasperExportManager.exportReportToPdfFile(print, pdf);

			connection.close();

			System.out.println("Summary Dashboard generated successfully!");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
