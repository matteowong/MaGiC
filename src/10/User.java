public class User extends Player {

    public Player() {
	_masterOrGuesser=true;
	_gameBoard=new int[12][4];
	_pegsBoard=new int[12][4];
	_currentTurn=0;
    }

    public int[] setGuess(int[] guess) {
	_currGuess=guess;
	gameBoard[_currentTurn]=guess;
    }

}
