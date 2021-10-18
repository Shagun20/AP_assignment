package Assign2_2020468;
import java.util.*;

public class Lecture_slides implements Lecture {
	Scanner sc=new Scanner(System.in);
	
	private String[] slide= new String[30];
	public void upload() {
		
		System.out.print("Enter topic of slides: ");
		this.slide[0]=sc.nextLine();
		System.out.print("Enter number of slides:");
		int n=Integer.parseInt(sc.next());
		System.out.println("Enter content of slides");
		for(int i=0;i<n;i++) {
			System.out.println("Content of slide"+i+1+":");
			this.slide[i+1]=sc.nextLine();
		}
		
	}
	
	public void view() {
		
	}
