
public class Guesser {
    public static void main(String[] args) {
	Game magic = new Game();

	while (magic.getTurn()<12) {
	    if (magic.turn(Prompt.getGuess("Input your first guess")))
		{
		    break;
		}

	    System.out.println("Wrong, try again...");
	    Prompt.print(magic.getBoard());
	}

	if (magic.getTurn()==12)
	    {System.out.println("You lose");}
	else
	    {System.out.println("Victory!");}
    }
}
