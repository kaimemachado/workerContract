package application;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String dpName = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(dpName));

        System.out.print("How many contracts to this worker? ");
        int numberContracts = sc.nextInt();

        for (int i = 1; i <= numberContracts ; i++) {
            System.out.println("Enter contract #" + i);
            System.out.println("Date (DD/MM/YYYY)");
            String dataInput = sc.next();
            LocalDate dataContrato = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Value per hour: ");
            double valuePHour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            int duration = sc.nextInt();

            worker.addContract(new HourContract(dataContrato, valuePHour, duration));
        }

        System.out.println("Enter month year to calculate income (MM/YYYY): ");
        String calculateDate = sc.next();
        String[] monthYear = calculateDate.split("/");
        Double totalValue = worker.income(Integer.valueOf(monthYear[0]), Integer.valueOf(monthYear[1]));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + calculateDate + ": " + totalValue);



    }
}