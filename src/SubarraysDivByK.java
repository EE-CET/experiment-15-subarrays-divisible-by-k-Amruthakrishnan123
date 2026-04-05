import java.util.*;

public class SubarraysDivByK {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n and k
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Read array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Frequency array for remainders
        int[] freq = new int[k];
        freq[0] = 1;

        int prefixSum = 0;
        int count = 0;

        // Count subarrays
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            int remainder = prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            count += freq[remainder];
            freq[remainder]++;
        }

        // Print result
        System.out.println(count);

        sc.close();
    }
}