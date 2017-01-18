import java.util.ArrayList;

public class Computer extends Player{
    private int iter=0;
    private makeGuess algorithm=new makeGuess();

    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6)+1;
	}
	return answer;
    }

    public Computer(boolean mOrG) {
	_masterOrGuesser = mOrG; //false means it is the master
	//_gameBoard=new int[12][4];
	//_pegsBoard=new int[12][4];
	_currentTurn=0;
	if (mOrG)
	    setFinal(makeAnswer()); 
    }
    /*comment this out to make it compilable
    public int[] setGuess(int[] guess) {
	if (!_masterOrGuesser) {//when masterOrGuesser is true the computer is the master
	ArrayList<Integer> a1 = algorithm.guess(_gameBoard[_currentTurn], _pegsBoard[_currentTurn]);
	//	int[] a2 = new int[4];
	for (int i=0;i<4;i++)
	    _currGuess[i]=a1.get(i);
	}
	else {
	    super.setGuess(guess);
	}
	return _currGuess;

	}*/



    public int checkZeroes(int[] a) {
	int ret=0;
	for (int x: a) {
	    if (x==0)
		ret+=1;
	}
	return ret;
    }

    /*    public int[] algo() {
	  int[] guesses = new int[2];
	  int[] nextGuess=new int[4];
	  int numZ=0;
	  if (iter==0) {
	  guesses[0]=1;
	  guesses[1]=2;
	  }
	  else if (iter==1) {
	  guesses[0]=3;
	  guesses[1]=4;
	  }
	  else {
	  guesses[0]=5;
	  guesses[1]=6;
	  }
	  numZ=checkZeroes(_gameBoard[_currentTurn]);
	  }*/

}
