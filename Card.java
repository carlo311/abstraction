import java.util.Scanner;
class Card{
	String type;				// attributes nung card
	int damage, heal, number;


	final static int MONSTER = 700;		//fixed na yung value ng damage nung cards
	final static int MAGIC = 200;
	final static int TRAP = 300;

	Card(String type, int damage){		//constructor
		this.type = type;
		this.damage = damage;
		this.heal = damage;
		
	}
}