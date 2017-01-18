
public class TwoPlayer {

    public static void play() {
	Game magic = new Game(1);
    

	while (magic.getTurn()<12) {
	    if (magic.turn(Prompt.getGuess("Input guess number"+(magic.getTurn()+1))))
		{
		    break;
		}


	    System.out.println("Wrong, try again...");
	    System.out.println("Board \t Pegs \n");
	    for (int i=0; i<magic.getTurn(); i++){
		String oneHalf = "";
		String otherHalf = "";
		for (int j=0; j<magic.getBoard()[i].length; j++){
		    oneHalf += magic.getBoard()[i][j]+"";
		    otherHalf += magic.getPegs()[i][j]+"";
		}
		System.out.println(oneHalf + "\t" + otherHalf +"\n");
	    }
	}

	if (magic.getTurn()==12)
	    System.out.println("You lose");
	else
	    System.out.println("Victory!");
	

    }
}
