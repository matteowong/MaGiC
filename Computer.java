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


}
