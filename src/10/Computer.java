public class Computer extends Player{
    public int[] makeAnswer(){
	   int[] answer= new int[6];
	   for (int i=0; i<6; i++){
           answer[i]=(int)Math.random()*6;
	   }
	   return answer;
    }
    public static void main(String[] args){
        Computer t = new Computer();
        System.out.println(t.givePegs());   
    }
    
	    
}
