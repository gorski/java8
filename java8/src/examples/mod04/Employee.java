package examples.mod04;

public class Employee {
	private String name;
	private int salary = 100;
	private String info;	

	public Employee(String name) {
		this.name = name;
		info = getInfo();
	}
	
	public String getInfo(){
		return name+", salary: "+salary;
	}

	public String getEmpInfo() {
		return info;
	}
}
