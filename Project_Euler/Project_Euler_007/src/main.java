
public class main {
		
	public static boolean isPrime(int n){
		for(int i = 2; i<n;i++){
			
			if(n%i == 0)
				return false;
			}
			return true;
		}
		
	
	public static void main(String[] args) {
		int count = 0;
		int i = 2;
		while(count < 10001){
			
			if(count == 10001)
				break;
			
			if(isPrime(i) == true){
				count++;
				System.out.println(i);
			}
			i++;
				
		}

	}

}
