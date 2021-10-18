package Assign2_2020468;
import java.util.*;
public class Main {
    private static	Scanner sc=new Scanner(System.in);
    private static Instructor I0=new Instructor();
    private  static Instructor I1=new Instructor();
    private static Student S0=new Student();
    private static Student S1=new Student();
    private static Student S2=new Student();
    private static ArrayList<Lecture> lecture_material=new ArrayList<Lecture>();
    private static ArrayList<Lecture> lecture_material_videos=new ArrayList<Lecture>();
    private static int i=0;
   
    public static void main(String[] args) {
		int n;
		
		
		while(true) {
		System.out.println("Welcome to Backpack\r\n"+ "	1. Enter as instructor\r\n" + "	2. Enter as student\r\n"+ "	3. Exit");
		n=sc.nextInt();
		
		if(n==3) 
		{
			break;
		}
		
		if(n==1) 
		{
			call_instructor();
		}
		else if (n==2)
		{
			//call_student();
		}

					}
		
		
		}
	
	public static void call_instructor() {
		
		Instructor inst;
		System.out.println("Instructors:\r\n"+ "0 - I0\r\n"+ "1 - I1\r\n"+ "Choose id:");
		int id=sc.nextInt();
		if(id==0) {
			//use ID0,else ID1
			inst=I0;
		}
		else
			inst=I1;
		
		while(true) {
			System.out.print("Welcome I"+id);
			System.out.println("1. Add class material\r\n"
					+ "2. Add assessments\r\n"
					+ "3. View lecture materials\r\n"
					+ "4. View assessments\r\n"
					+ "5. Grade assessments\r\n"
					+ "6. Close assessment\r\n"
					+ "7. View comments\r\n"
					+ "8. Add comments\r\n"
					+ "9. Logout");
			
			int n= sc.nextInt();
			if(n==9)
				break;
			
			if(n==1) {
				System.out.println("1. Add Lecture Slide\r\n"+ "2. Add Lecture Video");
				Lecture l;
				int choice=sc.nextInt();
				if(choice==1) {
					
					 l=new Lecture_slides();
					//interface type object
					lecture_material.add(l);
					//call upload method of lecture slides through inst
					inst.upload(l);
					
					//add lecture slidess
					//create an arraylist of slides
				}
				if (choice==2){
					//add lecture videos in.mp4 format
					
					l=new Lecture_videos();
					//interface type object
					lecture_material_videos.add(l);
					
					inst.upload(l);
					//uploads the lecture video
					
				}
				
				
				
				
				
				//create an interface for slides and videos..called as lecture
			}
			
			
			if(n==2) {
				
			}
			if(n==3) {
				
			}
			if(n==4) {
				
			}
			if(n==5) {
				
			}
			if(n==6) {
				
			}
			
			if(n==7) {
				
			}
			if(n==8) {
				
			}
					
		
		
		}
		
		
		
		
		
		
		
	
											}
	

	
	
}
