package lib;



public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(Employee employee) {
		int monthsWorked = employee.getNumberOfMonthWorking();
		int numberOfChildren = Math.min(employee.getNumberOfChildren(), 3);
		boolean isMarried = employee.isMarried();
	
		if (monthsWorked > 12) {
			System.err.println("More than 12 month working per year");
		}
	
		int yearlyIncome = calculateYearlyIncome(employee);
		int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		int taxableIncome = yearlyIncome - employee.getDeductible() - nonTaxableIncome;
	
		return calculateTaxAmount(taxableIncome);
	}
	
	private static int calculateYearlyIncome(Employee e) {
		return (e.getMonthlySalary() + e.getOtherMonthlyIncome()) * e.getNumberOfMonthWorking();
	}
	
	private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		int base = 54000000;
		if (isMarried) {
			base += 4500000;
		}
		base += numberOfChildren * 1500000;
		return base;
	}
	
	private static int calculateTaxAmount(int taxableIncome) {
		int tax = (int) Math.round(0.05 * taxableIncome);
		return Math.max(tax, 0);
	}

	
	
	
}
