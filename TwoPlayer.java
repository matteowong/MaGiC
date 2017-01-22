
public class TwoPlayer {

    //for a two player game
    public static void play() {

	//instructions
	System.out.println("Hello, this is a two player match. Decide who will be the mastermind. They will input a code in format xxxx, made of integers from 1-6, inclusive. Then the guesser will make guesses in the same format. We suggest you write down your code. If you forget it, type 'help' when prompted to input pegs.");


	//instantiates new game with int in constructor so it creates two Users 
	Game magic = new Game(2);

	//will be used to check if guess was correct, ensures that on the 12th guess you can still win
	boolean won=false;

	//checks for num turns being less than 12, the limit
	while (magic.getTurn()<12) {

	    //if guess was correct
	    boolean turnResult=magic.turn(Prompt.getGuess("Input Guess Number "+(magic.getTurn()+1)));

	    //asks user (the mastermind) to input their pegs
	    int[] userPegs = Prompt.getPegs("Please input the pegs for the above guess");

	    //the correct pegs
	    int[] correctPegs=magic.getPegs()[magic.getTurn()-1];


	    int z=0;

	    //checks for help
	    if (userPegs[0]==9999) {
		System.out.println("Your code: "+Prompt.arrToStr(magic.getFinal()));
		System.out.println("Last guess: "+Prompt.arrToStr(magic.getBoard()[magic.getTurn()-1]));
		userPegs=Prompt.getPegs("There's a referesher. Try again");
	    }
	    
	    //compares user pegs to actual pegs, lets them have two guesses
	    while ((MasterMind.numTwos(userPegs)!=MasterMind.numTwos(correctPegs) ||
		    MasterMind.numOnes(userPegs)!=MasterMind.numOnes(correctPegs))&&z<=1) {

		//checks for help
		if (userPegs[0]==9999) {
		    System.out.println("Your code: "+Prompt.arrToStr(magic.getFinal()));
		    System.out.println("Last guess: "+Prompt.arrToStr(magic.getBoard()[magic.getTurn()-1]));
		    userPegs=Prompt.getPegs("There's a referesher. Try again");
		    continue;
		}	
		z+=1;
		if (z<=1)
		    userPegs=Prompt.getPegs("Stop cheating! Please input the pegs for the above guess");
	    }
	    //breaks out if you win
	    if (turnResult)
		{
		    won=true;
		    break;
		}

	    //if user didn't input pegs right second time they are chastised
	    if (
		(MasterMind.numTwos(userPegs)!=MasterMind.numTwos(correctPegs) || MasterMind.numOnes(userPegs) != MasterMind.numOnes(correctPegs))) {
		System.out.println("You clearly cannot input pegs. The computer has done it for you\n");
		
	    }

	    //print statements
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

	if (magic.getTurn()==12 && !won)
	    System.out.println("Guesser loses! Congrats, mastermind!");
	else
	    System.out.println("Victory to the  Guesser! Mastermind, your code was no good.");


    }
}
