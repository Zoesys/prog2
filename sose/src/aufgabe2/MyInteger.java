package aufgabe2;

public class MyInteger {

	//Objektvariablen
	public static final int MAX_VALUE = 2147483647;
	public static final int MIN_VALUE = -2147483647;
	private int value;
	
	//Konstruktoren
	public MyInteger(int value) {
		this.value=value;
	}
	
	public MyInteger(String s) throws IllegalArgumentException{
		this.value = parseInt(s);
	}
	
	//Methode parseInt(String s) soll den übergebenden String s als Zahl zurückgeben
	public static int parseInt(String s) throws IllegalArgumentException {
		if(s.length()==0) throw new IllegalArgumentException("Keine Eingabe");
		boolean negativeZahl = false;
		if(s.charAt(0)=='+') {
			s = s.substring(1);
		}
		else if(s.charAt(0)=='-') {
			s = s.substring(1);
			negativeZahl = true;
		}
		if(s.length()==0) throw new IllegalArgumentException("Keine Eingabe");
			s = removeLeadingZeroes(s);
		
		if(!inputIsNumber(s)) throw new IllegalArgumentException("Eingabe ist keine Zahl"); 
			int exponent = 1;
			int zahl = 0;
			for(int i = s.length()-1;i>=0;i--) {
				zahl = zahl + charToInt(s.charAt(i))*exponent;
				exponent*=10;
			}
			if(negativeZahl) return -zahl;
			else return zahl;
		
	}
	
	//Methoden die fuer parseInt(String s) benoetigt werden
	static String removeLeadingZeroes(String s) {
		while(s.charAt(0)=='0') {
			s = s.substring(1);
		}
		return s;
	}
	
	private static int charToInt(char c) {
		int charAsciiValue = c;
		int intValue = charAsciiValue-48;
		return intValue;
	}
	
	private static boolean charIsDigit(char c) {
		return (c >= '0' && c <= '9');
	}
	
	private static boolean inputIsNumber(String s) {
		for(int i=0;i<s.length();i++) {
			if(!charIsDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	//Objektmethoden die den Wert value als int und double zurueckgeben
	public int intValue() {
		return this.value;
	}
	
	public double doubleValue() {
		return this.value;
	}
	
	//Methoden erzeugen ein Objekt von MyInteger und geben zurueck
	public static MyInteger valueOf(String s) throws IllegalArgumentException {
		return new MyInteger(s);
	}
	
	public static MyInteger valueOf(int value) {
		return new MyInteger(value);
	}
	
	//Ueberschriebende Methoden equals(), hashCode() und toString()
	@Override 
	public boolean equals(Object o) {
		if(o == null) return false;
		if(this == o) return true;
		if(this.getClass() != o.getClass()) return false;
		MyInteger oInt = (MyInteger)o;
		return (this.value == oInt.value);
	}
	
	@Override 
	public int hashCode()
	{
		return this.value;
	}
	
	@Override
	public String toString() {
		return "MyInteger value = " + value;
	}
	
	
}
