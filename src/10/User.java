public class User extends Player {
    public int[] setGuess(int[] guess) {
	_currGuess=guess;
	gameBoard[_currentTurn]=guess;
    }

}
