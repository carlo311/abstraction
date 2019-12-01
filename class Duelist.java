import java.util.Scanner;
class Duelist{

	String name, group;
	static int charLifePoints = 4000;		//attributes ng duelist
	static int oppLifePoints = 4000;		// universal yung lifepoints sa class

	Card[] cardList;
	int numOfCards;


	final static String RED = "Osiris Red";//fixed na yung value ng group
	final static String YELLOW = "Ra yellow";
	final static String BLUE = "Oberisk Blue";

	void addCard(){						// method ng pag add ng card
		if(this.numOfCards <3){			// habang di pa tatlo yung nasa list ng cards mag aadd pa 
			while(true){
				String cardChoice;
				Scanner pick = new Scanner(System.in);
				System.out.println("");
				System.out.println("[1]	-	Monster");		// menu ng card choice
				System.out.println("[2]	-	Magic");
				System.out.println("[3]	-	Trap");
				System.out.println("");

				System.out.print("Enter your choice: ");
				cardChoice = pick.next();

				if(cardChoice.equals("1")){
					Card monster = new Card("Monster", Card.MONSTER);	//paggawa ng object na monster na card
					this.cardList[this.numOfCards] = monster;
					this.numOfCards ++;
					break;
				}else if(cardChoice.equals("2")){
					Card magic = new Card("Magic", Card.MAGIC);		//paggawa ng object na magic na card
					this.cardList[this.numOfCards] = magic;
					this.numOfCards ++;
					break;
				}else if(cardChoice.equals("3")){
					Card trap = new Card("Trap", Card.TRAP);		//paggawa ng object na trap card
					this.cardList[this.numOfCards] = trap;		//inaadd sa list ng cards yung ginawang object na card
					this.numOfCards ++;
					break;
				}else{
					System.out.println("Invalid choice!!!");
				}
			}
		}else{
		System.out.print("Maximum number of card reached");	
		}

	}

	void duel(Duelist opponent){
		int iterator1,counter =0;
		String attackChoice;
		Scanner pick = new Scanner(System.in);
		if(Duelist.oppLifePoints > 0){		// habang di pa zero yung buhay ng opponent or negative papasok 
			if(this.numOfCards != 0){		// habang hindi zero yung yung number ng cards 
				while(true){
					System.out.println("[Your cards]");
					for(iterator1=0;iterator1<numOfCards;iterator1++){		//priprint yung bawat card sa cardlist
						System.out.println("-"+this.cardList[iterator1].type);
					}
					System.out.println("");
					System.out.println("[Option for an attack]");
					System.out.println("[1]	-	Monster");
					System.out.println("[2]	-	Magic");		// option for attack
					System.out.println("[3]	-	Trap");

					System.out.println("");
					System.out.print("Enter your choice: ");
					attackChoice = pick.next();
					if(attackChoice.equals("1")){
						for(iterator1=0;iterator1<numOfCards;iterator1++){
							if(this.cardList[iterator1].type == "Monster"){		//hahanap ng monster sa list ng cards
								System.out.println("you used a monster card");	//kapag meron magkakaroong ng damage si opponent
								Duelist.oppLifePoints -= Card.MONSTER;
								counter += 1;
							}
						}
						if(counter > 0){
							break;
						}else{
							System.out.println("you have no monster card");
						}
					}else if(attackChoice.equals("2")){
						for(iterator1=0;iterator1<numOfCards;iterator1++){		//hahanap ng magic sa list ng cards
							if(this.cardList[iterator1].type == "Magic"){		// kapag meron magheheal ng 200 si player
								System.out.println("you used a magic card");
								Duelist.charLifePoints += Card.MAGIC;
								counter += 1;
							}
						}
						if(counter > 0){
							break;
						}else{
							System.out.println("you have no magic card");
						}
					}else if(attackChoice.equals("3")){
						for(iterator1=0;iterator1<numOfCards;iterator1++){		//hahanap ng trap card sa list ng cards
							if(this.cardList[iterator1].type == "Trap"){		// if meron magkakaroon ng damage si  opponent ng 300
								System.out.println("you used a trap card");
								Duelist.oppLifePoints -= Card.TRAP;
								counter += 1;
							}
						}
						if(counter > 0){
							break;
						}else{
							System.out.println("you have no trap card");
						}
					}else{
						System.out.println("Invalid choice!!!");
					}
				}

			}else{
				System.out.println("You have no cards!");
			}
		}else{

		}
	}

	void heal(){
		Duelist.charLifePoints += 200;
	}

	void charstate(){
		System.out.println("Life points: " + Duelist.charLifePoints);		//print lang yung remaining life ni player
	}
	void oppstate(){
		System.out.println("Life points: " + Duelist.oppLifePoints);		//print lang yung remaining life ni opponent
	}

	Duelist(String name, String group){			//constructors
		this.name = name;
		this.group = group;

		this.cardList = new Card[3];
		this.numOfCards = 0;
	}

}