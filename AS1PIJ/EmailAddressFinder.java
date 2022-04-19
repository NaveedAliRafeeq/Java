//package com.bham.pij.assignments.assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

\\A program to find all the email addresses in a corrupt database

public class EmailAddressFinder {
    
    private static ArrayList<String> emailAddresses;
    
    public static void main(String[] args) {
        emailAddresses = new ArrayList<String>();
        EmailAddressFinder eaf = new EmailAddressFinder();
        eaf.run();
        System.out.println("Email addresses found: " + emailAddresses.size());
    }
    
    public void run() {
        
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("corrupteddb"));
     
            String input = "";
           
            PrintWriter pw = new PrintWriter("eaf");
            
            while ((input = reader.readLine()) != null) {
                
                input = input.trim();
                
                ArrayList<String> temp = new ArrayList<String>();
                
                temp = findEmailAddresses(input);             
                
                for (String t: temp) {
                    emailAddresses.add(t);
                }                
            }
            
            pw.close();
            reader.close();
        }
        
        catch(IOException e) {
            e.printStackTrace();
        }        
    }

    public ArrayList<String> findEmailAddresses(String input) {
        
        ArrayList<String> list = new ArrayList<String>();

	String[] delChar = //This array contains all the characters that do not make up part of any email

{"!","£","$","%","^","&","*","(",")","-","+","=","{","}","[","]",":",";","'","~","#","|","<",">",",","?","/","`","¬",
"\"", "\\"," "};          


	String[] domains = {".com",".net",".uk",".de",".jp",".ro"};

	int z = 0; int z1 = 0; boolean z2 = true; int z3 = 0; int z4 = 0;

	while (z < domains.length){ //The purpose of this loop is to increment through each domain and find the index of each one
		int domIndex = input.indexOf(domains[z]);
		
		do {
			z1 = input.indexOf(domains[z], ++domIndex); //Finds the index of the next domain in the database  
			if (z1 == -1){ //When the indexOf method reaches the end of the string it returns -1, therefore I used it to find out when it has reached the last domain
				break;
			}else {
				do { //This loop works backwords from the domain to an invalid value once it reaches this value it takes the string of the value after the invalid one adds the domain to it and adds it to the list
					z4 = domIndex - (z3 + 1);
					String z7 = input.substring(z4, domIndex);
					for (int c = 0;  c < delChar.length; c++){ //This for loop runs through the delChar array to see of any of those invalid characters are contained within the substring
						if (z7.contains(delChar[c])){
							z7 = (input.substring(z4 + 1, domIndex) + domains[z]);
							list.add(z7);
							input = input.replace(z7, "");
							System.out.println(z7);
							z4 = -1;
						}else {
							continue;}
					}
					z3++;
				}while (z4 > 0)	;
				z1 = domIndex;}
		}while (z2 = true);
	z++;}

        return list;
    }
}
