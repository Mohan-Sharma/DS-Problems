package org.msharma.algorithm.recursion.Practice_1;

import java.util.Arrays;

/**
 * @author Mohan Sharma Created on 30/05/17.
 */
public class K_AryStringOfNBits {
    private static int[] bitArray;
    public static void generateKAryStrings(int numberOfBits) {
        if(numberOfBits < 1) {
            System.out.println(Arrays.toString(bitArray));
            return;
        }
        bitArray[numberOfBits-1] = 0;
        generateKAryStrings(numberOfBits-1);
        bitArray[numberOfBits-1] = 1;
        generateKAryStrings(numberOfBits-1);
    }
    public static void main(String[] args) {
        int bits = 4;
        bitArray = new int[bits];
        generateKAryStrings(bits);
    }
}
