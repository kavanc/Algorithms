import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        int count = 0;
        int swap = 0;

        int a[] = arr.clone();
        int b[] = arr.clone();
        int c[] = arr.clone();

        Arrays.sort(a);
        int x= b.length - 1;

        for(int j = 0; j < b.length; j++){
            b[j] = a[x - j];
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            hash.put(arr[i], i);
            hash1.put(arr[i], i);
        }
        

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != a[i]){
                int temp = hash.get(a[i]);
                hash.put(a[i], i);
                hash.put(arr[i], temp);
                int temp1 = 0;
                temp1 = arr[i];
                arr[i] = a[i];
                arr[temp] = temp1;
                count++;
            }
            if (c[i] != b[i]) {
                int temp = hash1.get(b[i]);
                hash1.put(b[i], i);
                hash1.put(c[i], temp);
                int temp1 = 0;
                temp1 = c[i];
                c[i] = b[i];
                c[temp] = temp1;
               swap++;
            } 
        }
        
       return Math.min(count, swap);
    }
        
 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
