/**
 * Field.java
 * Author: Nicholas Witmer
 *Revision: 1, Nicholas Witmer
 *Date 09/27/2015
 *Accepts minefields input by the user from the console with the number of rows and number
 *of columns specified first followed by the minefield itself. Input fields are accepted parsed
 *into 2d arrays with a -1 specifying the location of a mine and all other field positions
 *starting out a a 0. These arrays are stored in Field objects and then stored in an 
 *ArrayList. When the user enters 0 0 for the field dimensions all the fields in the
 *ArrayList are solved and then printed to the console. 
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Minesweeper
{
	/*
	 * Main method accepts minefields input by the user in the console, parses them into
	 * Field objects, stores them, and when the user is done the minefields are passed
	 * on to the printFields method to be solved and printed
	 */
	
	public static void main(String[] args)
	{
		int rows, cols;
		String line = "";
		int[][] inputFeild;
		Field tempFeild;
		ArrayList<Field> minefields = new ArrayList<Field>();
		Scanner input = new Scanner(System.in);
		
		rows = input.nextInt();
		cols = input.nextInt();
		
		while(rows != 0 && cols != 0)
		{
			input.nextLine();
			inputFeild = new int[rows][cols];
			
			for(int r = 0; r < rows; r++)
			{
				line = input.nextLine();
				for(int c = 0; c < cols; c++)
				{
					if(line.charAt(c) == '*')
					{
						inputFeild[r][c] = -1;
					}//end if
					else
					{
						inputFeild[r][c] = 0;
					}//end else
				}//end for
			}//end for
			tempFeild = new Field(rows, cols, inputFeild);
			minefields.add(tempFeild);
			rows = input.nextInt();
			cols = input.nextInt();
		}//end while
		printFields(minefields);
	}
	
	/*
	 * Loops through all the minefields in the passed in ArrayList, solves them, and
	 * then prints them to the console along with their field number
	 * 
	 * Parameters:
	 * ArraList<Field> minefields - all the minefields entered by the user stored as 
	 * field objects
	 */
	
	public static void printFields(ArrayList<Field> minefields)
	{
		int fieldNum = 1;
		for(Field i : minefields)
		{
			System.out.println("Field #" + fieldNum);
			i.solveFeild();
			System.out.println(i);
			fieldNum++;
			System.out.println();
		}//end for
	}

}
