package ladangol.edu.buffalo.cse;


/**
 * Matrix Chain Product Problem:
 * Input: n matrices A1,A2,..., An the size of Ai is pi-1 * pi 
 * for i=1,...,n
 * Find: the best way to compute the chain product: A1 * A2 * ...* An 
 * so that the total cost is minimum.
 * @author ladan
 * @version 1.0
 */

public class MatrixChainProduct {
	
	/**
	 * Let Ai..j (1<= i<=j <= n) be the chain product Ai*Ai+1*...*Aj
	 * 
	 * Let m[i,j] be the minimum number of scalar multiplications
	 * needed to compute Ai..j
	 * 
	 */
	int[][] m;
	int[][]s;
	int[] p; //for storing the size    
	String finalMultiplication; 
	public MatrixChainProduct(int n, int[] p){
		m = new int[n][n];
		s= new int[n][n];
		this.p = p;
		finalMultiplication = "";
		//Initialization 
		// -1 denotes undefined
		for(int i = 0; i< n ; i++)
			for(int j = 0; j< n; j++)
				m[i][j] = -1;
	}
	public int MCP_Mem(int i , int j){
		if(m[i][j] != -1){
			return m[i][j];
		}
		else{
			if (i==j){
				m[i][j] = 0;
				return 0;
			}else{
				int min = Integer.MAX_VALUE;
				for(int k=i; k<j ; k++){
					int temp = MCP_Mem(i, k)+ MCP_Mem(k+1, j)+p[i]*p[k+1]*p[j+1];  //it should be pi-1* pk* pj 
					//If indicies were from 1 not 0 to n
					if(temp < min){
						min = temp;
						s[i][j] = k;
					}
				}
				m[i][j] = min;
				return m[i][j];
			}
		}
	}
	public String MCP_Multiplication(int i, int j){
		if(i < j){
			String x = MCP_Multiplication(i, s[i][j]);
			String y = MCP_Multiplication(s[i][j]+1, j);
			return "( "+x+ " )" +" ( "+y+" )";
		}
		else
			return "M"+(i+1);
	}
	public String MCP_M(){
		String result = "";
		for (int i = 0; i<m.length; i++){
			for(int j = 0; j<m[0].length; j++){
				result += m[i][j]+ " ";
			}
			result+= "\n";
		}
		return result;
	}

}
