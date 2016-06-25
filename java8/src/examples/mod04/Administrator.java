package examples.mod04;

public class Administrator extends Employee {
	private String responsibility = "Backoffice";

	public Administrator(String name) {
		super(name);
	}
	
	public String getInfo() {
		return super.getInfo()+", res:"+responsibility;
	}	
}
