package CodingTest;
import java.util.*;

public class Class1 {
    public static void main(String[] args){
        String[] numstrs = new String[]{"ZASSETE","S4Z537B","7_ASZEYB"};
        String[] words = new String[] {"2455373","425","373","378"};

        String[] numstrs2 = new String[]{"ZAZZ373"};
        String[] words2 = new String[]{"2422373","5455373","2455373"};

        System.out.println(solution(numstrs, words));
        System.out.println(solution(numstrs2, words2));
    }
    public static List<Integer> solution(String[] numstrs, String[]words){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            int countIn = 0;
            for(int j = 0; j<numstrs.length; j++){
                countIn += compare(numstrs[j],words[i]);
            }
            list.add(countIn);
        }

        return list;
    }
    public static Set<String> overOneChar(Map<Integer, ArrayList<String>> map){
        Set<String>set = new HashSet<>();
        for(int i = 0; i<10; i++){
            for(int j = 0; j<map.get(i).size(); j++){
                if(map.get(i).get(j).length()>1) set.add(map.get(i).get(j));
            }
        }
        return set;
    }
    public static int compare(String numstr, String word){

        Map<Integer, ArrayList<String>> map = trans();
        List<String>list = new ArrayList<>();
        for(int i = 0; i<numstr.length(); i++){
            if(i<numstr.length()-1&&overOneChar(map).contains(numstr.charAt(i)+""+numstr.charAt(i+1))){
                list.add(numstr.charAt(i)+""+numstr.charAt(i+1));
                i++;
            } else {
                list.add(numstr.charAt(i)+"");
            }
        }
        String[] numstrLine = list.toArray(new String[0]);
        String[] wordLine = word.split("");

        int count = 0;
        int matchingStart = 0;
        for(int i = 0; i<numstrLine.length; i++){

            if(map.get(Integer.parseInt(wordLine[count])).contains(numstrLine[i])){
                dropFromMap(Integer.parseInt(wordLine[count]),numstrLine[i],map);
                count++;
                if(count==wordLine.length) return 1;

            } else if(wordLine[count].equals(numstrLine[i])){
                count++;
                if(count==wordLine.length) return 1;
            } else{
                count=0;
                map=trans();
                matchingStart ++;
                i = matchingStart -1;
            }
        }
        return 0;
    }
    public static void dropFromMap(Integer key, String value, Map<Integer,ArrayList<String>> map){
        for(int i = 0; i<10; i++){
            if(i==key) continue;
            if(map.get(i).contains(value)){
                map.get(i).remove(value);
            }
        }
    }

    public static Map<Integer, ArrayList<String>> trans() {
        Map<Integer, ArrayList<String>> map = new HashMap<>();

        map.put(0, new ArrayList<>(Arrays.asList("O", "()")));
        map.put(1, new ArrayList<>(Arrays.asList("I")));
        map.put(2, new ArrayList<>(Arrays.asList("Z", "S", "7_")));
        map.put(3, new ArrayList<>(Arrays.asList("E", "B")));
        map.put(4, new ArrayList<>(Arrays.asList("A")));
        map.put(5, new ArrayList<>(Arrays.asList("Z", "S")));
        map.put(6, new ArrayList<>(Arrays.asList("b", "G")));
        map.put(7, new ArrayList<>(Arrays.asList("T", "Y")));
        map.put(8, new ArrayList<>(Arrays.asList("B", "E3")));
        map.put(9, new ArrayList<>(Arrays.asList("g", "q")));

        return map;
    }
}


