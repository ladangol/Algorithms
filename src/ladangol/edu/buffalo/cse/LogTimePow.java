package ladangol.edu.buffalo.cse;
/**
 * This class has one method FastPow to compute a^b in O(log n) time.
 * @author ladan
 * @version 1.0
 */

public class LogTimePow {
	public static double FastPow(double a, int n){
		if (n==0){
			return 1;
		}
		if(n==1){
			return a;
		}
		if (n%2 == 0){
			double b = FastPow(a, n/2);
			return b*b;
		}
		else{
			double b = FastPow(a, n/2);
			return b*b*a;
		}
		
		
			
	}
	

}
