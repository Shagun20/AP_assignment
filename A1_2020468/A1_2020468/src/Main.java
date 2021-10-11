import java.util.*;
import java.lang.Math;
public class Main {
	//ArrayList<String> cars = new ArrayList<String>(); 
	static ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
	static ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
	static ArrayList<Citizen> citizens = new ArrayList<Citizen>();
	 static HashMap<String, Integer> hospital_ids = new HashMap<String, Integer>();
	 static HashMap<String, Integer> citizen_ids = new HashMap<String, Integer>();
	public static String code_generate(int i,int n)
	{
	    // array to store binary number
	   
	    String s="";
	    
	    while (i>=0 ||n > 0 ) {
	 
	     
	        
	        String l=	Integer.toString(n%2);
	        s=s+l;
	       
	        n = n / 2;
	        i--;
	        
	    }
	    
	    return s;
	}
	public static void main(String[] args) {
		int index=0;
		int vaccine_no=0;
		int citizen_no=0;
		while(true) {
		System.out.println("""
				
		CoWin Portal initialized....
		---------------------------------
		1. Add Vaccine
		2. Register Hospital
		3. Register Citizen
		4. Add Slot for Vaccination
		5. Book Slot for Vaccination
		6. List all slots for a hospital
		7. Check Vaccination Status
		8. Exit
		---------------------------------
		""");
		
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		if(n==8) {
			break;
		}
		
		if(n==1) {
			
			int dose_gap;
			System.out.print("Vaccine Name:");
			String vaccine_name= sc.next();
			System.out.print("Number of Doses:");
			int no_of_doses = sc.nextInt();
			if(no_of_doses==1)
				dose_gap=0;
			
			else{System.out.print("Gap between Doses:");
			dose_gap=sc.nextInt();}
			
			Vaccine v=new Vaccine(vaccine_name,no_of_doses,dose_gap);
	    	vaccines.add(v );
	    	System.out.println("Vaccine Name: "+v.getname()+ ", Number of Doses:"+ v.getdose()+", Gap Between Doses:" + v.getgap());
			//Vaccine_details()
	    	//v is stored in vaccines.get(vaccine_no);
	    	
			vaccine_no++;
		}
		
		if(n==2) {
			sc.nextLine();
			System.out.print("Hospital Name:");
			String hospital_name = sc.nextLine();
			System.out.print("Pincode: ");
			int pincode = Integer.parseInt(sc.next());
			
			String hospital_id= code_generate(5,index);
			
			 hospital_ids.put(hospital_id, index);
			 Hospital h=new Hospital(hospital_name,hospital_id,pincode);
			 hospitals.add(h);
			 //hospitals contain list of objects of class hospital
			 
			hospitals.get(hospital_ids.get(hospital_id)).print();
			//returns the index where a particular hospital id is stored
			//System.out.println("Hospital Name: "+hospital_name +", PinCode: "+pincode+", Unique ID: "+hospital_id);
			
			 
			 index++;
			//index is the location of hospital added in arraylist of objects of class hospital
		}
			
		if(n==3) {
			System.out.print("Citizen Name:");
			String citizen_name = sc.next();
			System.out.print("Age:");
			int age = sc.nextInt();
			System.out.print("Unique ID:");
			String citizen_id = sc.next();
			
		    if(age<=18)
		    	{
		    	System.out.println("Citizen Name: "+citizen_name+", Age: "+age+", Unique ID: "+citizen_id); 
		    	System.out.println("Only above 18 are allowed");
		    	}
		    
		    else {
		    	
		    	
		    	//citizen_ids  contain records of all  ids of citizens registered along with their citizen no
		    	int flag=0;
		    	for (String i : citizen_ids.keySet()) {
		    		//System.out.println(citizen_id.equals(i));
		    		if(citizen_id.equals(i)) {
		    			
		    			flag=1;
		    		}
		    	}
		    	if(flag==1) {
		    		System.out.println("Unique Id already registered");
		    		//if user id matches then cant register 
		    	}
		    	
		    	//create an object of citizen type
		    	
		    	
		    	else {	
		    	
		    	Citizen c=new Citizen(citizen_name,age,citizen_id);
		    	citizen_ids.put(citizen_id, citizen_no);
		    	c.set_vaccination_status("REGISTERED");
		    	System.out.println("Citizen Name: "+ c.getname() +", Age: "+c.getage()+", Unique ID: "+ c.getid()); 
		    	citizens.add(c);
		    	
		    	citizen_no++;
		    	
		    	}
		    }
		    
		}
			
		if(n==4) {
			
			System.out.print("Enter Hospital ID:");
			String hospital_id = sc.next();
			//int hospital;
			int flag=0;
			Hospital h;
			//go to the particular hospital's id
			for(String i: hospital_ids.keySet()) {
				if(i.equals(hospital_id)) {
				    
					flag=1;
					
				}
				
			}
			if(flag==0) {
				System.out.println("Hospital id not registered");
			}
			
			else {
			System.out.print("Enter number of Slots to be added:");
			int no_of_slots = sc.nextInt();
			//update this field for particular hospital
		    
			for(int i=0;i<no_of_slots;i++) {
				//update this field for each slot in hospital array
			
			System.out.print("Enter Day Number:");
			int day = sc.nextInt();
			
			System.out.print("Enter Quantity:");
			int quantity = sc.nextInt();
			
			//printing names of vacines
			System.out.println("Select Vaccine\r\n");
			for(int j=0;j<vaccines.size();j++) {
				System.out.println(j+"."+vaccines.get(j).getname());
			}
			
			int in=sc.nextInt();
			//the vaccine_name is extracted through this.
			String v_name= vaccines.get(in).getname();
			
			//System.out.println(v_name);
			//day,quantity,v_name are slot's parameters
			
			h=hospitals.get(hospital_ids.get(hospital_id));
			//object refernce to hospital
			//h.print();
			h.slot_setter(day,quantity,v_name);
			vaccines.get(in).set_hospital_list(h);
			//adding hospital to vaccine's array
			
			}
			
			
			}
			
			
			
			//System.out.println("Slot added by Hospital"+hospital_id+ "for Day: "+day+", Available Quantity: "+quantity+" of Vaccine "+vaccine_name);
				
		}
		
		
		if(n==5)
		{
			Hospital h=new Hospital();
			Citizen c=new Citizen();
			ArrayList<Hospital> search_hospitals = new ArrayList<Hospital>();
			int flag=0;
			int citizen_date=0;
			System.out.print("Enter Patient Unique ID:");
			String citizen_id=sc.next();
			System.out.print("1. Search by area\n" +"2. Search by Vaccine\n" +"	3. Exit\n"
					+ "	Enter option:");
			int choice=sc.nextInt();
			if(choice==1) {
				System.out.print("Enter PinCode:");
				int pin=sc.nextInt();
				//display hospital details
				
				for(int i=0;i<hospitals.size();i++) {
					if(hospitals.get(i).getpin()==pin) {
						search_hospitals.add(hospitals.get(i));
						flag=1;
						break;
					}
				}
				if(flag==0)
					System.out.println("No hospital found");
				else {
					for(int i=0;i<search_hospitals.size();i++) {
						System.out.println(search_hospitals.get(i).getid()+" "+search_hospitals.get(i).getname());
					}
						
						for(int j=0;j<citizens.size();j++) {
							
							if(citizens.get(j).getid().equals(citizen_id)) {
								System.out.print("1");
								c=citizens.get(j);
								//c is the citizen here
								citizen_date= (citizens.get(j).getdue_date());}
							
						}
						
						//assuming valid citizen credentials entered 
						int k=1;
						System.out.print("Enter hospital id:");
						String id=sc.next();
						for(int i=0;i<search_hospitals.size();i++) {
							if(search_hospitals.get(i).getid().equals(id)) {
								h=search_hospitals.get(i);
								if(search_hospitals.get(i).print_1(citizen_date)==0) {
									System.out.println("No slots available");
									k=0;
								}
								break;
							}
						}
						if(k==1) {
						System.out.print("Choose Slot: ");
						int slot_no=sc.nextInt();
					//	System.out.println(h.getslots().get(slot_no).getvaccine());
						int gap=0;
						int dose_req=0;
						for(int i=0;i<vaccines.size();i++) {
							if((vaccines.get(i).getname()).equals(h.getslots().get(slot_no).getvaccine())) {
								gap=vaccines.get(i).getgap();
								dose_req=vaccines.get(i).getdose();
							}
						}
						
						
						
						c.book_slot((h.getslots().get(slot_no)).getvaccine(), (h.getslots().get(slot_no)).getday(),gap, dose_req);
						//System.out.print(c.getname()+
						//slot no denotes the slot no chosen
						
					     h.getslots().get(slot_no).book_slot();
					//set hospital slot as booked for one person
					     
					     System.out.println(c.getname()+" vaccinated with"+ c.get_vaccine());
							//gap and ddose are set to a value 0 init.
					     
						}
					
				}
				
				
				
				
			}
			
			
			else if(choice==2) {
				
				
				System.out.print("Enter Vaccine name: ");
				String v_name=sc.next();
				for(int j=0;j<vaccines.size();j++) {
					if(vaccines.get(j).getname().equals(v_name)) {
						vaccines.get(j).display_hospitals();
						break;
					}
				}
				
				System.out.print("Enter hospital id: ");
				String hospital_id=sc.next();
				
				for(int j=0;j<citizens.size();j++) {
					
					if((citizens.get(j).getid()).equals(citizen_id)) {
						c=citizens.get(j);
						//c is the citizen here
						citizen_date= (citizens.get(j).getdue_date());}
					
				}
				
				
				
				
				h=hospitals.get(hospital_ids.get(hospital_id));
				if(h.print_3(citizen_date,v_name)==0) {
					System.out.println("No slots avilable");
					
				}
				//object refernce to hospital
				
				else {
				System.out.print("Choose Slot: ");
				
				int slot_no=sc.nextInt();
				System.out.print(slot_no);
				System.out.println((h.getslots()).get(slot_no).getvaccine());
				int gap=0;
				int dose_req=0;
				for(int i=0;i<vaccines.size();i++) {
					if((vaccines.get(i).getname()).equals(h.getslots().get(slot_no).getvaccine())) {
						gap=vaccines.get(i).getgap();
						dose_req=vaccines.get(i).getdose();
					}
				}
				
				
				
				//gap and ddose are set to a value 0 init.
				
				c.book_slot((h.getslots().get(slot_no)).getvaccine(), (h.getslots().get(slot_no)).getday(),gap, dose_req);
				//System.out.print(c.getname()+
				//slot no denotes the slot no chosen
				
			     h.getslots().get(slot_no).book_slot();
			     
			     System.out.println(c.getname()+" vaccinated with"+ c.get_vaccine());
				}
			//set hospital slot as booked for one person
			
		}
		
				
				
				
				
				
			}
			
		
		
		if(n==6) {
			System.out.print("Enter Hospital Id: ");
			String hospital_id = sc.next();
			Hospital h;
			int flag=0;
			for(String i: hospital_ids.keySet()) {
				if(i.equals(hospital_id)) {
				    
					flag=1;
					
				}
				
			}
			if(flag==0) {
				System.out.println("Hospital id not registered");
			}

			else {
			h=hospitals.get(hospital_ids.get(hospital_id));
			//object refernce to hospital
			//hospitals gets an index no to look for the hospital in hospitals arraylist
			h.print_2();
			}
			//vaccine status 
		}
		
		
		
		if(n==7) {
			System.out.println("Enter Patient ID:");
			String citizen_id = sc.next();
			Citizen c=new Citizen();
			
		/*	FULLY VACCINATED
			Vaccine Given: Covax
			Number of Doses given: 2
			
			
		*/

			for(int j=0;j<citizens.size();j++) {
				
				if((citizens.get(j).getid()).equals(citizen_id)) {
					c=citizens.get(j);
		}
		
			}
			
			c.querry_7();
			
		}
		}
	}
}
		
		
