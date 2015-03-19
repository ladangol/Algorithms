package ladangol.edu.buffalo.cse;
/**
 * This class has a method for solving 0/1 Knapsack problem using 
 * Dynamic Programming
 * 
 * @author ladan
 * @version 1.0
 */
public class DPKnapsack {
	/**
	 * 
	 * @param items : Each item 1<= i <=n has a weight and a profit (in dollars)
	 * @param Capacity : We have a knapsack with Capacity K pounds
	 * @return  a 0/1 vector (x1,...,xn) such that sum(xi*w[i]) <= k and sum(xi*p[i]) is maximized
	 * In other Words, a subset of items such taht the total weigh of them is at most K and the 
	 * Total profit of them is maximum
	 */
	public static int[] OptimalSubset(Item items[], int capacity){
		
		/*
		 * Profit[i][j] = The maximum profit if the knapsack capacity is j, 
		 * and we can fill the knapsack only with a subset of item1, item2, ..., itemi 
		 */
		int[][] profit = new int[items.length+1][capacity+1];  //we want to have an entry for profit[n,K]
		int[][] dir = new int[items.length+1][capacity+1];
		int[] x = new int[items.length];
		
		//When we cannot put any item in the knapsack
		for(int i = 0; i<= capacity; i++)
			profit[0][i] = 0;
		//When the capacity is 0 
		for (int i = 0; i <= items.length; i++)
			profit[i][0] = 0;
		for(int i=1; i<=items.length; i++){
			for(int j=1; j<=capacity; j++){
				if(items[i-1].getWeight() > j){
					profit[i][j] = profit[i-1][j];
					dir[i][j] = 1;
				}
				//Maximum of the profit if we ignore item i or add item i.
				else
				{
					if(profit[i-1][j] > items[i-1].getProfit()+ profit[i-1][j-items[i-1].getWeight()])
					{
						profit[i][j] = profit[i-1][j];
						dir[i][j] = 1;
						
					}
					else{
						profit[i][j] = items[i-1].getProfit()+ profit[i-1][j-items[i-1].getWeight()];
						dir[i][j] = 2;
					}
					
					
				}
					
			}
		}
		int j = capacity;
		for (int i = items.length; i >= 0; i--){
			if(dir[i][j] == 2){
				j= j - items[i-1].getWeight();
				x[i-1] = 1;  //item i is put in knapsack
			}
		}
		return x;
		
		
	}

}
