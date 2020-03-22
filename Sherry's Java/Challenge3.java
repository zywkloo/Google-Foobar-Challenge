import java.util.*;

public class Challenge3 {
    public static ArrayList<Integer> calculate(ArrayList<Integer> n, int b){
        Collections.sort(n);
        ArrayList<Integer> min = new ArrayList<Integer>(n.size());
        for(int i = 0; i < n.size(); i++){
            min.add(n.get(i));
        }
        n.sort(Comparator.reverseOrder());
        ArrayList<Integer> max = n;
        ArrayList<Integer> ret = new ArrayList<Integer>(n.size());
        for(int i = 0; i < n.size(); i++){
            ret.add(0);
        }
        for(int i = n.size() - 1; i >= 0; i--){
            int cur = max.get(i) - min.get(i);
            if (cur >= 0) ret.set(i, cur);
            else{
                min.set(i-1, min.get(i-1)+1);
                ret.set(i, b+cur);
            }
        }
        return ret;
    }

    public static ArrayList<Integer> generate(String n){
        ArrayList<Integer> ret = new ArrayList<Integer>(n.length());
        for (int i = 0; i < n.length(); i++) {
            Integer temp = new Integer(Character.getNumericValue(n.charAt(i)));
            ret.add(temp);
        }
        return ret;
    }

    public static int solution(String n, int b) {
        ArrayList<ArrayList<Integer>> loop = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = generate(n);
        loop.add(temp);
        while (true) {
             temp = calculate(temp, b);
             Collections.sort(temp);
            for (int i = 0; i < loop.size(); i++){
                Collections.sort(loop.get(i));
                if(loop.get(i).equals(temp)){
                    return loop.size() - i;
                }
            }
            loop.add(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("1211",10));
        System.out.println(solution("210022",3));
    }
}
