package codefights;

public class Sodoku2 
{
	boolean sudoku2(char[][] grid) 
	{
	    int i,j;
	    int i1=0,j1=0;
	    // kiem tra cot
	    for(i=0;i<9;i++)
	    {
	        for(j=0;j<8;j++)
	        {
	            if('1'<=grid[i][j] && '9'>=grid[i][j])
	            {
	                for(j1=j+1;j1<9;j1++)
	                {
	                    if(grid[i][j] == grid[i][j1]) return false;
	                }
	            }
	        }
	    }
	    //kiem ta hang
	    for(j=0;j<9;j++)
	    {
	        for(i=0;i<8;i++)
	        {
	            if('1'<=grid[i][j] && '9'>=grid[i][j])
	            {
	                for(i1=i+1;i1<9;i1++)
	                {
	                    if(grid[i][j] == grid[i1][j]) return false;
	                }
	            }    
	        }
	    }
	    // kiem tra o vuong
	    i1=0;
	    
	   while (i1<9)
	    {
	        j1 = 0;
	        while (j1<9)
	        {
	            if(checkOVuong(i1,j1,grid) == 0 )
	            {
	                return false;
	            }
	            j1 = j1+3;
	        }
	        i1=i1+3;
	    }
	    return true;
	}
	int checkOVuong(int i, int j, char [][] grid)
	{
	    int k=0,save=0;
	    int i1,j1,i2,j2;
	    for(i1=i;i1<i+3;i1++)
	    {
	        for(j1=j;j1<j+3;j1++)
	        {
	            if('1'<=grid[i1][j1] && '9'>=grid[i1][j1])
	            {
	                save++;
	                for(i2=i;i2<i+3;i2++)
	                {
	                    for(j2=j;j2<j+3;j2++)
	                    {
	                        if(grid[i1][j1] == grid[i2][j2]) k++;
	                    }
	                }
	            }
	        }
	    }
	    if(save != k) return 0;
	    else return 1;
	}

}
