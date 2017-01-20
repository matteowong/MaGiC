
public class TwoPlayer {


    public static void play() {
	System.out.println("Hello, this is a two player match. Decide who will be the mastermind. They will input a code in format xxxx, made of integers from 1-6, inclusive. Then the guesser will make guesses in the same format. We suggest you write down your code.");

	Game magic = new Game(1);


	while (magic.getTurn()<12) {

	    boolean turnResult=magic.turn(Prompt.getGuess("Input Guess Number "+(magic.getTurn()+1)));
	    int[] userPegs = Prompt.getPegs("Please input the pegs for the above guess");
	    int[] correctPegs=magic.getPegs()[magic.getTurn()-1];


	    int z=0;
	    while ((MasterMind.numTwos(userPegs)!=MasterMind.numTwos(correctPegs) ||
		    MasterMind.numOnes(userPegs)!=MasterMind.numOnes(correctPegs))&&z<=1) {
		z+=1;		
		userPegs=Prompt.getPegs("Stop cheating! Please input the pegs for the above guess");
	    }

	    if (turnResult)
		{
		    //boolean calls cause the code to run
		    break;
		}
	    if (z==2 &&
		(MasterMind.numTwos(userPegs)!=MasterMind.numTwos(correctPegs) || MasterMind.numOnes(userPegs) != MasterMind.numOnes(correctPegs))) {
		System.out.println("You clearly cannot input pegs. The computer has done it for you\n");
		
	    }


	    System.out.println("Guess was wrong, try again...");
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
	    System.out.println("You lose!");
	else
	    System.out.println("Victory!");


    }
}
