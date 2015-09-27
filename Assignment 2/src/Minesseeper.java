import java.util.ArrayList;
import java.util.Scanner;


public class Minesseeper
{

	public static void main(String[] args)
	{
		int rows, cols, fieldNum = 1;
		String line = "";
		int[][] inputFeild;
		Field tempFeild;
		ArrayList<Field> minefeilds = new ArrayList<Field>();
		Scanner input = new Scanner(System.in);
		
		rows = input.nextInt();
		cols = input.nextInt();
		input.nextLine();
		
		while(rows != 0 && cols != 0)
		{
			inputFeild = new int[rows][cols];
			
			for(int r = 0; r < rows; r++)
			{
				line = input.nextLine();
				for(int c = 0; c < cols; c++)
				{
					if(line.charAt(c) == '*')
					{
						inputFeild[r][c] = -1;
					}
					else
					{
						inputFeild[r][c] = 0;
					}
				}
			}
			tempFeild = new Field(rows, cols, inputFeild);
			minefeilds.add(tempFeild);
			rows = input.nextInt();
			cols = input.nextInt();
		}
		for(Field i : minefeilds)
		{
			System.out.println("Field #" + fieldNum);
			i.solveFeild();
			System.out.println(i);
			fieldNum++;
			System.out.println();
		}
	}

}
