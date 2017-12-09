package org.msharma.algorithm.recursion.Practice_1;

/**
 * @author Mohan Sharma Created on 31/05/17.
 */
public class BruteForceStringMatching {

    public static int doPatternMatching(char[] text, char[] pattern) {
        for(int i=0; i<=(text.length-pattern.length); i++){
            int j=0;
            while(j<pattern.length && text[i+j]==pattern[j]) {
                j++;
            }
            if(j==pattern.length)
                return i;
        }
        return -1;
    }

    public static int doPatternMatchingUsingStringApi(String text, String pattern) {
        for(int i=0; i<=(text.length() - pattern.length()); i++){
            String textToMatch = text.substring(i, i+pattern.length());
            if(textToMatch.equals(pattern))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String text ="abcd";
        String pattern = "cd";
        int result = doPatternMatching(text.toCharArray(), pattern.toCharArray());
        System.out.println(result != -1 ? "match found at index: "+ result : "match not found.");

        result = doPatternMatchingUsingStringApi(text, pattern);
        System.out.println(result != -1 ? "match found at index: "+ result : "match not found.");
    }
}
