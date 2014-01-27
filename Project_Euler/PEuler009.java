
public class main009 {


	public static void main(String[] args) {
		
		//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
		//Find the product abc
		
		int a,b,c = 0;
		for(a=1;a<998;a++){
			for(b=1;b<998;b++){
				for(c=1;c<998;c++){
					if(a+b+c ==1000){
						if(c*c == a*a + b*b)
							System.out.print(a + " " + b + " " + c + "     " + a*b*c + "\n");
					}
					
					
				}
			}
		}
		
		

	}

}
