//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?


public class main {
	
	public static boolean isPrime(long n){
		for(long i = 2; i<n;i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	public long largePrime(long n){
		for(long i = n-1;i>0;i--){
			if(isPrime(i)==true)
				return i;
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		
		long num = 600851475143L;
		long max = 0;
		for(long i=2; i<=num; i++){
			if(num%i == 0){
				boolean a = isPrime(i);
				if(a==true){
					max = i;
				}	
				num = num/i;
			}
		}
		System.out.println(max);
	}

}
