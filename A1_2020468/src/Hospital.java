import java.util.ArrayList;

public class Hospital {
	private String name;
	private String id;
	private int pincode;
	private ArrayList<Slot> slots = new ArrayList<Slot>();
	//array of slot objects
	
	public Hospital(String n,String id,int pincode) {
		this.name=n;
		this.id=id;
		this.pincode=pincode;
	}
	
	public Hospital() {
		
	}
	
	public int getpin() {
		return this.pincode;
	}
	
	
	public String getid() {
		return this.id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public ArrayList<Slot> getslots(){
		return(this.slots);
	}
    //setter function to add slots
	
	public void slot_setter(int day,int quantity,String v_name) {
		
		Slot s =new Slot(day,quantity,v_name);
		this.slots.add(s);
		
		System.out.println(" Slot added by Hospital "+this.id+" for Day: "+ s.getday()+", Available Quantity: "+s.getquantity()+" of Vaccine "+s.getvaccine());
		
	}
	
	public  int print_1(int date) {
		int flag=0;
		for(int i=0;i<this.slots.size();i++) {
			
		   
			if(this.slots.get(i).check_slot_availability() && this.slots.get(i).getday()>=date)
				{System.out.println(i+ "-> Day: "+this.slots.get(i).getday()+"Available Qty:"+this.slots.get(i).getquantity()+" Vaccine:"+this.slots.get(i).getvaccine());
		         flag=1;
				}
			
				}
		if(flag==0)
			return 0;//no slots found 
		return 1;
	
		}
	
	
	public  void print_2() {
		for(int i=0;i<this.slots.size();i++) {
			if(this.slots.get(i).check_slot_availability())
				System.out.println("Day: "+this.slots.get(i).getday()+"Vaccine :"+this.slots.get(i).getvaccine()+"Available Qty:"+this.slots.get(i).getquantity());
		
	}
	}
	public  int print_3(int date, String name) {
		int flag=0;
		for(int i=0;i<this.slots.size();i++) {
			if(this.slots.get(i).check_slot_availability() && this.slots.get(i).getday()>=date && slots.get(i).getvaccine().equals(name)) 
				{System.out.println(i+ "-> Day: "+this.slots.get(i).getday()+"Available Qty:"+this.slots.get(i).getquantity()+" Vaccine:"+this.slots.get(i).getvaccine());
				flag=1;
				}
				
				
			
	}
		if(flag==0) {
			return 0;
		}
		return 1;
	}
	
	//public //void set_slots
	public void print() {
		System.out.println("Hospital Name: "+this.name +", PinCode: "+this.pincode+", Unique ID: "+ this.id);
	}
}
