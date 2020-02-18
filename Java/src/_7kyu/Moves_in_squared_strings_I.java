/* Moves in squared strings (I)

This kata is the first of a sequence of four about "Squared Strings".

You are given a string of n lines, each substring being n characters long: For example:

s = "abcd\nefgh\nijkl\nmnop"

We will study some transformations of this square of strings.

Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
or printed:

vertical mirror   |horizontal mirror   
abcd --> dcba     |abcd --> mnop 
efgh     hgfe     |efgh     ijkl 
ijkl     lkji     |ijkl     efgh 
mnop     ponm     |mnop     abcd 
#Task:

Write these two functions
and

high-order function oper(fct, s) where

fct is the function of one variable f to apply to the string s (fct will be one of vertMirror, horMirror)
#Examples:

s = "abcd\nefgh\nijkl\nmnop"
oper(vert_mirror, s) => "dcba\nhgfe\nlkji\nponm"
oper(hor_mirror, s) => "mnop\nijkl\nefgh\nabcd"
Note:
The form of the parameter fct in oper changes according to the language. You can see each form according to the language in "Sample Tests".

Bash Note:
The input strings are separated by , instead of \n. The ouput strings should be separated by \r instead of \n. See "Sample Tests".

Forthcoming katas will study other tranformations. */

package _7kyu;

import java.util.function.Function;

public class Moves_in_squared_strings_I {
    
    public static String vertMirror (String strng) {
        String ret = "";
        for (String s : strng.split("\n")) {
            ret += new StringBuilder(s).reverse().toString() + "\n";
        }
        return ret.substring(0, ret.length()-1);
    }

    public static String horMirror (String strng) {
        String[] tmp = strng.split("\n");
        String ret = "";
        for (int i = tmp.length - 1; i >= 0; i--) {
            ret += tmp[i] + "\n";
        }
        return ret.substring(0, ret.length()-1);
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }

}