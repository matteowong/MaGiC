import java.util.ArrayList;

public class Computer extends Player{
    private int iter=0;
     public Computer() {
	_masterOrGuesser = false; //false means it is the master
	//_gameBoard=new int[12][4];
	//_pegsBoard=new int[12][4];
	_currentTurn=0;
	setFinal(makeAnswer());
    }
    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6);
	}
	return answer;
    }

    //public int[] setGuess(int[] guess) will NOT use the given input
    
    /*    public static void main(String[] args){
        Computer t = new Computer();
        System.out.println(t.givePegs());   
	}*/
    
    //    public int[] algo() {
    //}
    
}

