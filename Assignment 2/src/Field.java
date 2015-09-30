/**
 * Field.java
 * Author: Nicholas Witmer
 *Revision: 1, Nicholas Witmer
 *Date 09/27/2015
 *Used to store an array of integers representing a minefield and also offers functionality
 *to solve the minefield and return a string representation of the minefield
 *
 */

public class Field
{
	private int rows;
	private int columns;
	private int[][] field;
	
	/*
	 * Initializes a new Field with the parameters passed in
	 * Parameters:
	 * Int r - number of rows
	 * Int c - number of columns
	 * Int[][] field - the minefield that this Field object is representing
	 */
	
	public Field(int r, int c, int[][] field)
	{
		this.rows = r;
		this.columns = c;
		this.field = field;
	}//end field
	
	/*
	 * This method is called by with a Field object, it traverses the field visiting each element
	 * if the element is not a mine it searches its 8 neighbors increasing the count each time a 
	 * mine is found in one of its neighbors
	 * 
	 */
	
	public void solveFeild()
	{
		for(int row = 0; row < this.rows; row++)
		{
			for(int col = 0; col < this.columns; col++)
			{
				if(this.field[row][col] != -1)
				{
					if(isMine(row, col + 1))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row, col - 1))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row + 1, col))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row - 1, col))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row + 1, col + 1))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row - 1, col + 1))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row - 1, col - 1))
					{
						this.field[row][col] += 1;
					}//end if
					if(isMine(row + 1, col - 1))
					{
						this.field[row][col] += 1;
					}//end if
				}//end if
			}//end for
		}//end for
	}//end solveField
	
	/*
	 * Checks to see if the passed in Field element is actually in the field dimensions
	 * and if it is returns whether that element contains a mine, denoted by a -1
	 * 
	 * Parameters:
	 * Int row - row in the field
	 * Int col - column in the field
	 * 
	 * Returns:
	 * Boolean - true if the field element exists and is a mine, false otherwise
	 */
	
	private boolean isMine(int row, int col)
	{
		if(row >= this.rows || col >= this.columns || row < 0 || col <0)
		{
			return false;
		}//end if
		if(this.field[row][col] == -1)
		{
			return true;
		}//end if
		return false;
	}//end isMine
	
	/*
	 * Creates a string representation of a minefield, with a mine represented by an *
	 * and all other positions with the number contained in the field element
	 * 
	 * Returns:
	 * String - String representation of the minefield
	 */
	
	public String toString()
	{
		String toReturn = "";
		
		for(int row = 0; row < this.rows; row++)
		{
			for(int col = 0; col < this.columns; col++)
			{
				if(this.field[row][col] == -1)
				{
					toReturn += "*";
				}//end if
				else
				{
					toReturn += this.field[row][col];
				}//end else
			}//end for
			toReturn += "\n";
		}//end for
		return toReturn;
	}//end toString
}//end Field
