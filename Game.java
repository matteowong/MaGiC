import java.util.ArrayList;

public class Game {
    private Player _guesser; //commented to avoid error for time being
    private Player _masterMind; //see above
    private int[][] _board = new int[12][4];
    private int[][] _pegs= new int[12][4];
    private int _turn;
    private int[] _correctAns= new int[4];
    // private static String[][] matching = {{"1","blue"},{"2","red"},{"3","orange"},{"4","yellow"},{"5","purple"},{"6","brown"}};

    //constructor, takes an int. 0 means player is guesser, 1 means computer is guesser, 2 means two player game
    //pre-con: int from 0-2
    //post-con: instantiates Game
    public Game (int i) {
	if (i==0) {//called by Guesser.java
	    _guesser = new User();
	    _masterMind = new Computer(true);
	    _correctAns=_masterMind.getFinal();
	    _turn=0;
	}
	else if (i==1) {//called by MasterMind.java
	    _guesser = new Computer(false);
	    _masterMind=new User();
	    _turn=0;
	    setFinalTwoPlayer();
	}
	else if (i==2) {//called by TwoPlayer.java
	    _guesser=new User();
	    _masterMind=new User();
	    _turn=0;
	    setFinalTwoPlayer();
	}
    }


    //sets the final answer for a TwoPlayer game or a MasterMind game. Used when the user has to input a final answer
    //pre-con: none
    //post-con: sets final answer to user input in the terminal
    public void setFinalTwoPlayer() {
	System.out.println("Whoever is playing the mastermind should input their code");
	_masterMind.setFinal(Prompt.getGuess("Input final code ", true));//true hides the input
    }


    //accessor for board
    public int[][] getBoard() {
	return _board;
    }

    //accessor for pegs
    public int[][] getPegs() {
	return _pegs;
    }


    //this method allows a turn to be played
    //pre-con: takes an int array as a guess
    //post-con: returns boolean depending on if guess is correct
    public boolean turn(int[] guess) {
	//following two lines give the _guesser a local copy of board and pegs, this is important for the Computer to make guesses
	_guesser.setGameBoard(getBoard());
	_guesser.setPegsBoard(getPegs());
	_board[_turn]=_guesser.setGuess(guess);//sets guess in board
	_masterMind.setGuess(_board[_turn]);//gives mastermind the guess
	_pegs[_turn]=_masterMind.givePegs();//mastermind uses guess to give pegs
	//again, following two lines are local copy if computer needs to generate a guess
	_guesser.setGameBoard(getBoard());
	_guesser.setPegsBoard(getPegs());
	_guesser.setTurn();
	_turn+=1;
	if (_pegs[_turn-1][3]==2)//checks if guess is correct
	    return true;
	else
	    return false;
    }


    //accessor for turn
    public int getTurn() {
	return _turn;
    }

    //accessor for final answer
    public int[] getFinal() {
        return _correctAns;
    }



    /*
    public static String searchColor(String key){
	for (int i=1; i<7; i++){
	    if (matching[i][1].equals(key))
		return matching[i][0];
	}
	return "";
    }
    public static ArrayList<String> translatorToNum(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        for (int i=0; i<input.size(); i++){
            output.add(searchColor(input.get(i)));
        }
        return output; //NOTE: output is a string, so must still parse to get int
	}*/




    /*testing
      public static void main(String[] args){
      String[] x = new String[] {"blue","brown","orange","purple","blue","yellow"};
      ArrayList<String> t = new ArrayList<String>();
      for (String ret:x)
      t.add(ret);
      Game test=new Game();
      System.out.println(test.translatorToNum(t)); //expect 1 6 3 5 1 4
      Game magic = new Game();
      int[] a = {0,1,2,3};
      magic.turn(a);
      for (int x:magic._correctAns)
      System.out.print(x+",");
      System.out.println();
      for (int i:magic._board[0])
      System.out.print(i+",");
      System.out.println();
      for (int j:magic._pegs[0])
      System.out.print(j+",");
      System.out.println();
      }*/


}
