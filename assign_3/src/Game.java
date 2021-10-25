import java.util.*;
public class Game {
    private static int player_positions[]= {0,0,0,1,0,0,1,1,0,0,0,0,0,0};
    private static Dice die1 = new Dice(2);
    private static Player p;
    private static Snake_floor cobra = new Snake_floor(11,4,3,"Cobra");
    private static Snake_floor snake = new Snake_floor(5,2,1,"Snake");
    private static Ladder_floor elevator = new Ladder_floor(2,4,10,"Elevator");
    private static Ladder_floor ladder = new Ladder_floor(8,2,12,"Ladder");
    private static Floor empty = new Floor();
    private static Scanner sc=new Scanner(System.in);
    
	public static void main(String[] args) 
	{
		System.out.println("Enter the player name and hit enter   ");
		String name=sc.nextLine();
		
		//initialising player
		p=new Player(name);
	
		start_game();
		
		int pos=0;
		empty.print_location(pos);
		empty.print_message(p);
		empty.update_points(p);
		
		while(pos!=13) {
			
			System.out.println("---------------------------------");
			System.out.print("(^=^) : Hit enter to roll the dice -");
			String n= sc.nextLine();
			System.out.println("---------------------------------");
			die1.roll();
			int d=die1.getFaceValue();
			
			while(pos==12 && d==2) 
			{   System.out.println("----------------------------------");
				System.out.print("(^=^) : Hit enter to roll the dice -");
				
		         sc.nextLine();
		         System.out.println("----------------------------------");
				System.out.println("Player cannot move (>.<) ! ");
				die1.roll();
				d=die1.getFaceValue();
		
			}
			
			System.out.println("The dice gave |^_^| - "+d);
			
			pos+=d;
			
			if(pos==2) {
				//elevator
				elevator.print_location(pos);
				elevator.print_message(p);
				elevator.update_points(p);
				pos=elevator.move_to_floor();
				
			}
			else if(pos==5){
				//snake
				snake.print_location(pos);
				snake.print_message(p);
				snake.update_points(p);
				pos=snake.move_to_floor();
			}
			
			else if(pos==8) {
				ladder.print_location(pos);
				ladder.print_message(p);
				ladder.update_points(p);
				pos=ladder.move_to_floor();
				//ladder
			}
			else if(pos==11) {
				//cobra
				cobra.print_location(pos);
				cobra.print_message(p);
				cobra.update_points(p);
				pos=cobra.move_to_floor();
				
			}
			else {
				empty.print_location(pos);
				empty.print_message(p);
				empty.update_points(p);
			}
			
			
		}
		
		
		end_game();
		
	}
	public static void start_game() {
		
		System.out.println("Welcome!, the game setup is ready (^_^) ");
		System.out.println("----------------------------------");
		System.out.print("(^=^) : Hit enter to roll the dice -");
		
		String n= sc.nextLine();
		System.out.println("----------------------------------");
		die1.roll();
		int d=die1.getFaceValue();
		System.out.println("The dice gave |^_^| - "+d);
		while(d==2) {
			System.out.println("Game cannot start until you get 1..");
			System.out.println("------------------------------------");
		    System.out.println("(^=^) : Hit enter to roll the dice -");
			
		    sc.nextLine();
		    System.out.println("-------------------------------------");
		    die1.roll();
		    d=die1.getFaceValue();
		    if(d==1)
		    	System.out.println("The dice gave |^_^|- "+d);
		
		}
		
			
		
	}
	public static void end_game() {
		System.out.println("Game over (`_')");
		
		System.out.println(p.get_name()+" accumulated "+p.get_score());
		System.out.println("Well Played (^=^)!!");
		
	}
}
