
//Shagun Mohta
//2020468

import java.util.*;

public class Main {
    private static Instructor I0=new Instructor(0);
    private  static Instructor I1=new Instructor(1);
	private static	Scanner sc=new Scanner(System.in);
	private static Student S0=new Student(0);
    private static Student S1=new Student(1);
    private static Student S2=new Student(2);
    private static ArrayList<Lecture> lecture_material=new ArrayList<Lecture>();
    private static ArrayList<Lecture> lecture_material_videos=new ArrayList<Lecture>();
    private static ArrayList<Test> assignment=new ArrayList<Test>();
    private static ArrayList<Test> quiz=new ArrayList<Test>();
    private static ArrayList<String> comments=new ArrayList<String>(); 
    private static ArrayList<Test> assessments=new ArrayList<Test>();
    private static ArrayList<Test> submitted_assessments=new ArrayList<Test>();
    //array of strings for comments
    //private static int i=0;
   
    public static void main(String[] args) {
		int n;
		
		
		while(true) {
		System.out.println("Welcome to Backpack\r\n"+ "1. Enter as instructor\r\n" + "2. Enter as student\r\n"+ "3. Exit");
		n=sc.nextInt();
		 sc.nextLine();
		
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
			call_student();
		}

					}
		
		
		}
	
	public static void call_instructor() {
		
		Instructor inst;
		System.out.print("Instructors:\r\n"+ "0 - I0\r\n"+ "1 - I1\r\n"+ "Choose id:");
		int id=sc.nextInt();
		
		if(id==0) {
			//use ID0,else ID1
			inst=I0;
		}
		else
			inst=I1;
		
		while(true) {
			System.out.println("Welcome I"+id);
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
			 sc.nextLine();
			if(n==9)
				break;
			
			if(n==1) {
				System.out.println("1. Add Lecture Slide\r\n"+ "2. Add Lecture Video");
				Lecture l;
				int choice=sc.nextInt();
				 sc.nextLine();
				if(choice==1) {
					
					 l=new Lecture_slides(id);
					//interface type object
					lecture_material.add(l);
					//call upload method of lecture slides through inst
					inst.upload(l);
					
					//add lecture slidess
					//create an arraylist of slides
				}
				if (choice==2){
					//add lecture videos in.mp4 format
					
					l=new Lecture_videos(id);
					//interface type object
					lecture_material_videos.add(l);
					
					inst.upload(l);
					//uploads the lecture video
					
				}
			
				//create an interface for slides and videos..called as lecture
			}
			
			
			if(n==2) {
				Test t,t0,t1,t2;
				System.out.println("1. Add Assignment\r\n"+ "2. Add Quiz");
				int choice=sc.nextInt();
				 sc.nextLine();
				if(choice==1) {
					//assignment
					t=new Assignments(id);
					t0=new Assignments(id);
					t1=new Assignments(id);
					t2=new Assignments(id);
					//interface type object
					assignment.add(t);
					inst.upload(t);
					I0.view_assessments(t);
					I1.view_assessments(t);
					assessments.add(t);
					//adding to students' pending list
					S0.add(t,t0);
					S1.add(t,t1);
					S2.add(t,t2);
			 // add it to students pending assignments
				}
				
				if(choice==2) {
					
					t=new Quizzes(id);
					t0=new Quizzes(id);
					t1=new Quizzes(id);
					t2=new Quizzes(id);
					//interface type object
					quiz.add(t);
					inst.upload(t);
					assessments.add(t);
					I0.view_assessments(t);
					I1.view_assessments(t);
					//quizzes
					//adding to students' pending list
					S0.add(t,t0);
					S1.add(t,t1);
					S2.add(t,t2);
					
				}
				
				
			/*	1. Add Assignment
				2. Add Quiz*/
				
			}
			if(n==3) 
			{
				
			    Lecture l;
				//View lecture materials
				for(int j=0;j<lecture_material.size();j++) 
				{
		    		l=lecture_material.get(j);
				    l.view();
			    }
				for(int j=0;j<lecture_material_videos.size();j++) 
				{
		    		l=lecture_material_videos.get(j);
				    l.view();
			    }
				
				
				
			}
			
			if(n==4) {
				 
				 for(int j=0;j<assessments.size();j++) {
			        	System.out.print("ID :"+j+"\t");
			        	assessments.get(j).view();
			        //	inst.view_assessments(assessments.get(j));
			        	
			        }
				
				//View assessments
				
			}
			if(n==5) {
				System.out.println("List of assessments");
				for(int j=0;j<assessments.size();j++) {
		        	System.out.print("ID :"+j+"\t");
		        	assessments.get(j).view();
		        	//inst.view_assessments(assessments.get(j));
		        	
		        }
				
				System.out.print("Enter ID of assessment to view submissions:");
				int i=sc.nextInt();
				sc.nextLine();
			     
				//search for the name of the particular assin prof is looking for..
				String name=(assessments.get(i)).getprobemstat();
				System.out.println(name);
				System.out.println("Choose ID from these ungraded submissions");
				int in=-1;
				int in1=-1;
				int in2=-1;
				int in3=-1;
				for(int l=0;l<S0.get_submitted_assessments().size();l++) {
					if(S0.get_submitted_assessments().get(l).getprobemstat().equals(name) && S0.get_submitted_assessments().get(l).view_grade()==-1) 
					{
						in1=l;
						System.out.println("0. S0");
						break;
					}
				}
				for(int l=0;l<S1.get_submitted_assessments().size();l++) {
					if(S1.get_submitted_assessments().get(l).getprobemstat().equals(name)&& S0.get_submitted_assessments().get(l).view_grade()==-1) {
						in2=l;
						System.out.println("1. S1");
						break;
					}
				}
				for(int l=0;l<S2.get_submitted_assessments().size();l++) {
					if(S2.get_submitted_assessments().get(i).getprobemstat().equals(name)&& S0.get_submitted_assessments().get(l).view_grade()==-1) {
						in3=l;
						System.out.println("2. S2");
						break;
					}
				}
				int stud_id=sc.nextInt();
				
				sc.nextLine();
				Student stud=new Student();
				System.out.println("Submission:");
				if(stud_id==0) {
					stud=S0;
					if(in1!=-1) {
						in=in1;
					}
				}
				else if(stud_id==1) {
					stud=S1;
					if(in1!=-1) {
						in=in1;
					}
					
				}
				else if(stud_id==2) {
					stud=S2;
					if(in1!=-1) {
						in=in1;
					}
					
				}
				
				if(in!=-1) {
					System.out.println("Submission:"+stud.get_submitted_assessments().get(in).file()+"\n-------------------------------");
					System.out.println("Max Marks: "+stud.get_submitted_assessments().get(in).getmaxmarks());
					System.out.print("Marks scored:");
					int grades=sc.nextInt();
					sc.nextLine();
					stud.get_submitted_assessments().get(in).add_grade(grades,id);
				}
				
				
				//Grade assessments
			}
			
			if(n==6) {
				System.out.println("List of Open Assignments:");
				int j;
				for( j=0;j<inst.get_opened_assessments().size();j++) {
					
		        	System.out.print("ID :"+assessments.indexOf(inst.get_opened_assessments().get(j))+"\t");
		        	inst.get_opened_assessments().get(j).view();
				}
				
				if(inst.get_opened_assessments().size()!=0) {
					System.out.print("Enter id of assignment to close:");
					int i=sc.nextInt();
					//assessments.remove(i);
					sc.nextLine();
					Test m=assessments.get(i);
					S0.remove_assessment(m);
					S1.remove_assessment(m);
					S2.remove_assessment(m);
					j=I0.get_opened_assessments().indexOf(m);
					//j is index of the ass obj in opened_ass
					I0.close_assessment(j);
					j=I1.get_opened_assessments().indexOf(m);
					I1.close_assessment(j);
					//Close asssignment
				}
				else
					System.out.println("All assignments closed ! ");
				
			}
			
			if(n==7) {
				
				for(int i=0;i<comments.size();i++) 
					System.out.println(comments.get(i)+"\n");
				
			}
			if(n==8) {
				//enter a comment
				
				System.out.print("Enter comment:");
				String c=sc.nextLine();
				java.util.Date date_uploaded=new java.util.Date();
				c= c+"- I"+id+"\n"+date_uploaded;
				comments.add(c);
				
				//System.out.println(comments.get(0));
				
			}
					
		
		
					}//private java.util.Date date_uploaded;
		//date_uploaded=
		//while ends
		
		
		
		
		
		
		
	
											}//function ends
	
	public static void call_student() {
		Student stud=new Student();
		System.out.print("Students:\r\n"+ "0 - S0\r\n"+ "1 - S1\r\n"+ "2 - S2\r\n"+"Choose id:");
		int id=sc.nextInt();
		if(id==0) 
			stud=S0;
		if(id==1)
			stud=S1;
		if(id==2)
			stud=S2;
	    
		while(true) {
			System.out.println("Welcome S"+id);
			
			System.out.println("1. View lecture materials\r\n"
					+ "2. View assessments\r\n"
					+ "3. Submit assessment\r\n"
					+ "4. View grades\r\n"
					+ "5. View comments\r\n"
					+ "6. Add comments\r\n"
					+ "7. Logout");
		
			int choice=sc.nextInt();
			sc.nextLine();
		
		    if(choice==1) {
		    	//View lecture materials
		    	Lecture l;
		    	for(int j=0;j<lecture_material.size();j++) {
		    		l=lecture_material.get(j);
		    		stud.view(l);
		    		
		    	for(j=0;j<lecture_material_videos.size();j++) {
			    	l=lecture_material_videos.get(j);
			    	stud.view(l);
		    		}
		
		    		
		    	}
		  	
		    }
		    if(choice==2) {
		    	//view assignments
		    	Test t;
		    	int j;
		        for(j=0;j<assessments.size();j++) {
		        	System.out.print("ID :"+j+"\t");
		        	assessments.get(j).view();
		        }
		        
		    }
		    
		    
		    if(choice==3) {
		    	
		    	Test t;
		    	int j;
				stud.submit();
				//	System.out.println
		    			
		    		
		    		
		    	
		    	
				}
		    	//submit assignments
		    
		    if(choice==4) {
		    	stud.view_grade();
		    }
		    
		    if(choice==5) {
		    	
		    	for(int i=0;i<comments.size();i++) 
					System.out.println(comments.get(i)+"\n");
		    	//view comments
		    }
		    if(choice==6) {
		    	
		    	System.out.print("Enter comment:");
				String c=sc.nextLine();
				java.util.Date date_uploaded=new java.util.Date();
				c= c+"- S"+id+"\n"+date_uploaded;
				comments.add(c);
		    	//add comments
		    }
		    if(choice==7) 
		    	break;
		    
		    
		    
		
		}
		
		
		
	}
	
	
}//class ends

