public class Woo {

    public static void main(String[] args) {
	System.out.println("Welcome to MaGiC's MasterMind. In this game you are trying to guess a code produced by the computer. The code is any combination of the digits 0-5, of length 4, with repeats allowed. Input guesses in this format: xxxx. Example: 1234. You will receive pegs in response. A 1 corresponds to the right number in the wrong place, a 2 means the right number in the right place. Enjoy!");
	Guesser.play();
    }
}