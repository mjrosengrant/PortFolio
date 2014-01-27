//  Assignment 1:
//	 Mike Rosengrant:
//	 1203792676:
// Lecture Topic: Files, Streams, Object Serialiazation
// Description: a program that, given a seven-digit number supplied by the user, 
// 				uses a PrintStream object to write to a file every possible 
//				seven-letter word combination corresponding to that number.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class main{
	
	public static int phoneNumCalc(int phoneNum){
		phoneNum++;
		String phoneNumStr = Integer.toString(phoneNum);
		phoneNumStr = phoneNumStr.replace('1','2');
		phoneNumStr = phoneNumStr.replace('0','2');
		phoneNum = Integer.parseInt(phoneNumStr);
		return phoneNum;
	}
	
	public static String base3(int counter){
		return Integer.toString(counter,3);
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		File file = new File("output.txt");
		PrintStream ps = new PrintStream(file);
		
		//Arrays of letters matching what number button on the keypad they are printed on		
		char arr2[] = {'A','B','C'};
		char arr3[] = {'D','E','F'};
		char arr4[] = {'G','H','I'};
		char arr5[] = {'J','K','L'};
		char arr6[] = {'M','N','O'};
		char arr7[] = {'P','R','S'};
		char arr8[] = {'T','U','V'};
		char arr9[] = {'W','X','Y'};		
		
		char[][] A = new char[7][];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a 7 digit Phone Number. Please no 0s or 1s, dashes or parenthesis.\n(e.g. \'5557777\')\n");
		String phoneNumStr = sc.nextLine();
			
		//Sets up 2d array 
		for(int i = 0;i<phoneNumStr.length();i++){
			switch(phoneNumStr.charAt(i)){
			case '2': A[i] = arr2;
						break;
			case '3': A[i] = arr3;
						break;
			case '4': A[i] = arr4;
						break;
			case '5': A[i] = arr5;
						break;
			case '6': A[i] = arr6;
						break;
			case '7': A[i] = arr7;
						break;
			case '8': A[i] = arr8;
						break;
			case '9': A[i] = arr9;
						break;		
			}	

		}
			
		//counter is converted to base 3 and padded with 0s to ensure 7 digits
		int counter = 0;
		String counterBase3;
		String wordToExp = "";
			
		while(Integer.parseInt(base3(counter))<= 2222222){
			for(int i =0;i<A.length;i++){ 
				counterBase3 = String.format("%07d", Integer.parseInt(base3(counter))); 
				wordToExp += A[i][Integer.parseInt(String.valueOf(counterBase3.charAt(i)))];
			}
			ps.println(wordToExp);
			wordToExp = "";
			counter++;
		}
		System.out.print(counter + " letter combinations found");
		sc.close();
		ps.close();
	}
}
