import java.util.*;
public class Game {
	
    private static int player_positions[]= {0,0,0,1,0,0,1,1,0,0,0,0,0,0};
    //colored 1s added to some floors..
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
		Random rand = new Random();
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
			
			if(player_positions[pos]==1) {
				System.out.println("('-') Congrats ! You just landed on the bonus red floor !!");
				int r = rand.nextInt(3);
				System.out.println("Are you ready to earn some bonus points ? Answer this question to earn 5 more points!");
				if ( r == 1)
					{
					System.out.println("In which year did India get Independence ?");
					int year=Integer.parseInt(sc.nextLine());
					 if (year==1947)
						 {
						 System.out.print("Right answer ! You earned 5 bonus points $$ ");
						 p.set_score(p.get_score()+5);
						 System.out.println("Total points "+p.get_score()+"\n");
						 
						 }
					 else
						 System.out.println("Sorry, Wong ans ..Better luck next time..\n");
					}
				else if ( r == 2 )
				  
				{
					System.out.print("How many days make up a leap year ?");
					int year=Integer.parseInt(sc.nextLine());
					 if (year==366)
						 {
						 System.out.println("Right answer ! You earned 5 bonus points $$ ");
						 p.set_score(p.get_score()+5);
						 System.out.println("Total points "+p.get_score()+"\n");
						 
						 }
					 else
						 System.out.println("Sorry, Wong ans ..Better luck next time..\n");
				}
				else {
					System.out.print("In which year did Mahatma Gandhi die ?");
					 int year=Integer.parseInt(sc.nextLine());
					 if (year==1950)
						 {
						 System.out.println("Right answer ! You earned 5 bonus points $$ ");
						 p.set_score(p.get_score()+5);
						 System.out.println("Total points "+p.get_score()+"\n");
						 
						 }
					 else
						 System.out.println("Sorry, Wong ans ..Better luck next time..\n");
				}
				  
			}
			
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
		
		System.out.println("Michael Jackson accumulated"+p.get_score());
		System.out.println("Well Played (^=^)!!");
		
	}
}
