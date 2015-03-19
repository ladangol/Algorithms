package ladangol.edu.buffalo.cse;

/**
 * This class is used in DPKnapsack to provide items to put in knapsack
 * Each item has a weight and profit
 * @author ladan
 * @version 1.0
 */

public class Item {
	private int weight;  
	private int profit;
	
	public Item(int w, int p){
		weight = w;
		profit = p;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int w){
		weight = w;
	}
	
	public int getProfit(){
		return profit;
	}
	public void setProfit(int p){
		profit = p;
	}

}
