import java.util.ArrayList;

public class Computer extends Player{
    private int iter=0;
    private makeGuess algorithm=new makeGuess();

    //generate a random combination for when the user plays as the guesser
    //pre-con: none
    //post-con: returns an int array of length 4 made of ints from 1-6, inclusive
    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6)+1;//generates random num and adds one, typecasting always first
	}
	return answer;
    }

    //constructor for Computer
    //pre-con: takes boolean
    //post-con: instanciates a Computer. the boolean input is only needed to know if the computer should generate its own final answer
    public Computer(boolean mOrG) {
	_masterOrGuesser = mOrG; //false means it is the master
	_currentTurn=0;
	//if the computer is the master, it must generate a code 
	if (mOrG)
	    setFinal(makeAnswer()); 
    }


}
