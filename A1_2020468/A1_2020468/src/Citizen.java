import java.util.ArrayList;

public class Citizen {
private String name;
private int age;
private String id;
private String vaccination_status;
private String vaccine_name;
private int no_of_doses_given=0;
private int due_date;
//private ArrayList<Vaccine> vaccine_taken = new ArrayList<Slot>();

public Citizen(String name,int  age,String id) {
	this.name=name;
	this.age=age;
	this.id=id;
	
	
}
public Citizen() {
	
}



//Getter function
public String getname() {
	 return name;
	}
	public int getage() {
		 return this.age;
		}
	public String getid() {
		 return this.id;
		}

	public String get_status() {
		return this.vaccination_status;
	}
	public String get_vaccine() {
		return this.vaccine_name;
	}
	public int getdue_date() {
		return this.due_date;
	}
//Setter func
public void set_vaccination_status(String s) {
	this.vaccination_status=s;
}

public void querry_7() {
	if(this.vaccination_status!=null)
		System.out.println(this.vaccination_status);
	if(this.vaccine_name!=null)
		System.out.println("Vaccine Given:"+this.vaccine_name);
	if(this.no_of_doses_given!=0)
		System.out.println("Number of Doses given:"+this.no_of_doses_given);
    if(this.vaccination_status.equals("PARTIALLY VACCINATED")) {
    	System.out.println("Next Dose due date::"+this.due_date);
    }
}
	
public void book_slot(String vaccine_name,int day_chosen,int gap, int dose_req) {
	this.no_of_doses_given+=1;
	this.vaccine_name=vaccine_name;
	this.due_date= day_chosen + gap;
	//gap and day-chosen are calculated in main function
	//dose req is also calc in main func
	if (this.no_of_doses_given>=dose_req)
		this.set_vaccination_status("FULLY VACCINATED");
	
	else
		this.set_vaccination_status("PARTIALLY VACCINATED");
	
	//update vaccination status
	
}

public void print() {
		System.out.println("Citizen Name: "+this.name+", Age: "+age+", Unique ID: "+ id); 
	}
	
}
