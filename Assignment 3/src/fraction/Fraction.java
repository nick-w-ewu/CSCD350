package fraction;

public class Fraction implements Comparable<Fraction>
{
	private int num;
	private int den;

	public Fraction(int num, int den)
	{
		if(den == 0)
		{
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted");
		}
		else
		{
			int gcd;
			if(num < 0 && den < 0)
			{
				gcd = getGCD(num, den);
				this.num = Math.abs(num/gcd);
				this.den = Math.abs(den/gcd);
			}
			else if(num >0 && den < 0)
			{
				gcd = getGCD(num, den);
				this.num = (-1) * (num / gcd);
				this.den = (-1) * (den / gcd);
			}
			else
			{
				gcd = getGCD(num, den);
				this.num = num / gcd;
				this.den = den / gcd;
			}
		}
	}

	public int getNum()
	{
		return this.num;
	}

	public int getDen()
	{
		return this.den;
	}

	private static int getGCD(int num1, int num2)
	{
		int remainder = 0;
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);

		while (num2 > 0)
		{
			remainder = num1 % num2;
			num1 = num2;
			num2 = remainder;
		}

		return num1;
	}
	
	public Fraction add(Fraction that)
	{
		if(that == null)
		{
			throw new NullPointerException("Cannot perform math operations on a null fraction object!");
		}
		int newDen = this.getDen() * that.getDen();
		int newNum = (this.getNum() * that.getDen()) + (that.getNum() * this.getDen());
		
		Fraction newFraction = new Fraction(newNum, newDen);
		
		return newFraction;
	}
	
	public Fraction multiply(Fraction that)
	{
		if(that == null)
		{
			throw new NullPointerException("Cannot perform math operations on a null fraction object!");
		}
		int newNum = this.getNum() * that.getNum();
		int newDen = this.getDen() * that.getDen();
		
		
		Fraction newFraction = new Fraction(newNum, newDen);
		
		return newFraction;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass().getSimpleName().equals("Fraction"))
		{
			Fraction that = (Fraction)obj;
			if (this.num == that.num && this.den == that.den)
			{
				return true;
			}
		}
		return false;
	}

	public int compareTo(Fraction that)
	{
		int temp1, temp2;

		if (this.num == that.num && this.den == that.den)
		{
			return 0;
		}

		temp1 = this.num * that.den;
		temp2 = that.num * this.den;

		return temp1-temp2;
	}

	@Override
	public String toString()
	{
		String retString;
		retString = this.num + "/" + this.den;
		return retString;
	}
	
	public double realValue()
	{
		double toReturn = (double)this.num/this.den;
		return toReturn;
	}
}
