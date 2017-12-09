package org.msharma.algorithm.recursion.Practice_1;

/**
 * @author Mohan Sharma Created on 30/05/17.
 */
public class TowerOfHanoi {

    public static void solveTowerOfHanoi(int size, char start, char auxiliary, char dest) {
        if(size == 1) {
            System.out.println("moving " + start + " to " + dest);
            return;
        }
        solveTowerOfHanoi(size-1, start, dest, auxiliary);
        System.out.println("moving " + start +" to " + dest);
        solveTowerOfHanoi(size-1, auxiliary, start, dest);
    }
    public static void main(String[] args) {
        solveTowerOfHanoi(3, 'A', 'B', 'C');
    }
}
