
public class Field
{
	private int rows;
	private int columns;
	private int[][] field;
	
	public Field(int r, int c, int[][] field)
	{
		this.rows = r;
		this.columns = c;
		this.field = field;
	}
	
	public void solveFeild()
	{
		for(int r = 0; r < this.rows; r++)
		{
			for(int c = 0; c < this.columns; c++)
			{
				if(this.field[r][c] != -1)
				{
					if(isMine(r, c + 1))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r, c - 1))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r + 1, c))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r - 1, c))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r + 1, c + 1))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r - 1, c + 1))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r - 1, c - 1))
					{
						this.field[r][c] += 1;
					}
					if(isMine(r + 1, c - 1))
					{
						this.field[r][c] += 1;
					}
				}
			}
		}
	}
	
	private boolean isMine(int i, int j)
	{
		if(i >= this.rows || j >= this.columns || i < 0 || j <0)
		{
			return false;
		}
		if(this.field[i][j] == -1)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String toReturn = "";
		
		for(int r = 0; r < this.rows; r++)
		{
			for(int c = 0; c < this.columns; c++)
			{
				if(this.field[r][c] == -1)
				{
					toReturn += "*";
				}
				else
				{
					toReturn += this.field[r][c];
				}
			}
			toReturn += "\n";
		}
		return toReturn;
	}
}
