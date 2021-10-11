
public class Slot {
private int day_no;
private int quantity;
private String vaccine;
private int vaccine_status;
//vaccine status is set to available by default 
public Slot(int day,int quantity, String v_name) {
	this.day_no=day;
	this.quantity=quantity;
	this.vaccine=v_name;
	this.vaccine_status=1;
	
}
//constructor based initialisation


//getter functons
public int getday() {
	return this.day_no;
	
}

public int getquantity() {
	return this.quantity;
	
}
public String getvaccine() {
	return this.vaccine;
	
}

//called when a slot is getting booked
public void book_slot() {
	this.quantity--;
}

//to check if a vaccine is available
public boolean check_slot_availability() {
	if(this.quantity>0){
		return true;
	}
	else 
	{
		this.vaccine_status =0;
		return false;
	}
}


}
