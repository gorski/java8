package examples.mod02;

import java.util.Date;

public class TestVar {

	public void changeVal(int a) {
		a = 10;
	}

	public void changeVal(String msg) {
		msg = "pies";
	}

	public void changeVal(Date data) {
		data.setTime(0);
	}

	public static void main(String[] args) {
		int a = 5;
		String msg = "kot";
		Date data = new Date();

		// wartosci poczatkowe
		System.out.println("a="+a);
		System.out.println("msg="+msg);
		System.out.println("data.day="+data);

		// aby wywolac metode na rzecz obiektu nalezy go najpierw utworzyc
		TestVar test = new TestVar();
		test.changeVal(a);
		test.changeVal(msg);
		test.changeVal(data);

		// sprawdzenie wartosci
		System.out.println("a="+a);
		System.out.println("msg="+msg);
		System.out.println("data.day="+data);
	}
}
