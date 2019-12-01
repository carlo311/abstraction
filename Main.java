//This program is simple yu-gi-oh game where you draw a card up to three
//namely monster with damge 700, magic heal 200, trap damage 300
//then chooses a card to attack or heal with the corresponding points
//stating lifepoint  is 4000
//players are you and an opponent
//the game will end if the opponent's lifepoints becomes 0 or negative

//@author: Madi Carlo F.
//@date: 09-05-19 

import java.util.Arrays;
import java.util.Scanner;
class Main{
	public static void main(String[] args){
		String choice;
		Scanner pick = new Scanner(System.in);		//paggawa ng objects
		Duelist yugi = new Duelist("Yugi", Duelist.RED);
		Duelist rock = new Duelist("Rock", Duelist.BLUE);

		while(true){
			System.out.println("");
			System.out.println("[1]	-	Add a card to Duelist");
			System.out.println("[2]	-	View state of Duelist");
			System.out.println("[3]	-	Let's Duel!");
			System.out.println("[4]	-	View state of Opponent");
			System.out.println("[0]	-	Exit");
			System.out.println("");

			System.out.print("Enter your choice: ");
			choice = pick.next();


			if(choice.equals("1")){
				yugi.addCard();			// call ng function sa pag add ng card
			}else if(choice.equals("2")){
				yugi.charstate();			// call ng function sa pag view ng state player
			}else if(choice.equals("3")){
				yugi.duel(rock);				// call ng function sa pagduel
				if(Duelist.oppLifePoints <=0){
					System.out.println("You won!");
					break;
				}
			}else if(choice.equals("4")){
				rock.oppstate();			//call ng function sa pag view ng state ng opponent
			}else if(choice.equals("0")){

				System.out.println("Exiting the game...");
				System.out.println("Good bye!");
				break;

			}else{
				System.out.println("Invalid choice!!!");
			}

		}
	}


}