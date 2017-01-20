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
	    while (numTwos(userPegs)!=numTwos(correctPegs) ||
		   numOnes(userPegs)!=numOnes(correctPegs)) {
		userPegs=Prompt.getPegs("Stop cheating! Please input the pegs for the above guess");
	    }

	    //have the user guess, check it, either say "choice is an illuion, or prompt to guess again, then continue with loop
	    if (turnResult)
		{
		    System.out.println("Board \t Pegs \n");
		    for (int i=0; i<magic.getTurn(); i++){
			System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
			//Prompt.print(magic.getBoard());
			//Prompt.print(magic.getPegs());
		    }
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
            System.out.println("The correct answer was " + magic.getFinal()[0]+magic.getFinal()[1]+magic.getFinal()[2]+magic.getFinal()[3]);
	}
	else
	    {System.out.println("Victory!");} 
    }
}

