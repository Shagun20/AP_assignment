import java.util.ArrayList;

public class Vaccine {
private String vaccine_name;
private  int no_of_doses;
private int gap;
private ArrayList<Hospital> hospital_list = new ArrayList<Hospital>();

public Vaccine(String name, int d,int g) {
	this.vaccine_name=name;
	this.no_of_doses=d;
	this.gap=g;
	
}

public void set_hospital_list(Hospital h) {
	this.hospital_list.add(h);
}

public void display_hospitals() {
	for(int i=0;i<this.hospital_list.size();i++)
	{   int flags=0;
		
		for(int j=0;j<(this.hospital_list.get(i).getslots()).size();j++) {
			if((this.hospital_list.get(i).getslots()).get(j).check_slot_availability()) {
				flags=1;
			}}
			
		    if(flags==1)
		    	System.out.println(this.hospital_list.get(i).getid() + " "+this.hospital_list.get(i).getname());
	
}
}
//Getter
public String getname() {
 return this.vaccine_name;
}
public int getdose() {
	 return this.no_of_doses;
	}
public int getgap() {
	 return this.gap;
	}




}
