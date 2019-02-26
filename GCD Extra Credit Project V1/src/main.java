/*
Instructor: Prof. Hausknecht 
Class: MTH 182
Assignment: GCD Extra Credit Project V1 2019
Student: Thomas Maloney Jr
*/

/*  About: main.java
 ***************************************
 This class calculates gcd(a,b) = n and
 finds when gdc(a,b) = a(s)+b(t). Using
 the matrix method.
 This small program ask a user for two 
 integers and validates input is integers 
 and both are positive. Only when there is
 valid integers does the program continue 
 and then display the results.  
 ****************************************/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.NonReadableChannelException;
import java.time.Year;
import java.util.StringTokenizer;

import javax.jws.WebParam.Mode;

public class main {
	public static void main(String[] args) {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String inputString = new String();
		
		boolean ctrl = true;
		int a = 0, b = 0;
		
		//Get user input (+) INTEGER only!
		while (ctrl) {
			System.out.println("Enter in two integers (with space between) to calculate \ngcd(a,b) = n = a(s)+b(t)");
			
			try {
				inputString = userInput.readLine();
			}catch (Exception e) {
				e.printStackTrace();
			}
			StringTokenizer input = new StringTokenizer(inputString," ");
			try {
				a = Integer.parseInt(input.nextToken());
				b = Integer.parseInt(input.nextToken());				
				} catch (Exception e) {
					continue;
				}
			if(a < 0 || b < 0) {
				System.out.println("Only positive INTEGERS, please.");
			} else {
				ctrl = false;	
			}
		}
		
		
	//Calculate GCD(a,b) (simulated matrix) 
	int []A_array = {1,0,a};
	int []B_array = {0,1,b};
	int switcher = 2;
	int d = 1; //divisor result/multiplier 
	int n = 0, s = 0,t =0;
	
	while(A_array[2] != 0 && B_array[2] != 0) {
		if ((switcher%2) == 0) {
			switcher = 3;
			//A_array(a) / B_array(b)
			d = A_array[2]/B_array[2];
			
			//A_array - d*B_array
			A_array[0] = A_array[0]-d*B_array[0];
			A_array[1] = A_array[1]-d*B_array[1];
			A_array[2] = A_array[2]-d*B_array[2];
		} else {
			switcher = 2;
			//A_array(a) / B_array(b)
			d = B_array[2]/A_array[2];
			
			//B_array - d*A_array
			B_array[0] = B_array[0]-d*A_array[0];
			B_array[1] = B_array[1]-d*A_array[1];
			B_array[2] = B_array[2]-d*A_array[2];
		}
	}
	
	//Getting the results
	if(A_array[2] == 0) {
		n = B_array[2];
		t = B_array[1];
		s = B_array[0];
	} else {
		n = A_array[2];
		t = A_array[1];
		s = A_array[0];
	}
	
	
	System.out.println("gcd("+a+","+b+")"+" = "+n+" = "+a+"("+s+")+" +b +"("+t+")");	
	System.out.println("Goodbye");
	}
}
