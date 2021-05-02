package aufgabe2;

public class MyIntegerTest {

	public static void main(String[] args) {
		MyInteger m1 = null, m2 = null, m3 = null, m4 = null, m5 = null, m6 = null, m7 = null;
		
		try {
			m1 = new MyInteger("4657");
			System.out.println("m1 : " + m1.intValue());
			System.out.println(m1.toString());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m1 : " + e.getMessage());
		}
		try {
			m2 = new MyInteger("-4657");
			System.out.println("m2 : " + m2.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m2 : " + e.getMessage());
		}
		try {
			m3 = new MyInteger("hilfe");
			System.out.println("m3 : " + m3.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m3 : " + e.getMessage());
		}
		try {
			m4 = new MyInteger("");
			System.out.println("m4 : " + m4.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m4 : " + e.getMessage());
		}
		try {
			m5 = new MyInteger("-");
			System.out.println("m5 : " + m5.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m5 : " + e.getMessage());
		}
		try {
			m6 = new MyInteger("4657");
			System.out.println("m6 : " + m6.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m6 : " + e.getMessage());
		}
		try {
			m7 = new MyInteger("301");
			System.out.println("m7 : " + m6.intValue());
		}
		catch(IllegalArgumentException e) {
			System.out.println("m7 : " + e.getMessage());
		}
		

		//Wir probieren die ueberschriebene equals() Methode
		System.out.println("m1 gleich m2? : " + m1.equals(m2));
		System.out.println("m1 gleich m3? : " + m1.equals(m3));
		System.out.println("m1 gleich m4? : " + m1.equals(m4));
		System.out.println("m1 gleich m5? : " + m1.equals(m5));
		System.out.println("m1 gleich m6? : " + m1.equals(m6));

		//Jetzt die ueberschriebene hashCode() Methode
		System.out.println("hashCode von m6 : " + m6.hashCode());
		System.out.println("hashCode von m1 : " + m1.hashCode());
		System.out.println("hashCode von m2 : " + m2.hashCode());
		
		//Jetzt die intValue() und die doubleValue() Methode 
		System.out.println("intValue von m1 " + m1.intValue());
		System.out.println("intValue von m7 " + m7.intValue());
		
		System.out.println("doubleValue von m7 " + m7.doubleValue());
		System.out.println("doubleValue von m1 " + m1.doubleValue());
	}

}
