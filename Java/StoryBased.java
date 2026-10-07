/*Problem Statement: Operation Blackout — The Rogue TokensThe Cyber Crime & Counter-Terrorism Division (CC-CTD) was investigating a series of high-profile security breaches at national bank vaults across the country. At each crime scene, investigators discovered a terminal displaying 9 active physical keycards, each engraved with a unique positive integer code.During the attacks, two victims holding specific keycards suffered lethal high-voltage feedback triggered by the security grid. Forensic data analysts uncovered a horrifying pattern engineered by the rogue hacker group: among the 9 keycards present, the numerical sum of the 2 malicious cards always equals exactly 100. The remaining 7 keycards are completely untampered, safe passkeys.This attack pattern has spread to multiple secure locations, and the CC-CTD has issued an emergency order to all field agents: whenever a bank terminal reports 9 unique keycard codes, agents must immediately isolate the 2 malicious cards before the system overrides.As the division’s chief programmer, you must write a script that accepts all 9 unique positive keycard integers, identifies the 2 malicious cards whose sum is 100, and outputs the 7 safe passkey numbers in their exact original order of discovery.Constraints$1 \le Num < 100$All 9 input numbers are guaranteed to be unique.Exactly one pair among the 9 numbers adds up to 100.Input FormatA single line containing nine integers between 1 and 99 (inclusive) separated by a single space, read from standard input (STDIN).Output FormatPrint exactly seven lines of output to standard output (STDOUT) — the safe keycard numbers printed in the exact order they appeared in the input.*/


//Brute force TC-O(n^2)
/*import java.util.HashSet;
import java.util.Scanner;

public class StoryBased {
    
    public void ans(int []arr){
        int p1 = 0;
    int p2 = 0;
    
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == 100){
                    p1 = i ;
                    p2 = j;
                    i=arr.length 
                    break;
                };
            }

        }


        for(int i=0;i<arr.length;i++){
            if(i!=p1 && i!=p2){
                System.out.println(arr[i]);
            }
        }

    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int arr[]  = new int[9];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        
        StoryBased m = new StoryBased();
        m.ans(arr);
        


    }
}
*/

//optimal TC- O(n)
import java.util.HashSet;
import java.util.Scanner;

public class StoryBased {
    
    public void ans(int []arr){
        int p1 = -1;
        int p2 = -1;
        HashSet <Integer> sc = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            
            sc.add(arr[i]);
        }
        
        for(int i=0;i<arr.length;i++){
            int complement = 100 - arr[i];

            if(complement != arr[i] && sc.contains(complement)){
                p1=arr[i];
                p2=complement;
            }

        }


        for(int i=0;i<arr.length;i++){
            if(arr[i]!=p1 && arr[i]!=p2){
                System.out.println(arr[i]);
            }
        }

    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int arr[]  = new int[9];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        
        StoryBased m = new StoryBased();
        m.ans(arr);
        


    }
}
