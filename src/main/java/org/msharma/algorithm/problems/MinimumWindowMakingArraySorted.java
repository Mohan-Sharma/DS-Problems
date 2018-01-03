package org.msharma.algorithm.problems;

import java.util.Arrays;

/**
 * This class demonstrates how we can find the minimum window by sorting which the whole array becomes sorted.
 * @author Mohan Sharma Created on 02/01/18.
 */
public class MinimumWindowMakingArraySorted
{
	/**
	 * This function demonstrates how to find unsorted array by sorting which
	 * the whole input array becomes sorted.
	 * @param array
	 * @return the array after sorting which the input array becomes sorted.
	 */
	private int[] getTheMinimumWindowWhichMakesTheArraySorted(int[] array)
	{
		int startIndex = -1;
		int endIndex = -1;
		int currentMax = Integer.MIN_VALUE;
		int currentMin = Integer.MAX_VALUE;
		for(int i=0; i<array.length; i++)
		{
			if(array[i] > currentMax)
				currentMax = array[i];
			if(array[i] < currentMax)
				endIndex = i;
		}
		for(int i=array.length - 1; i>=0; i--)
		{
			if(array[i] < currentMin)
				currentMin = array[i];
			if(array[i] > currentMin)
				startIndex = i;
		}
		return Arrays.copyOfRange(array, startIndex, endIndex + 1);
	}

	public static void main(String[] args)
	{
		int[] array = {1, 3, 2, 7, 5, 6, 4, 8};
		MinimumWindowMakingArraySorted minimumWindowMakingArraySorted = new MinimumWindowMakingArraySorted();
		int[] result  = minimumWindowMakingArraySorted.getTheMinimumWindowWhichMakesTheArraySorted(array);
		System.out.println(Arrays.toString(result));
	}
}
