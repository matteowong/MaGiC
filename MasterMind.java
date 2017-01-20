import java.util.ArrayList;
public class MasterMind {


    public static int numTwos(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==2) ret+=1;
	return ret;
    }

    public static int numOnes(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==1) ret+=1;
	return ret;
    }

    
    public static void play() {

	System.out.println("Hello, you are now the MasterMind. You will input a final code in the format xxxx, made of integers 1-6, inclusive. After each guess the computer makes, you will give it the corresponding pegs. We suggest you write down your code so you don't forget.");
	System.out.println("\nWhen inputting pegs, you only need to put the corresponding 1s and 2s. Remember: 1s mean the right color in the wrong place, and 2s mean the right color in the wrong place. You do not need to put 0s for completely wrong guesses, but if none of the digits in the guess are correct, you need to input one zero and hit enter.");


	Game magic=new Game("hi");
	makeGuess guess = new makeGuess();
	System.out.println("Board \t Pegs \n");
	while (magic.getTurn()<12) {
	    int[] retArr={1,1,2,2};
	    if (magic.getTurn()!=0){
		int[] board = magic.getBoard()[magic.getTurn()-1];
		int [] pegs = magic.getPegs()[magic.getTurn()-1];
		ArrayList<Integer> newguess = guess.guess(board, pegs);
		for (int i =0; i<4; i++)
		    retArr[i]= newguess.get(i);
	    }
	    for (int i: retArr){
		System.out.print(i);
	    }
	    System.out.println();

	    
	    int[] userPegs = Prompt.getPegs("Please input the pegs for the above guess");
	    boolean turnResult=magic.turn(retArr);
	    int[] correctPegs=magic.getPegs()[magic.getTurn()-1];
	    int z=0;
	    while ((numTwos(userPegs)!=numTwos(correctPegs) ||
		    numOnes(userPegs)!=numOnes(correctPegs))&&z<=1) {
		z+=1;
		userPegs=Prompt.getPegs("Stop cheating! Please input the pegs for the above guess");
	    }

	    //have the user guess, check it, either say "choice is an illuion, or prompt to guess again, then continue with loop
	    if (turnResult)
		{

		    //a repeat of print statements so if the computer gets it right it still prints
		    if (z==2) {
			System.out.println("You clearly cannot input pegs. The computer has done it for you\n");
		    }
		    System.out.println("Board \t Pegs \n");
		    for (int i=0; i<magic.getTurn(); i++){
			System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
			//Prompt.print(magic.getBoard());
			//Prompt.print(magic.getPegs());
		    }
		    break;
		}

	    //if they input the pegs incorrectly 3 times the computer takes over
	    if (z==2) {
		System.out.println("You clearly cannot input pegs. The computer has done it for you\n");
	    }

	    System.out.println("Computer will try again");
	    System.out.println("Board \t Pegs \n");
	    for (int i=0; i<magic.getTurn(); i++){
		System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
		//Prompt.print(magic.getBoard());
	    	//Prompt.print(magic.getPegs());
	    }
	}

	if (magic.getTurn()==12) {
            System.out.println("You Win!");
            System.out.println("The correct answer was " + magic.getFinal()[0]+magic.getFinal()[1]+magic.getFinal()[2]+magic.getFinal()[3]);
	}
	else
	    {System.out.println("You lose");} 
    }
}

