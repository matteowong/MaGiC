import java.util.ArrayList;

public class generateAll{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>(1296);
        for (int h=0; h<6; h++){
            for (int i=0; i<6; i++){
                for (int j=0; j<6; j++){
                    for (int k=0; k<6; k++){
                        ArrayList<Integer> one = new ArrayList<Integer>(4);
                        one.add(k);
                        one.add(j);
                        one.add(i);
                        one.add(h);
                        all.add(one);
                    }
                }
            }
        }
// all = arraylist of arrays
// all contains arrays of [0,0,0,0] , [1,0,0,0] , [2,0,0,0] etc.
        System.out.println(all);
    }
}