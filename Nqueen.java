import java.util.*;

class Nqueen
{
	public static void main(String[] args) 
	{
		int n=4;
		int board[][]=new int[n][n];
		// function(0,8,new ArrayList(),board);

		int column[]=new int[n];
		int ndiag[]=new int[2*n-1];
		int rdiag[]=new int[2*n-1];

		branchAndBound(0,n,column,ndiag,rdiag,board,new ArrayList());	
	}

	public static void function(int row,int n, ArrayList<String>ls,int board[][])
	{
		if(row==n)
		{
			System.out.println(ls);
			return;
		}

		for(int col=0;col<n;col++)
		{
			if(isSafe(row,col,board,n))
			{
				board[row][col]=1;
				String s=String.valueOf(row)+String.valueOf(col);
				ls.add(s);
				function(row+1,n,ls,board);
				ls.remove(ls.size()-1);
				board[row][col]=0;
			}
		}
	}

	public static boolean isSafe(int row,int col,int board[][],int n)
	{
		for(int i=row-1;i>=0;i--)
		{
			if(board[i][col]==1)
			{
				return false;
			}
		}

		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}

		for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}

		return true;
	}


	public static void branchAndBound(int row,int n,int column[],int ndiag[],int rdiag[],int board[][], ArrayList<String>ls)
	{
		if(row==n)
		{
			System.out.println(ls);
			return;
		}

		for(int col=0;col<n;col++)
		{
			if(column[col]==0 && ndiag[row+col]==0 && rdiag[row-col+n-1]==0)
			{
				column[col]=1;
				ndiag[row+col]=1;
				rdiag[row-col+n-1]=1;

				board[row][col]=1;
				String s=String.valueOf(row)+String.valueOf(col);
				ls.add(s);
				branchAndBound(row+1,n,column,ndiag,rdiag,board,ls);
				ls.remove(ls.size()-1);
				board[row][col]=0;

				column[col]=0;
				ndiag[row+col]=0;
				rdiag[row-col+n-1]=0;
			}
		}
	}
}