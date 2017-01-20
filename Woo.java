
public class Woo {

    public static void main(String[] args) {
	System.out.println("Welcome to MaGiC's MasterMind. In this game you are trying to guess a code produced by the MasterMind. The code is any combination of the digits 1-6, of length 4, with repeats allowed. Example codes are: 1633, 1425, 5555\n");
	System.out.println("Input guesses in this format: xxxx. Example: 1234.\n");
	System.out.println("The guesser  will receive 'pegs' in response. These pegs tell the guesser how close their guess is and will be in the format xxxx. A 1 corresponds to the right number in the wrong place, a 2 means the right number in the right place, and a 0 means it is the wrong number. Examples: 2100, 1110, 2222. Enjoy!");
	System.out.println();
	System.out.println("Decide how you want to play:");
	System.out.println("1 if you want to be the guesser");
	System.out.println("2 if you want to be the MasterMind");
	System.out.println("3 for a two player game");
	int choice = Prompt.getChoice("Pick a number");
	if (choice==1)
	    Guesser.play();
	else if (choice==2)
	    MasterMind.play();
	else if (choice==3)
	    TwoPlayer.play();
    }
}
