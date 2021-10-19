
import java.util.*;

public class Lecture_slides implements Lecture {
	Scanner sc=new Scanner(System.in);
	
	private String[] slide= new String[30];
	private java.util.Date date_uploaded;
	private int id;//id of prof who uploaded these slides
	private int n;//no of slides
	
	public Lecture_slides(int id) {
		this.id=id;
	}
	//setter fn
	public void upload() {
		
		this.date_uploaded=new java.util.Date();
		
		System.out.print("Enter topic of slides: ");
		this.slide[0]=sc.nextLine();
		//slide[0] is the title slide
		
		System.out.print("Enter number of slides:");
		this.n=Integer.parseInt(sc.nextLine());
		System.out.println("Enter content of slides");
		for(int i=1;i<=n;i++) {
			System.out.print("Content of slide"+i+":");
			this.slide[i]=sc.nextLine();
		}
		
	}
	
	//to String function
	public void view() {
		System.out.println("Title:"+this.slide[0]);
		
		for(int i=1;i<=n;i++) 
		{
			System.out.println("Slide"+i+": "+this.slide[i]);
		}
		System.out.println("Number of slides: "+this.n);
		System.out.println("Date of upload: "+this.date_uploaded);
		System.out.println("Uploaded by: I"+this.id+"\n");
   
	}
}
