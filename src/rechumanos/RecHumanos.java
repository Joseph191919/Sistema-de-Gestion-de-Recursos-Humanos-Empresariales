/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rechumanos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Main class for managing human resources in a company.
 */
public class RecHumanos  {
    /**
     * Inner class representing an employee.
     */
    public static class Employee {
        private String name; // Employee's name
        private int age; // Employee's age
        private String position; // Employee's position
        private double salary; // Employee's salary
        private List<Date> licenses; // List of employee's licenses
        private List<Date> vacationDates; // List of employee's vacation dates

        /**
         * Constructor for the Employee class.
         *
         * @param name     Employee's name.
         * @param age      Employee's age.
         * @param position Employee's position.
         * @param salary   Employee's salary.
         */
        public Employee(String name, int age, String position, double salary) {
            this.name = name;
            this.age = age;
            this.position = position;
            this.salary = salary;
            this.licenses = new ArrayList<>();
            this.vacationDates = new ArrayList<>();
        }
        /**
         * Add a license for the employee.
         *
         * @param date License date.
         */
        public void takeLicense(Date date) {
            licenses.add(date);
        }
        /**
         * Add vacation dates for the employee.
         *
         * @param date Vacation date.
         */
        public void takeVacation(Date date) {
            vacationDates.add(date);
        }
        // Getter methods to retrieve employee attributes
        /**
         * Get the employee's licenses.
         *
         * @return Employee's licenses.
         */
        public List<Date> getLicenses() {
            return licenses;
        }
        // Getter methods to retrieve employee attributes
        /**
         * Get the employee's vacation dates.
         *
         * @return Employee's vacation dates.
         */
        public List<Date> getVacationDates() {
            return vacationDates;
        }
        // Getter methods to retrieve employee attributes
        /**
         * Get the employee's name.
         *
         * @return Employee's name.
         */
        public String getName() {
            return name;
        }
        /**
         * Get the employee's age.
         *
         * @return Employee's age.
         */
        public int getAge() {
            return age;
        }
        /**
         * Get the employee's position.
         *
         * @return Employee's position.
         */
        public String getPosition() {
            return position;
        }
        /**
         * Get the employee's salary.
         *
         * @return Employee's salary.
         */
        public double getSalary() {
            return salary;
        }
        // Rest of the getters and setters
        // Rest of the class
    }
    /**
     * Inner class for managing human resources in the company.
     */
    public static class HrDepartment {
        private List<Employee> employees; // List of company's employees
        /**
         * Constructor for the HR Department class.
         */
        public HrDepartment() {
            this.employees = new ArrayList<>();
        }
        /**
         * Hire a new employee and add them to the list of employees.
         *
         * @param employee Employee to be hired.
         */
        public void hireEmployee(Employee employee) {
            employees.add(employee);
        }
        /**
         * Search for an employee by their name in the list of employees.
         *
         * @param name Employee's name to search for.
         * @return The found employee or null if not found.
         */
        public Employee findEmployeeByName(String name) {
            for (Employee employee : employees) {
                if (employee.getName().equalsIgnoreCase(name)) {
                    return employee;
                }
            }
            return null;
        }
        /**
         * Get the list of employees in the company.
         *
         * @return List of employees.
         */
        public List<Employee> getEmployees() {
            return employees;
        }
    }
    // Rest of the code
    /**
     * Main method for running the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        HrDepartment company = new HrDepartment();
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar un nuevo empleado");
            System.out.println("2. Ver el diario del empleado");
            System.out.println("3. Solicitar  licencia");
            System.out.println("4. Solicitar vacaciones");
            System.out.println("5. Renunciar");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Clear any characters entered by the user

            switch (option) {
                case 1:  // Code to add a new employee
    System.out.print("Ingrese el nombre del empleado: ");
    String name = scanner.nextLine();
    System.out.print("Ingrese la edad del empleado: ");
    int age = scanner.nextInt();
    scanner.nextLine();
    String[] positions = {"Gerente", "Analista", "Desarrollador", "Diseñador", 
        "Asistente"};
    int positionIndex = random.nextInt(positions.length);
    String position = positions[positionIndex];
    double salary = 0;
    switch (position) {
        case "Gerente":
            salary = 1500000;
            break;
        case "Analista":
            salary = 750000;
            break;
        case "Desarrollador":
            salary = 900000;
            break;
        case "Diseñador":
            salary = 700000;
            break;
        case "Asistente":
            salary = 750000;
            break;
    }
    Employee employee = new Employee(name, age, position, salary);
    company.hireEmployee(employee);
    System.out.println("Empleado registrado con éxito.");
    break;

case 2: // Code to view the employee's diary
    System.out.print("Ingrese el nombre del empleado a buscar: ");
    String nameToSearch = scanner.nextLine();
    Employee foundEmployee = company.findEmployeeByName(nameToSearch);
    if (foundEmployee != null) {
        System.out.println("Nombre: " + foundEmployee.getName());
        System.out.println("Edad: " + foundEmployee.getAge());
        System.out.println("Puesto: " + foundEmployee.getPosition());
        System.out.println("Salario: $ " + (int) foundEmployee.getSalary());
        System.out.println("Licencias: " + foundEmployee.getLicenses().size());
        System.out.println("Fechas de Vacaciones: " 
                + foundEmployee.getVacationDates().size());
    } else {
        System.out.println("Empleado no registrado.");
    }
    break;

case 3: // Code to request a license
    System.out.print("Ingrese el nombre del empleado que desea la licencia: ");
    String licenseName = scanner.nextLine();
    Employee employeeLicense = company.findEmployeeByName(licenseName);
    if (employeeLicense != null) {
        Date licenseDate = new Date(); // You can adjust the date as needed
        employeeLicense.takeLicense(licenseDate);
        System.out.println("Licencia tomada con éxito el " 
                + sdf.format(licenseDate));
    } else {
        System.out.println("Empleado no registrado. ");
    }
    break;

case 4: // Code to request vacation
    System.out.print("Ingrese el nombre del empleado para tomar vacaciones: ");
    String vacationName = scanner.nextLine();
    Employee employeeVacation = company.findEmployeeByName(vacationName);
    if (employeeVacation != null) {
        Date vacationDate = new Date(); // You can adjust the date as needed
        employeeVacation.takeVacation(vacationDate);
        System.out.println("Vacaciones tomadas con éxito del " 
                + sdf.format(vacationDate));
    } else {
        System.out.println("Empleado no registrado.");
    }
    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, "
                            + "seleccioneuna opción válida.");
                    break;
            }
        }
    }
}