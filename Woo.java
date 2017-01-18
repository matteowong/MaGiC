
public class Woo {

    public static void main(String[] args) {
	System.out.println("Welcome to MaGiC's MasterMind. In this game you are trying to guess a code produced by the computer. The code is any combination of the digits 0-5, of length 4, with repeats allowed. Input guesses in this format: xxxx. Example: 1234. You will receive pegs in response. A 1 corresponds to the right number in the wrong place, a 2 means the right number in the right place. Enjoy!");
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
