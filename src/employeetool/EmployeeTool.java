/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetool;

import employeetool.service.ExportService;
import employeetool.service.InsertService;


/**
 *
 * @author DiegoWindows
 */
public class EmployeeTool {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debes especificar una acción: insert [archivo.json] o export [nombreArchivoOpcional]");
            return;
        }

        String action = args[0];

        switch (action.toLowerCase()) {
            case "insert":
                if (args.length < 2) {
                    System.out.println("❌ Debes proporcionar la ruta del archivo JSON para insertar.");
                    return;
                }
                String jsonFile = args[1];
                InsertService insertService = new InsertService();
                insertService.insertEmployeesFromFile(jsonFile);
                break;

            case "export":
                ExportService exportService = new ExportService();
                String customFileName = args.length >= 2 ? args[1] : null;
                exportService.exportToCSV(customFileName);
                break;

            default:
                System.out.println("❌ Acción desconocida: " + action);
                System.out.println("Usa: insert [archivo.json] o export [nombreArchivoOpcional]");
                break;
        }
    }
}
