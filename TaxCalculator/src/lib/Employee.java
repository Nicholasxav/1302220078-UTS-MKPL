package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate joinDate;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private Spouse spouse;
    private int monthlySalary;
    private boolean isForeigner;
    private Gender gender;
    private List<Child> children;
	

    // Constructor private, hanya dapat diakses melalui Builder
    private Employee(EmployeeBuilder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.idNumber = builder.idNumber;
        this.address = builder.address;
		this.joinDate = builder.JoinDate();
        this.isForeigner = builder.isForeigner;
        this.gender = builder.gender;
        this.children = builder.children;
        // Tambahkan inisialisasi field lainnya jika diperlukan
    }

    public List<Child> getChildren() {
        return children;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    // Method untuk menghitung gaji berdasarkan grade
    public void setMonthlySalary(int grade) {
        int baseSalary = 0;
        
        switch (grade) {
            case 1: baseSalary = 3000000; break;
            case 2: baseSalary = 5000000; break;
            case 3: baseSalary = 7000000; break;
            default: baseSalary = 0;
        }
        
        monthlySalary = isForeigner ? (int)(baseSalary * 1.5) : baseSalary;
    }
	
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String name, String idNumber) {
		this.spouse = new Spouse(name, idNumber);
	}
	
	
	
	public void addChild(String name, String idNumber) {
		children.add(new Child(name, idNumber));
	}
	
	
	public int getAnnualIncomeTax() {
		int monthsWorked = joinDate.getMonthsWorkedInCurrentYear();
		boolean hasNoSpouse = spouse == null || spouse.isEmpty();
		int numberOfChildren = children.size();
	
		return TaxFunction.calculateTax(
			monthlySalary,
			otherMonthlyIncome,
			monthsWorked,
			annualDeductible,
			hasNoSpouse,
			numberOfChildren
		);
	}
	
	
}
