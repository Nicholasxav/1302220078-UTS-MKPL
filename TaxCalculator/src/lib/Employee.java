package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;


import java.util.List;


public class Employee {
	private int monthlySalary;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private boolean isForeigner;
    private Gender gender;
    private List<child> children;

    // Constructor private, hanya dapat diakses melalui Builder
    private Employee(EmployeeBuilder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.idNumber = builder.idNumber;
        this.address = builder.address;
        this.yearJoined = builder.yearJoined;
        this.monthJoined = builder.monthJoined;
        this.dayJoined = builder.dayJoined;
        this.isForeigner = builder.isForeigner;
        this.gender = builder.gender;
        this.children = builder.children;
    }

    public List<child> getChildren() {
        return children;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    // Other methods can stay here, like for salary, tax calculation, etc.

    // Method lain di sini

	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	// Duplicate Code pada setMonthlySalary
	 public void setMonthlySalary(int grade) {
		int baseSalary = 0;
		switch (grade) {
			case 1: baseSalary = 3000000; break;
			case 2: baseSalary = 5000000; break;
			case 3: baseSalary = 7000000; break;
			default: baseSalary = 0; /
		}
		monthlySalary = isForeigner ? (int)(baseSalary * 1.5) : baseSalary;
	}
	
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
