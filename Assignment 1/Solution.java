import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    
    static double get_median(int[] temp, int d){
        int c = 0; 
        int l = 0;
        int r = 0;
        int mid = 0;;
        double median = 0;

        if (d % 2 == 0){
            mid = d/2;
        }
        else{
            mid = ((d / 2) + 1);
        }

        while(c < mid){
            c += temp[l];
            l++;
        }

        r = l;
        l--;

        if(c == mid || (d % 2) != 0 ){
            median = l;
        }

        else{
            while (temp[r] == 0){
                r++;
            }
            median = (l + r)/2;
        }

        
        return median;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notification = 0;
        int c = 0;
        double median = 0;
        int[] temp = new int[201];
       
        int trail = d;
        
        for (int i = 0; i < trail; i++) {
          temp[ expenditure[i] ]++;
        }

        while(trail < expenditure.length){
            median = get_median(temp, d);
            if ( expenditure[trail] >= (median * 2)){
                notification++;
            }
            temp[expenditure[c]]--;
            temp[expenditure[trail]]++;
            c++;
            trail++;
        }
       return notification;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
