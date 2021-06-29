import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EncodeConsonants {

    public String encode(String str){
        Set<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!vowels.contains(c))
                if (vowels.contains((char)(c + 1)))
                    str = str.replace(c, (char)(c + 2));
                else
                    str = str.replace(c, (char)(c + 1));
        }
        return str;
    }

    public String findSubstr(String str) {
        int length = str.length();
        for (int i = length / 2; i > 1; i-- ) {
            if(length % i == 0) {
                //possible case
                String subStr = str.substring(0, i);
                String repeat = "";
                for (int n = length / i; n > 0; n--) {
                    repeat +=subStr;
                }
                if (repeat.equals(str))
                    return subStr;
            }
        }
        return "-1";
    }
}
