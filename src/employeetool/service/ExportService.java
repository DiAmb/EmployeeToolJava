/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetool.service;

/**
 *
 * @author DiegoWindows
 */

import employeetool.db.DatabaseManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.InputStream;

public class ExportService {
    private static final String query = "SELECT * FROM HumanResources.Employee";

    public void exportToCSV() {
        exportToCSV(null); 
    }

    public void exportToCSV(String customBaseName) {

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            String fileName = generateFileName(customBaseName);

            try (FileWriter writer = new FileWriter(fileName)) {
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();

              
                for (int i = 1; i <= columnCount; i++) {
                    writer.append(meta.getColumnName(i));
                    if (i < columnCount) writer.append(";");
                }
                writer.append("\n");

             
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        writer.append(rs.getString(i) != null ? rs.getString(i) : "");
                        if (i < columnCount) writer.append(";");
                    }
                    writer.append("\n");
                }

                System.out.println("✅ Exportación a CSV completada: " + fileName);
            }

        } catch (SQLException | IOException e) {
            System.err.println("❌ Error al exportar datos: " + e.getMessage());
        }
    }

    private String generateFileName(String customBaseName) throws IOException {
        Properties props = new Properties();
        try (InputStream input = ExportService.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Archivo config.properties no encontrado.");
            }
            props.load(input);
        }

        String baseName = (customBaseName != null && !customBaseName.isEmpty())
                ? customBaseName
                : props.getProperty("csv.name", "employee_export");

        String outputDir = props.getProperty("csv.outputDir", ".");
        String dateSuffix = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        return outputDir + "/" + baseName + "_" + dateSuffix + ".csv";
    }
}
