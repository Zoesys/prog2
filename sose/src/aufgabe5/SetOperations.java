package aufgabe5;
import java.util.*;

public class SetOperations {

	Set<Integer> numbers1;
	Set<Integer> numbers2;
	Set<Integer> both;
	int upperLimit = 100;
	
	public SetOperations(){
		this.numbers1 = new TreeSet<>();
		this.numbers2 = new TreeSet<>();
		this.both = new TreeSet<>();
		
	}
	
	public void fill() {
		for(int i=0; i<upperLimit;i++) {
			Random r = new Random();
			this.numbers1.add(Integer.valueOf(r.nextInt(upperLimit)));
			this.numbers2.add(Integer.valueOf(r.nextInt(upperLimit)));
		}
	}
	
	public void fillBothUnion() {
		this.both.addAll(numbers1);
		this.both.addAll(numbers2);
	}
	
	public void fillBothIntersection() {
		this.both.clear();
		this.both.addAll(numbers1);
		this.both.retainAll(numbers2);
	}
	
	public void fillBothDifference() {
		this.both.addAll(numbers1);
		this.both.removeAll(numbers2);
	}
	
	private void printSpaces(int nrOfSpaces) {
		for(int spaces=0; spaces<nrOfSpaces; spaces++) {
			System.out.print(" ");
		}
	}
	
	public void print() {
		int numberCounter1 = 0;
		int numberCounter2 = 0;
		int numberCounterBoth = 0;
		for(int curRow=0;curRow<10;curRow++)
		{
			for(int curCol=0; curCol<10; curCol++)
			{
				if(this.numbers1.contains(Integer.valueOf(numberCounter1))) 
				{
					System.out.print(" " + '\u25cf');
				}
				else {
					System.out.print(" " + '\u2009');
				}
				numberCounter1++;
			}
			printSpaces(8);
			for(int curCol=0;curCol<10;curCol++) 
			{
				if(this.numbers2.contains(Integer.valueOf(numberCounter2))) 
				{
					System.out.print(" " + '\u25cf');
				}
				else {
					System.out.print(" " + '\u2009');
				}
				numberCounter2++;
			}
			printSpaces(8);
			for(int curCol=0; curCol<10; curCol++) 
			{
				if(this.both.contains(Integer.valueOf(numberCounterBoth))) 
				{
					System.out.print(" " + '\u25cf');
				}
				else {
					System.out.print(" " + '\u2009');
				}
				numberCounterBoth++;
			}
			System.out.println();
		}
	}
}
