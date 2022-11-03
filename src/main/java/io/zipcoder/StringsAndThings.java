package io.zipcoder;
import java.util.*;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int counter=0;
        String[] in = input.split(" ");

        for(String value: in){
            if(value.charAt(value.length()-1)=='y' || value.charAt(value.length()-1)=='z'){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        //check if the base String contains the remove String, if no, then return the complete base String
        // If yes, the using the forLoop to iterate each chariter and find the first character fron the remove String
            // When we find the remove.charAt(0) in the base String, using the subString(i,i+remove.length) to compare the remove String
            //If they are equal, i will skip those remove.length, then search the next (i+remove.length)

        String result = "";
        if (base.contains(remove)) {
            for (int i = 0; i < base.length(); i++) {
                if (base.charAt(i) != remove.charAt(0)) {
                    result += base.charAt(i);
                } else {
                    if((base.length()-i-1)<remove.length()){
                        break;
                    } else {
                            String baseSub = base.substring(i, i + remove.length());
                            if (baseSub.equals(remove)) {
                                i += remove.length() - 1;
                            }
                    }
                }
            }
        } else {

            return base;
        }
        return result;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        //using for loop, looking for character 'i' in input, if yes, then compare the next character to see if it is == to 's';

       String isString = removeString(input, "is");
       int isCount = (input.length()-isString.length())/2;

        String notString = removeString(input, "not");
        int notCount = (input.length()-notString.length())/3;

       return (isCount==notCount);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {

        for (int i = 0; i < (input.length() - 2); i++) {
            if (input.charAt(i) == 'g' && input.charAt(i + 1) == 'g') {
               return true;
            }
        }
        return false;
    }

        /**
         * We'll say that a "triple" in a string is a char appearing three times in a row.
         * Return the number of triples in the given string. The triples may overlap.
         * example :  countTriple("abcXXXabc") // Should return 1
         *            countTriple("xxxabyyyycd") // Should return 3
         *            countTriple("a") // Should return 0
         */
    public Integer countTriple(String input) {
        int counter = 0;
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 1) == input.charAt(i + 2)) {
                counter++;
            }

        }
        return counter;
    }
}
