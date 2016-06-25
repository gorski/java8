package examples.mod06;

import java.util.*;

public class SystemVariables {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.list(System.out);
	}
}

