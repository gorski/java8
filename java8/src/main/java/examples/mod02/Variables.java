package examples.mod02;

public class Variables {
	private String var = "Zmienna globalna";

	public Variables (String var) {
		System.out.println(this.var);
		this.var = var;
	}
	
	public Variables() {
		System.out.println(var);
	}

	public void printVar() {
		System.out.println(var);
//		System.out.println(localVar); /* blad - zmienna niedostepna */
	}
	
	public void method() {
		String localVar = "Zmienna lokalna";
		System.out.println(localVar);

		{
			String blockVar = "Zmienna w bloku";
			localVar = blockVar;
			System.out.println(blockVar);
		}
		
		System.out.println(localVar);
		//System.out.println(blockVar); /* blad - zmienna niedostepna */
	}
	
	public static void main(String[] args) {
		Variables vars = new Variables("Nowy tekst");
		vars.method();
		vars.printVar();
	}
}
