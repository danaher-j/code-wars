/* Disemvowel Trolls

Trolls are attacking your comment section!

A common way to deal with this situation is to remove all of the vowels from the trolls' comments,
neutralizing the threat.

Your task is to write a function that takes a string and return a new string with all vowels removed.

For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".

Note: for this kata y isn't considered a vowel. */

package _7kyu;

public class Disemvowel_Trolls {

    public static String disemvowel(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if ("aeiouAEIOU".indexOf(str.charAt(i)) == -1) {
                result = result.concat(Character.toString(str.charAt(i)));
            }
        }
        return result;
    }

}