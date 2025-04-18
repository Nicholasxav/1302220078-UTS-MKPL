package lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;


public class EmployeeBuilder {
    private int otherMonthlyIncome;
    private int annualDeductible;
    private JoinDate joinDate;

    // Fields yang digunakan untuk membuat Employee
    String employeeId;
    String firstName;
    String lastName;
    String idNumber;
    String address;
    int JoinDate;
    boolean isForeigner;
    Gender gender;
    List<Child> children = new LinkedList<>();

    public EmployeeBuilder setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setIdNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public EmployeeBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

  

    public EmployeeBuilder setForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
        return this;
    }

    public EmployeeBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
   

public EmployeeBuilder setOtherMonthlyIncome(int income) {
    this.otherMonthlyIncome = income;
    return this;
}

public EmployeeBuilder setAnnualDeductible(int deductible) {
    this.annualDeductible = deductible;
    return this;
}

public EmployeeBuilder setJoinDate(int year, int month, int day) {
    this.joinDate = new JoinDate(year, month, day);
    return this;
}
public Date getJoinDate() {
    return joinDate;
}
}
