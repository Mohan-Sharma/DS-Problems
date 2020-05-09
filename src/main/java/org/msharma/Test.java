package org.msharma;

/**
 * @author Mohan Sharma Created on 16/12/17.
 */
public interface Test extends Abstract
{
	void display();

	default void printMe()
	{
		System.out.println("Example of default method in interface.");
	}

	static void staticPrintMe()
	{
		System.out.println("Example of static method in interface.");
	}
}
