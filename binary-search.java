import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kimji
 */
public class lab1 {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        
        FileWriter txtSaver = new FileWriter("C:\\Users\\kimji\\Documents\\NetBeansProjects\\Lab1\\numbers.txt");
        
        for (int i=1; i<=1000000; i++){
            try { 
                txtSaver.write((r.nextInt(1000000)+1) + "\n");
            } catch (IOException e) { 
            System.out.println("An error occurred.");
            e.printStackTrace(); 
            }
        }
        txtSaver.close();
               
        int[] numbers = new int[1000000];

        Scanner s = new Scanner(new File("C:\\Users\\kimji\\Documents\\NetBeansProjects\\Lab1\\numbers.txt"));
        
        for (int i=0; i<numbers.length; i++){
            numbers[i] = s.nextInt();
        }
        s.close();
        
        //sequential search
        int searchFor = numbers[r.nextInt(1000000)];
        //int searchFor = 0;
        System.out.println("Sequential search for " + searchFor);
        for (int i=0; i<numbers.length; i++){
            System.out.println("cell number " +i + " has integer " + numbers[i]);
            if (numbers[i] == searchFor)
                break;
        }
        
        //binary search
        System.out.println("\nBinary search for " + searchFor);
        Arrays.sort(numbers);
        int leftPointer = 0, rightPointer = numbers.length-1, cellsVisitCtr =0; 
        while (leftPointer <= rightPointer) { 
            int midPointer = leftPointer + (rightPointer-leftPointer)/2; 
            if (numbers[midPointer] == searchFor){
                System.out.println(searchFor + " found in cell number " + midPointer + " after visiting " + cellsVisitCtr + " cells.");
                break;
            }
            if (numbers[midPointer] < searchFor) {
                System.out.println("cell number " + midPointer + " has integer " + numbers[midPointer]);
                leftPointer = midPointer + 1; 
            }
            else {
                System.out.println("cell number " + midPointer + " has integer " + numbers[midPointer]);
                rightPointer = midPointer - 1;
            }
            cellsVisitCtr++;
        }
        if (leftPointer > rightPointer)
            System.out.println(searchFor + " not found after visiting " + (cellsVisitCtr-1) + " cells.");
    }    
}