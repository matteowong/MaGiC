//this class is used to play the game when the human User is the Guesser
public class Guesser {

    //method to play the game
    public static void play() {

	//instantiates a new game using the proper constructor
	Game magic = new Game(0);

	//this checks against the case that you get the correct guess on your twelth turn
	boolean won=false;
	
	//instructions
	System.out.println("Hello! You are playing as the guesser, with the computer as the mastermind. The computer has generated a code, and you must guess it. Guess inputs should be in format xxxx, with integers from 1-6, inclusive. You have 12 turns to succeed.");


	//the BE in the while loop checks if 12 turns have passed
	while (magic.getTurn()<12) {

	    //magic.turn() returns true if the guess is correct. Prompt.getGuess() gets a guess from the user. The message inside is just a prompt for the user. This line takes user input using Promptp.getGuess() and puts it into turn()
	    if (magic.turn(Prompt.getGuess("Input guess number "+(magic.getTurn()+1))))
		{
		    won=true;
		    break;
		}

	    System.out.println("Wrong, try again...");

	    //print statements for the Board and Pegs
	    System.out.println("Board \t Pegs \n");
	    //prints board and pegs next to eaechother
	    for (int i=0; i<magic.getTurn(); i++){
		System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
		//Prompt.print(magic.getBoard());
	    	//Prompt.print(magic.getPegs());
	    }
	}

	//if you break out of the While loop due to the boolean, the turn is 12 and you lose
	if (magic.getTurn()==12 && !won) {
            System.out.println("You lose");
            //print the answer by getting the int[] from the game and then turning into a string
            System.out.println("The correct answer was " + Prompt.arrToStr(magic.getFinal()));
	}
	//this means you broke out of the loop so you win
	else
	    {System.out.println("Victory!");}
    }
}
