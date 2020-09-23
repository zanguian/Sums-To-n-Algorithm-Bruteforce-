import java.util.*;

public class SumsToN {

    public static void main (String[] args) {

        ArrayList<Integer> listOfValuesToTest = new ArrayList<Integer>();
        listOfValuesToTest.add(1);

        int n;

        System.out.println("Please provide a value of n.");
        Scanner s = new Scanner(System.in);

        n = Integer.parseInt(s.nextLine());

        if(n == 0 || n ==1){   //technically base case
            System.out.println(n);
            System.exit(0);
        }

        combinations(n, 1, listOfValuesToTest);

        s.close();

    }

    private static void combinations (int n, int end, ArrayList<Integer> tmp){

        ArrayList<ArrayList<Integer>> possible = new ArrayList<ArrayList<Integer>>();

        int goal = n;

        while(end != goal){

            int sum = 0;

            for(int i = 0; i < tmp.size(); i++) {

                sum += tmp.get(i);
                
            }

            if (sum + end < goal){

                tmp.add(end);

                continue;
            } 
            
            else if(sum + end == goal){

                tmp.add(end);

                for(int i = 0; i < tmp.size(); i++) {  
                    System.out.print(tmp.get(i));
                    if ( i != tmp.size()-1){
                        System.out.print(" + ");
                    }
                } 

            possible.add(tmp);
            System.out.println("\n");


            end = (tmp.get(tmp.size() - 2)) + 1; //added

            tmp.remove(tmp.size() - 1);
            tmp.remove(tmp.size() - 1);



            continue;

            }

            else if (sum + end > goal){

                end = (tmp.get(tmp.size() - 1)) + 1;

                tmp.remove(tmp.size() - 1);



                continue;

            }
        }

        if (end == goal){

            System.out.println(end + "\n");

        }

    }
}