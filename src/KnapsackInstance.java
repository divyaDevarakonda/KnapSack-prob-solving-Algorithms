import java.util.*;

public class KnapsackInstance implements java.io.Closeable
{
	private int itemCnt; //Number of items
	private int cap; //The capacity
	private int[] weights; //An array of weights
	private int[] values; //An array of values
	public float[] valuePerWeights;
	
	public KnapsackInstance(int itemCnt_)
	{
		itemCnt = itemCnt_;

		weights = new int[itemCnt + 1];
		values = new int[itemCnt + 1];
		valuePerWeights = new float[itemCnt + 1];
		cap = 0;
	}
	public void close()
	{
		weights = null;
		values = null;
	}

	public void Generate()
	{
		int i;
        int wghtSum;

		weights[0] = 0;
		values[0] = 0;
		valuePerWeights[0] = 0;
		wghtSum = 0;
		for(i=1; i<= itemCnt; i++)
		{
			weights[i] = Math.abs(RandomNumbers.nextNumber()%100 + 1);
			values[i] = weights[i] + 10;
			wghtSum += weights[i];
			if( weights[i] !=0)
            {
             valuePerWeights[i] = (float)(values[i] / weights[i]);
            }
           else
           {	
        	   	valuePerWeights[i] =0;
           }
		}
		cap = wghtSum/2;
	}

	public int GetItemCnt()
	{
		return itemCnt;
	}
	public int GetItemWeight(int itemNum)
	{
		return weights[itemNum];
	}
	public int GetItemValue(int itemNum)
	{
		return values[itemNum];
	}
	public int GetCapacity()
	{
		return cap;
	}
	public float GetItemValuePerWeight(int itemNum)
	{
		return valuePerWeights[itemNum];
	}
	public void SetItemValuePerWeight(int itemNum, float value)
	{
		valuePerWeights[itemNum] = value;
	}
	public void SetItemWeight(int itemNum, int weight)
	{
		weights[itemNum] = weight;
	}
	public void SetItemValue(int itemNum, int value)
	{
		values[itemNum] = value;
	}
	
	public void Print()
	{
		int i;

		System.out.printf("Number of items = %d, Capacity = %d\n",itemCnt, cap);
		System.out.print("Weights: ");
		for (i = 1; i <= itemCnt; i++)
		{
			System.out.printf("%d ",weights[i]);
		}
		System.out.print("\nValues: ");
		for (i = 1; i <= itemCnt; i++)
		{
			System.out.printf("%d ",values[i]);
		}
		System.out.print("\nvalue per weights: ");
		for (i = 1; i <= itemCnt; i++)
		{
			System.out.printf("%f ",valuePerWeights[i]);
		}
		System.out.print("\n");
	}
}
