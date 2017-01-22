import java.util.ArrayList;
public class MasterMind {

    //returns number of Twos in an array
    //pre-con: takes an int array
    //post-con: returns number of 2s
    public static int numTwos(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==2) ret+=1;
	return ret;
    }

    //same as numTwos but checks for 1s
    public static int numOnes(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==1) ret+=1;
	return ret;
    }

    
    public static void play(int totalTurns) {

	//instructions
	System.out.println("Hello, you are now the MasterMind. You will input a final code in the format xxxx, made of integers 1-6, inclusive. After each guess the computer makes, you will give it the corresponding pegs. We suggest you write down your code so you don't forget.");
	System.out.println("\nWhen inputting pegs, you only need to put the corresponding 1s and 2s. Remember: 1s mean the right color was guessed, but in the wrong place, and 2s mean the right color was guessed in the wrong place. You do not need to put 0s for completely wrong guesses, but if none of the digits in the guess are correct, you need to input one zero and hit enter.");
	System.out.println("\nIf you forget your code, type 'help' when prompted for pegs");

	//new Game
	Game magic=new Game(1);

	//new makeGuess, which is the class that generates computer guesses
	makeGuess guess = new makeGuess();

	boolean turnResult=false;

	//print statement for board and pegs
	System.out.println("Board \t Pegs \n");

	//checks that less than 12 turns have passed
	while (magic.getTurn()<totalTurns) {

	    //retArr is the first guess. if it is turn 0 the computer guesses this, always
	    int[] retArr={1,1,2,2};

	    //if turn is not zero, computer runs its algorithm
	    if (magic.getTurn()!=0){
		int[] board = magic.getBoard()[magic.getTurn()-1];
		int [] pegs = magic.getPegs()[magic.getTurn()-1];
		//guess.guess() returns an ArrayList of its next guess, then it is converted into an int array
		ArrayList<Integer> newguess = guess.guess(board, pegs);
		for (int i =0; i<4; i++)
		    retArr[i]= newguess.get(i);
	    }
	    //prints out the guess
	    for (int i: retArr){
		System.out.print(i);
	    }
	    System.out.println();

	    //asks the user to input their pegs 
	    int[] userPegs = Prompt.getPegs("Please input the pegs for the above guess");

	    //makes a turn happen and sets the result of the turn( was the guess correct or not)
	    turnResult=magic.turn(retArr);

	    //correctPegs is what the pegs should be
	    int[] correctPegs=magic.getPegs()[magic.getTurn()-1];

	    //counter. we don't want the user inputting pegs wrong a million times so they get 2 guesses
	    int z=0;


	    //checks for help
	    if (userPegs[0]==9999) {
		System.out.println("Your code: "+Prompt.arrToStr(magic.getFinal()));
		System.out.println("Last guess: "+Prompt.arrToStr(magic.getBoard()[magic.getTurn()-1]));
		userPegs=Prompt.getPegs("There's a referesher. Remember, 1s  correspond to the right number in the wrong place, and 2s are the right number in the right place. Try again");
	    }

	    
	    //checks if the pegs are right
	    while ((numTwos(userPegs)!=numTwos(correctPegs) ||
		    numOnes(userPegs)!=numOnes(correctPegs))&&z<=1) {

		//checks for help again
		if (userPegs[0]==9999) {
		    System.out.println("Your code: "+Prompt.arrToStr(magic.getFinal()));
		    System.out.println("Last guess: "+Prompt.arrToStr(magic.getBoard()[magic.getTurn()-1]));
		    userPegs=Prompt.getPegs("There's a referesher. Remember, 1s  correspond to the right number in the wrong place, and 2s are the right number in the right place. Try again");
		    continue;
		}

								  
		z+=1;
		if (z<=1)
		    userPegs=Prompt.getPegs("Stop cheating! Please input the pegs for the above guess");
	    }

	    if (turnResult)//if turn was correct
		{

		    //a repeat of print statements so if the computer gets it right it still prints
		    //this is if the user didn't input the right pegs
		    if (
			(numTwos(userPegs)!=numTwos(correctPegs) || numOnes(userPegs) != numOnes(correctPegs))) {
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

	    //if they input the pegs incorrectly 2 times the computer takes over
	    if ((numTwos(userPegs)!=numTwos(correctPegs) || numOnes(userPegs) != numOnes(correctPegs))) {
		System.out.println("You clearly cannot input pegs. The computer has done it for you\n");
	    }

	    System.out.println("Computer will try again");
	    System.out.println("Board \t Pegs \n");
	    for (int i=0; i<magic.getTurn(); i++){
		System.out.println(Prompt.arrToStr(magic.getBoard()[i]) + "\t" + Prompt.arrToStr(magic.getPegs()[i]) +"\n");
	    }
	}

	//if you win or lose
	if (magic.getTurn()==totalTurns && !turnResult) {
	    System.out.println("You Win!");
	    System.out.println("The correct answer was " + magic.getFinal()[0]+magic.getFinal()[1]+magic.getFinal()[2]+magic.getFinal()[3]);
	}
	else
	    {System.out.println("You lose, the computer got your code");} 
    }
}

