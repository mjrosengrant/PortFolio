
//Find the difference between the sum of the squares of the first one hundred 
//natural numbers and the square of the sum.

public class main {

	public static void main(String[] args) {
		
		long sumOfSquares = 0, squareOfSums = 0;
		
		for(long i = 1; i<=100;i++){
			sumOfSquares += (i*i);
			squareOfSums += i;
		}
		
		squareOfSums = squareOfSums*squareOfSums;
		
		long answer = squareOfSums - sumOfSquares;
		
		
		System.out.println("squareOfSums = " + squareOfSums);
		System.out.println("sumOfSquares = " + sumOfSquares);
		System.out.print(answer);

	}

}
