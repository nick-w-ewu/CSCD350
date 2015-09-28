import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class FieldGenerator
{

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
			for(int r = 0; r < rows; r++)
			{
				for(int c = 0; c < cols; c++)
				{
					seed = generator.nextInt(100);
					if(seed > 75)
					{
						output.print("*");
					}
					else
					{
						output.print(".");
					}
				}
				output.print("\n");
			}
			rows = input.nextInt();
			cols = input.nextInt();
			input.nextLine();
		}
		output.print("0 0");
		output.close();
	}
}
