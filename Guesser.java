//this class is used to play the game when the human User is the Guesser
public class Guesser {

    //board printer
    private static void printBoard(boolean fancy, Game game) {
        //if its fancy, include the reference
        if (fancy) {
            Prompt.reference();
            System.out.println("Board \t\tPegs \n");
        }
        else {
            System.out.println("Board \t Pegs \n");
        }
        for (int i=0; i<game.getTurn(); i++){
            System.out.println(Prompt.arrToStr(game.getBoard()[i],"", fancy) + "\t" + Prompt.arrToStr(game.getPegs()[i]) +"\n");
        }
    }

    //method to play the game
    public static void play(int totalTurns, boolean isFancy) {

	//instantiates a new game using the proper constructor
	Game magic = new Game(0);

	//this checks against the case that you get the correct guess on your twelth turn
	boolean won=false;

	//instructions
	System.out.println("Hello! You are playing as the guesser, with the computer as the mastermind. The computer has generated a code, and you must guess it. Guess inputs should be in format xxxx, with integers from 1-6, inclusive. You have "+totalTurns+"  turns to succeed.");


	//the BE in the while loop checks if 12 turns have passed
	while (magic.getTurn()<totalTurns) {
        //if fancy mode is enabled, print the reference guide
	    if (isFancy&&magic.getTurn()==0) {
            Prompt.reference();
	    }
	    //magic.turn() returns true if the guess is correct. Prompt.getGuess() gets a guess from the user. The message inside is just a prompt for the user. This line takes user input using Promptp.getGuess() and puts it into turn()
	    if (magic.turn(Prompt.getGuess("Input guess number "+(magic.getTurn()+1))))
		{
		    won=true;
		    printBoard(isFancy, magic);
		    break;
		}

	    System.out.println("Wrong, try again...");

	    //print statements for the Board and Pegs
        printBoard(isFancy, magic);
	  }


	//if you break out of the While loop due to the boolean, the turn is 12 and you lose
	if (magic.getTurn()==totalTurns && !won) {
            System.out.println("You lose");
            //print the answer by getting the int[] from the game and then turning into a string
            System.out.println("The correct answer was " + Prompt.arrToStr(magic.getFinal(),"", isFancy));
	}
	//this means you broke out of the loop so you win
	else
	    {System.out.println("Victory!");}
    }
}
