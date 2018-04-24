import java.util.*;

// Dynamic programming solver
public class KnapsackDPSolver implements java.io.Closeable
{
	private KnapsackInstance inst;
	private KnapsackSolution soln;

	public KnapsackDPSolver()
	{
    
	}
	public void close()
	{
    
	}
	public void Solve(KnapsackInstance inst_, KnapsackSolution soln_)
	{
		inst = inst_;
		soln = soln_;
		int itemCnt = inst.GetItemCnt();
		int capacity = inst.GetCapacity();
    
		int[][] t = new int[itemCnt + 1][capacity + 1];
    
		for (int j = 0; j <= capacity; j++)
		{
			t[0][j] = 0;
		}
    
		for (int i = 1; i <= itemCnt ; i++)
		{
			t[i][0] = 0;
			int itemWeight = inst.GetItemWeight(i);
			int itemValue = inst.GetItemValue(i);
    
			for (int j = 1; j <= capacity ; j++)
			{
				if (j < itemWeight)
				{
					t[i][j] = t[i - 1][j];
				}
				else
				{
					if (t[i - 1][j] > (itemValue + t[i - 1][j - itemWeight]))
					{
						t[i][j] = t[i - 1][j];
					}
					else
					{
						t[i][j] = itemValue + t[i - 1][j - itemWeight];
					}
				}
			}
		}
    
		
		//Scan table to get the taken items
		int j = capacity;
		for (int i = itemCnt ; i >= 1 ; i--)
		{
			if (t[i][j] != t[i - 1][j])
			{
				soln_.TakeItem(i);
				j = j - inst.GetItemWeight(i);
			}
		}
    
		//Compute the value for taken items
		soln_.ComputeValue();
	}
}