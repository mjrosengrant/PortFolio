import java.util.List;


public class main {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int a = 0;
		boolean found = false;
		int[] PrimeArray = new int[978];
		int max = 0;
		int primeCounter = 0;
		
		for(i=999; i>99; i--){
			
			//if(found == true)
				//break;
	
			for(j = 999; j>99;j--){
				a = i*j;
				String a3 = Integer.toString(a);
				String a1 = a3.substring(0,3);
				String a2 = a3.substring(5).concat(a3.substring(4,5).concat(a3.substring(3,4)));
				
				if(a1.compareTo(a2)==0){
					//System.out.println(a3 + ", i= " + i +", j =" + j);
					PrimeArray[primeCounter]=a;
					primeCounter++;
					 }
			}
						
		}
		int k = 0;
		while(k<PrimeArray.length){
			if(PrimeArray[k]>max)
				max = PrimeArray[k];
			k++;
		}
		System.out.println(max);
		

		
		}
		
	}


