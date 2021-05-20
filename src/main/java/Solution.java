import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    private static final String regex = "[`~!@#$%^&*()_+\\\\[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]";
    private static final DecimalFormat df2 = new DecimalFormat("#.##");

    private String[] inputEdit(String input){

        String replace = input.replaceAll(regex, "").toLowerCase();

        return replace.split(" ");
    }

    private Set<Character> setCharactersToLookFor(String input){
        String replace = input.replaceAll(regex, "").toLowerCase().replaceAll(" ","");
        Set<Character> letters = new HashSet<>();
        for(int i = 0; i<replace.length();i++){
            letters.add(replace.charAt(i));
        }
        return letters;
    }

    public void solution(String input, String charactersToLookFor){

        String[] words = inputEdit(input);
        Set<Character> letters = setCharactersToLookFor(charactersToLookFor);

        HashMap<Key, Integer> charKey = new HashMap<>();
        //logic for creating custom key and counting frequency of letters that user is looking for
        for (String word : words){
            StringBuilder keySb = new StringBuilder();
            int freq = 0;
            for(int i =0; i< word.length();i++){
                if(letters.contains(word.charAt(i))){
                    if(!(keySb.toString().contains(Character.valueOf(word.charAt(i)).toString()))){
                        if(keySb.length() == 0  ){
                            keySb.append(word.charAt(i));
                        }else keySb.append(",").append(word.charAt(i));
                    }
                    freq++;
                }
            }
            Key newKey = new Key(keySb.toString(), word.length());
            if(charKey.isEmpty()){
                charKey.put(newKey,freq);
            }else if(charKey.containsKey(newKey)){
                charKey.put(newKey,charKey.get(newKey)+freq);
            }else charKey.put(newKey,freq);
        }

        int charSum = 0;
        int sum = 0;

        //sum of characters from input
        for(String word : words) charSum += word.length();

        //sum of characters in whole input that user is looking for
        for(Integer i : charKey.values())
            sum += i;


        //rounding
        df2.setRoundingMode(RoundingMode.HALF_UP);
        double fractionFromFrequency = (double)sum/charSum;

        HashMap<Key,Integer> sortedHashMap = sortByValue(charKey);
        for(Key k : sortedHashMap.keySet()){
            String key = k.toString();
            int frequency = sortedHashMap.get(k);
            double frequencyForWord = (double)frequency/sum;
            System.out.println("{" + key + "}" + " = " + df2.format(frequencyForWord) + " (" + frequency + "/" + sum +")");
        }


        System.out.println("TOTAL Frequency: " + df2.format(fractionFromFrequency) +" (" + sum + "/" + charSum + ")");
    }



    // function to sort hashmap by values
    private HashMap<Key, Integer> sortByValue(HashMap<Key, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Key, Integer> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<Key, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Key, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
