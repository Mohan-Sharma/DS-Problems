package org.msharma;

/**
 * @author Mohan Sharma Created on 16/12/17.
 */
public class ThirdClass
{
	private String name;
	private int salary;
	private SecondClass secondClass;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public SecondClass getSecondClass()
	{
		return secondClass;
	}

	public void setSecondClass(SecondClass secondClass)
	{
		this.secondClass = secondClass;
	}

	@Override public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ThirdClass that = (ThirdClass) o;

		if (salary != that.salary)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		return secondClass != null ? secondClass.equals(that.secondClass) : that.secondClass == null;
	}

	@Override public int hashCode()
	{
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + salary;
		result = 31 * result + (secondClass != null ? secondClass.hashCode() : 0);
		return result;
	}
}
