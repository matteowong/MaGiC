import java.util.ArrayList;
public class MasterMind {
    
    public static void main(String[] args) {
	Game magic=new Game();
	makeGuess guess = new makeGuess();
	while (magic.getTurn()<12) {
	    int[] retArr={1,1,2,2};
	    if (magic.getTurn()!=0){
		int[] board = magic.getBoard()[magic.getTurn()-1];
		int [] pegs = magic.getPegs()[magic.getTurn()-1];
		ArrayList<Integer> newguess = guess.guess(board, pegs);
		for (int i =0; i<4; i++)
		    retArr[i]= newguess.get(i);
	    }
	    if (magic.turn(retArr ))
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

