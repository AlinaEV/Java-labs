import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Алина on 13.11.2016.
 */
public class LambdaLab {
    //Знайти слова, які складаються тільки з різних символів.
    // На виході – масив String.

    public static void main(String[] args) {

        String[] ex = {"Rafaello", "Svitoch", "Roshen", "Trufallie", "Ferero", "sweet", "sweets", "good", "Alina"};
        List<String> words = Arrays.asList(ex);
        List<String> resultList=new ArrayList<String>();

        String unicWord = getResultString(words);
        System.out.println(unicWord);
    }

    public static String getResultString(List<String> words){
        return words.stream()
                .filter(word -> word.length() == getNumberOfDiffSymbols(word))
                .collect(Collectors.joining(", "))
                .toString();
    }

    public static int getNumberOfDiffSymbols(String str) {
        Map<Character, Integer> symbols = new HashMap<>();
        for (int i=0;i<str.length();i++) {
            Character ch = str.charAt(i);
            symbols.put(ch, 0);
        }
        return symbols.keySet().size();
    }
}
