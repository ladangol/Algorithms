package ladangol.edu.buffalo.cse;

/**
 * This class has a method to find the longest common subsequence 
 * of two input strings by dynamic programming.
 * @author ladan
 * @version 1.0
 */

public class LCS {
	
	private int commonSequenceLength;
	private String first;
	private String second;
	private String lcs;
	private char[][] buildstring;
	public int getLCSLength(){
		return commonSequenceLength;
	}
	public LCS(String x, String  y){
		first = x;
		second = y;
		buildstring = new char[first.length()][second.length()];
	}
	/**
	 * this method is for obtaining the longest common subsequence from the 
	 * buildString matrix that was filled during the call to findLCS method
	 * the entries of this matrix are:
	 * 'u' meaning that no common character at this stop and go up (decrease row)
	 * 'l' meaning that no common character at this stop and go up (decrease column)
	 * 'b' meaning that this character is common in both strings and is in the LCS
	 * so decrease both column and row
	 * @return
	 */
	public String getLCS(){
		int i = first.length()-1;
		int j = second.length() -1;
		StringBuilder lcs = new StringBuilder();
		while(i>=0 && j>=0){
			if(buildstring[i][j] == 'u'){
				i--;
			}else if(buildstring[i][j] == 'l'){
				j--;
			}else if(buildstring[i][j] == 'b'){
				lcs.append(first.charAt(i));
				i--; j--; 
				
			}
		}
		return lcs.reverse().toString();  //we're building the string from buttom so we have to reverse it
		
	}
	/**
	 * finding the longest common subsequence by a dynamic programming approach
	 */
	public void findLCS()
	{
		/*c[i][j] is defined as the length of the LCS of Xi and Yj
		 * i=0 means Xi = empty string so LCS = empty as well and the length is 0
		 * Same for j=0
		 */
		int[][] c = new int[first.length()+1][second.length()+1];
		for(int i = 0; i<= first.length(); i++){
			c[i][0] = 0;
		}
		for (int j=0; j<=second.length(); j++){
			c[0][j] = 0;
		}
		for(int i=1; i<=first.length(); i++){
			for (int j=1; j<=second.length(); j++){
				if(first.charAt(i-1) == second.charAt(j-1)){
					c[i][j] = c[i-1][j-1]+1;
					buildstring[i-1][j-1] = 'b';   //Note that buildstring is one row and column smaller than c
				}else{
					//both are correct depending on what you choose first you might 
					//get different strings but same length
					/*if(c[i-1][j] > c[i][j-1]){
						c[i][j] = c[i-1][j];
						buildstring[i-1][j-1] = 'u';
					}
					else{
						c[i][j] = c[i][j-1];
						buildstring[i-1][j-1] = 'l'; 
					}*/
					if(c[i][j-1] > c[i-1][j]){
						c[i][j] = c[i][j-1];
						buildstring[i-1][j-1] = 'l';
					}else{
						c[i][j] = c[i-1][j];
						buildstring[i-1][j-1] = 'u'; 
					}
				} 
			}
		}
	   commonSequenceLength = c[first.length()][second.length()];	
	}
	

}
