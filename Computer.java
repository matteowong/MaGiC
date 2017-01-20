import java.util.ArrayList;

public class Computer extends Player{
    private int iter=0;
    private makeGuess algorithm=new makeGuess();

    //generate a random combination for when the user plays as the guesser
    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6)+1;
	}
	return answer;
    }

    //constructor for Computer
    public Computer(boolean mOrG) {
	_masterOrGuesser = mOrG; //false means it is the master
	_currentTurn=0;
	//if the computer is the master, it must generate a code 
	if (mOrG)
	    setFinal(makeAnswer()); 
    }


}
