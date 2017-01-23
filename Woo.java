
public class Woo {

    public static void main(String[] args) {
	System.out.println("Welcome to MaGiC's MasterMind. In this game you are trying to guess a code produced by the MasterMind. The code is any combination of the digits 1-6, of length 4, with repeats allowed. Example codes are: 1633, 1425, 5555\n");
	System.out.println("Input guesses in this format: xxxx. Example: 1234.\n");
	System.out.println("The guesser  will receive 'pegs' in response. These pegs tell the guesser how close their guess is and will be in the format xxxx. A 1 corresponds to the right number in the wrong place, a 2 means the right number in the right place, and a 0 means it is the wrong number. For example, if the inputted guess is 3434 and the correct code is 5364, then the pegs returned should be 2100. Remember, order of pegs does not matter (2020 is the same as 2200 etc.). Example pegs: 2100, 1110, 2222");
	System.out.println("If all the pegs are 2s, then every peg is the correct color, in the correct position, and the guesser has won.");
	System.out.println("Enjoy!");
	System.out.println();
    System.out.println("Would you like to enable fancy mode?");
    System.out.println("1: Yes");
    System.out.println("2: No");
    int graphics = Prompt.getChoice("Pick a number",2);
    System.out.println();

	System.out.println("Decide how you want to play:");
	System.out.println("1: If you want to be the guesser");
	System.out.println("2: If you want to be the MasterMind");
	System.out.println("3: For a two player game");
	int choice = Prompt.getChoice("Pick a number",3);
	System.out.println();

	System.out.println("Now, pick a difficulty.");
	System.out.println("1: If you want the guesser to have 12 turns");
	System.out.println("2: If you want the guesser to have 10 turns");
	System.out.println("3: If you want the guesser to have 8 turns");
    System.out.println("4: If you want the guesser to have 5 turns");
	int difficulty=Prompt.getChoice("You decision",4);

	//if statements turn input into number of turns
	     if (difficulty==1) difficulty=12;
	else if (difficulty==2) difficulty=10;
	else if (difficulty==3) difficulty=8 ;
    else if (difficulty==4) difficulty=4 ;
    //if 1, true, if 2 false
    boolean isFancy = (graphics == 1);

	if (choice==1)
	    Guesser.play(difficulty, isFancy);
	else if (choice==2)
	    MasterMind.play(difficulty, isFancy);
	else if (choice==3)
	    TwoPlayer.play(difficulty, isFancy);
    }
}
