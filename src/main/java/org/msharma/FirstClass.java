package org.msharma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Mohan Sharma Created on 16/12/17.
 */
public class FirstClass
{
	public static void main(String[] args)
	{
		//int[][] cargo = {{38, 130, 500}, {21, 280, 1800}, {13, 120, 1500}, {40, 160, 1800}};
		//System.out.println(Arrays.toString(findTruckCargo(300, cargo)));
		final String A  = "madam";
		StringBuilder stringBuffer = new StringBuilder(A);
		boolean isPalindrome = A.equalsIgnoreCase(stringBuffer.reverse().toString());
		final String toPrint = isPalindrome ? "Yes" : "No";
		System.out.println(toPrint);
	}

	static int nonRepeatingDigitProductCount(int x, int y, int z) {
		try
		{
			Double.valueOf(x);
			Integer.parseInt(String.valueOf(y));
			Integer.parseInt(String.valueOf(z));
		}catch(NumberFormatException ex)
		{
			throw new IllegalArgumentException("Numbers must be integer.");
		}
		return
				IntStream
						.range(y, z + 1)
						.map(index -> {
							int product =  x * index;
							List<Integer> productDigits  = new ArrayList<>();
							List<Integer> multipleDigits  = new ArrayList<>();
							int m = product;
							while(m > 0)
							{
								productDigits.add( m % 10 );
								m = m/10;
							}
							int n = index;
							while(n > 0)
							{
								multipleDigits.add( n % 10 );
								n = n/10;
							}
							List<Integer> commonElement =
									productDigits.stream().filter(multipleDigits::contains).collect(Collectors.toList());
							if(commonElement.size() > 0)
								return 0;
							else return 1;
						}).sum();

	}

	static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
		int[] result = new int[3];
		if(cargoList.length == 0)
			return result;
		List<Map<String, Integer>> cargos =
				Arrays
						.stream(cargoList)
						.map(list -> {
							Map<String, Integer> storage = new HashMap<>();
							storage.put("Consignment", list[0]);
							storage.put("Weight", list[1]);
							storage.put("Profit", list[2]);
							return storage;
						})
						.collect(Collectors.toList());
		int maxProfit = Integer.MIN_VALUE;
		if(cargos != null && cargos.size() > 0)
		{
			for(int i=0; i < cargos.size() ;i++)
			{
				for (int j = i + 1; j < cargos.size(); j++)
				{
					Map<String, Integer> first = cargos.get(i);
					Map<String, Integer> second = cargos.get(j);

					int consignmentOne = first.get("Consignment");
					int consignmentTwo = second.get("Consignment");

					int weightOne = first.get("Weight");
					int weightTwo = second.get("Weight");

					int profitOne = first.get("Profit");
					int profitTwo = second.get("Profit");
					if ((weightOne + weightTwo) <= maxCargoWeight && (profitOne + profitTwo) > maxProfit)
					{
						maxProfit = profitOne + profitTwo;
						result[0] = consignmentOne;
						result[1] = consignmentTwo;
						result[2] = maxProfit;
					}
				}
			}
		}
		return result;
	}
}
