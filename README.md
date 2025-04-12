
# EmployeeToolJava

Este proyecto es una herramienta en Java diseñada para gestionar información de empleados. La funcionalidad principal incluye la **inserción** de registros de empleados en una base de datos y la **exportación** de datos en formato CSV.

## Funcionalidades

### 1. Insertar empleados

La herramienta permite insertar registros de empleados en una base de datos SQL Server. Los datos se pueden cargar desde un archivo JSON, lo que permite una inserción masiva de registros. 

Cada registro de empleado incluye información como:
- **BusinessEntityID**
- **NationalIDNumber**
- **LoginID**
- **OrganizationNode**
- **OrganizationLevel**
- **JobTitle**
- **BirthDate**
- **MaritalStatus**
- **Gender**
- **HireDate**
- **SalariedFlag**
- **VacationHours**
- **SickLeaveHours**
- **CurrentFlag**
- **RowGuid**
- **ModifiedDate**

**Proceso:**
- El archivo JSON es cargado desde la ubicación especificada en el código.
- Los datos se insertan en la base de datos `AdventureWorks2022` en la tabla `HumanResources.Employee`.
- Si se encuentran errores de integridad, como claves primarias duplicadas o problemas con claves foráneas, el proceso de inserción es abortado y se muestran mensajes de error.

### 2. Exportar empleados a CSV

La herramienta también ofrece la funcionalidad para **exportar** los registros de empleados a un archivo CSV. El archivo exportado incluye todos los detalles de los empleados en formato de tabla.

**Proceso:**
- Los registros de empleados son recuperados de la base de datos.
- El nombre del archivo CSV incluye un sufijo con la fecha y hora actual para asegurar que cada exportación tenga un nombre único.

## Requisitos

- **Java 8** o superior.
- **Conexión a una base de datos SQL Server** (por defecto, se utiliza la base de datos `AdventureWorks2022`).

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/DiAmb/EmployeeToolJava.git
