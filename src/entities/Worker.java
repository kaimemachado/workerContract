package entities;
import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts;

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract (HourContract contract) {
        contracts.remove(contract);
    }

    public Double income (Integer month, Integer year ) {
        double sum = baseSalary;
        for(HourContract c: contracts) {
            if(c.getDate().getMonthValue() == month && c.getDate().getYear() == year) {
                sum+= c.totalValue();
            }
        }
        return sum;
    }
    //Construtor
    public Worker() {
        this.contracts = new ArrayList<>();
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        this.contracts = new ArrayList<>();
    }

    //Getter e Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


}
