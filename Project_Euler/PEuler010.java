//Find the sum of all the primes below two million

public class main_010 {

	public static boolean isPrime(long n){
		for(long i = 2; i*i<=n;i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		long sum = 2;
		
		long i = 3;
		while(i<2000000){
			boolean p = isPrime(i);
			if(p==true){
				System.out.println(i);
				sum+=i;
			}
				
			i=i+2;
		}
		System.out.println("\n" + sum);
		
	}

}
