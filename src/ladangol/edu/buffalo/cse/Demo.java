package ladangol.edu.buffalo.cse;

public class Demo {

	public static void main(String[] args) {
		
		/*System.out.println("Hello CSE531");*/
		//Testing Log Time Power Algorithm 
		//*************************************************
		//*************************************************
		//System.out.println("2^20 = "+ LogTimePow.FastPow(2, 20));
		//System.out.println("5^7 ="+ LogTimePow.FastPow(5, 7));
		//************************************************
		//**************************************************
		
		//Testing Knapsack Problem
		Item[] myItems = new Item[5];
		//Initialization:
		myItems[0] = new Item(5, 4);
		myItems[1] = new Item(4, 2);
		myItems[2] = new Item(3, 4);
		myItems[3] = new Item(2, 1);
		myItems[4] = new Item(4, 5);
		
		int capacity = 13;
		System.out.println("Items are:");
		for (int i =0; i < myItems.length; i++){
			System.out.println("item"+i +": Weight:" + myItems[i].getWeight() + ", profit: "+ myItems[i].getProfit());
		}
		int[] result = DPKnapsack.OptimalSubset(myItems, capacity);
		// Which items to take:
		System.out.println("Items to take:");
		int totalProf = 0;
		int totalWeight = 0;
		for (int i= 0; i<result.length; i++){
			
			if(result[i] == 1){
				System.out.print("Item" + (i+1) + ", ");
				totalProf += myItems[i].getProfit();
				totalWeight += myItems[i].getWeight();
			}
			
		}
		System.out.println();
		System.out.println("Total Profit is " + totalProf);
		System.out.println("Total weight of items is " + totalWeight);
		
		
		
	}	

}
