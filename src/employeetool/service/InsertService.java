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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import employeetool.db.DatabaseManager;
import employeetool.model.Employee;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;



public class InsertService {

    private static final String INSERT_SQL = "INSERT INTO HumanResources.Employee " +
        "(BusinessEntityID, NationalIDNumber, LoginID, JobTitle, BirthDate, MaritalStatus, Gender, HireDate, " +
        "SalariedFlag, VacationHours, SickLeaveHours, CurrentFlag, rowguid, ModifiedDate) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



    public void insertEmployeesFromFile(String jsonFilePath) {
    ObjectMapper mapper = new ObjectMapper();

    try {
        Properties props = new Properties();
        try (InputStream input = InsertService.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Archivo config.properties no encontrado.");
            }
            props.load(input);
        }

        String inputDir = props.getProperty("json.inputDir", ".");
        String fileName = (jsonFilePath != null && !jsonFilePath.isEmpty())
                ? jsonFilePath
                : props.getProperty("json.fileName", "employee.json");

        File file = new File(inputDir, fileName);

        List<Employee> employees = mapper.readValue(file, new TypeReference<List<Employee>>() {});
        insertEmployees(employees);

    } catch (IOException e) {
        System.err.println("❌ Error al leer el archivo JSON: " + e.getMessage());
    }
}


    private void insertEmployees(List<Employee> employees) {

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            for (Employee emp : employees) {
                stmt.setInt(1, emp.getBusinessEntityID());
                stmt.setString(2, emp.getNationalIDNumber());
                stmt.setString(3, emp.getLoginID());
                stmt.setString(4, emp.getJobTitle());
                stmt.setDate(5, new java.sql.Date(emp.getBirthDate().getTime()));
                stmt.setString(6, String.valueOf(emp.getMaritalStatus()));
                stmt.setString(7, String.valueOf(emp.getGender()));
                stmt.setDate(8, new java.sql.Date(emp.getHireDate().getTime()));
                stmt.setBoolean(9, emp.isSalariedFlag());
                stmt.setShort(10, emp.getVacationHours());
                stmt.setShort(11, emp.getSickLeaveHours());
                stmt.setBoolean(12, emp.isCurrentFlag());
                stmt.setObject(13, emp.getRowGuid());
                stmt.setDate(14, new java.sql.Date(emp.getModifiedDate().getTime()));
                stmt.addBatch();
            }

            stmt.executeBatch();
            System.out.println("✅ Inserción completada con éxito.");

        } catch (SQLException | IOException e) {
            System.err.println("❌ Error durante la inserción: " + e.getMessage());
            e.printStackTrace();
        }
    }
}