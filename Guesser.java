
public class Guesser {
    public static void play() {
	Game magic = new Game();

	while (magic.getTurn()<12) {
	    if (magic.turn(Prompt.getGuess("Input guess number "+(magic.getTurn()+1))))
		{
		    break;
		}

	    System.out.println("Wrong, try again...");
        System.out.println("Board \t Pegs \n");
	    for (int i=0; i<magic.getTurn(); i++){
            System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
            //Prompt.print(magic.getBoard());
	    	//Prompt.print(magic.getPegs());
	    }
	}

	if (magic.getTurn()==12) {
            System.out.println("You lose");
            //print the answer by getting the int[] from the game and then turning into a string
            System.out.println("The correct answer was " + Prompt.arrToStr(magic.getFinal()));
    }
	else
	    {System.out.println("Victory!");}
    }
}
