/**
 * FieldGenerator.java
 * Author: Nicholas Witmer
 * Revision: 1, Nicholas Witmer
 * Date: 09/27/2015
 * Very simple program to generate random minefields
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class FieldGenerator
{
	/*
	 * Mine fields are generated with dimensions entered into the console it is output to a file 
	 * until the user enters 0 0. A random int is used to determine the placement of mines
	 * if the seed is greater then 75 a mine is placed.
	 * 
	 * Throws:
	 * FileNotFoundException - if the PrintWriter is created with a Null file object,
	 * this should never actually happen in normal use of this program
	 */

	public static void main(String[] args) throws FileNotFoundException
	{
		int rows, cols, seed;
		Random generator = new Random();
		Scanner input = new Scanner(System.in);
		File file = new File("input2.txt");
		PrintWriter output = new PrintWriter(file);
		
		rows = input.nextInt();
		cols = input.nextInt();
		input.nextLine();
		
		while(rows != 0 && cols != 0)
		{
			output.print(rows + " " + cols + "\n");
			for(int row = 0; row < rows; row++)
			{
				for(int col = 0; col < cols; col++)
				{
					seed = generator.nextInt(100);
					if(seed > 75)
					{
						output.print("*");
					}//end if
					else
					{
						output.print(".");
					}//end else
				}//end for
				output.print("\n");
			}//end for
			rows = input.nextInt();
			cols = input.nextInt();
			input.nextLine();
		}//end while
		output.print("0 0");
		output.close();
	}//end main
	
}//end FieldGenerator
