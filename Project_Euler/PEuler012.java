
public class main_012 {
	
	static int factors = 0;
	
	public static int numOfFactors(int x){
		int count = 2;
		for(int i=2;i<=(x/2);i++){
			if(x%i == 0)
				count++;		
		}
		return count;
		
		
	}
	
	
	public static void main(String[] args) {
		//Find triangle number
		//count factors
		//If factors<501, find next triangle number
		int adder=1;
		int triagNum = 1;
		
		while(factors < 501){
			factors = numOfFactors(triagNum);
			System.out.println(triagNum + "-"+ factors);
			adder++;
			triagNum+=adder;
		}
		System.out.println(triagNum);	
		
		
	}

}
