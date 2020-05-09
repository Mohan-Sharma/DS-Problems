package org.msharma;

/**
 * @author Mohan Sharma Created on 16/12/17.
 */
public class SecondClass extends FirstClass
{
	private int field2;

	SecondClass(int field1, int field2) {
		this.field2 = field2;
	}

	@Override public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		SecondClass that = (SecondClass) o;

		return field2 == that.field2;
	}

	@Override public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + field2;
		return result;
	}
}
