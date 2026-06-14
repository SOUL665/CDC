// Date - 14/06/26

// Answer - 1

import java.util.Scanner;

class SegmentTree {
    class Node {
        int sum;         
        int prefixMax;   
        int suffixMax;   
        int maxSum;

        Node(int sum, int prefixMax, int suffixMax, int maxSum) {
            this.sum = sum;
            this.prefixMax = prefixMax;
            this.suffixMax = suffixMax;
            this.maxSum = maxSum;
        }
    }

    Node[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new Node[4 * n];
        build(arr, 0, 0, n - 1); 
    }
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            int value = arr[start];
            tree[node] = new Node(value, value, value, value);
        }

else{
    int mid = start + (end - start) / 2;
    build(arr, 2 * node + 1, start, mid);
    build(arr, 2 * node + 2, mid + 1, end);
    tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
  }
}

private Node merge(Node left, Node right){
    int sum = left.sum + right.sum;
    int prefixMax = Math.max(left.prefixMax, left.sum + right.prefixMax);
    int suffixMax = Math.max(right.suffixMax, right.sum + left.suffixMax);
    int maxSum = Math.max(Math.max(left.maxSum, right.maxSum), left.suffixMax + right.prefixMax);
    return new Node(sum, prefixMax, suffixMax, maxSum);
}

public int query(int l, int r){
    if(n == 0) return 0;
    return queryUtil(0, 0, n - 1, l, r).maxSum;
}

private Node queryUtil(int node, int start, int end, int l, int r){
    if(l > end || r < start){
        return new Node(0, -100000, -100000, -100000);
    }
    if(l <= start && end <= r){
        return tree[node];
    }
    int mid = start + (end + start) / 2;
    Node left = queryUtil(2 * node + 1, start, mid, l, r);
    Node right = queryUtil(2 * node + 2, mid + 1, end, l, r);
    
    if (left.maxSum == -100000) return right;
    if (left.maxSum == -100000) return left;
    
    return merge(left, right);
}
}

class Solution {
    public int maxSubArray(int[] nums) {
        SegmentTree segmentTree = new SegmentTree(nums);
        return segmentTree.query(0, nums.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println(solution.maxSubArray(nums));
        
        scanner.close();
    }
}

// Answer - 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int B = (int) Math.sqrt(n) + 1;
        int numBlocks = (n + B - 1) / B;
        int[][] sortedBlocks = new int[numBlocks][];
        long[][] suffixSums = new long[numBlocks][];
        
        for (int b = 0; b < numBlocks; b++){
            build(b, arr, B, n, sortedBlocks, suffixSums);
        }
        
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k < q; k++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if(type == 1){
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken());
                arr[x] = y;
                build(x / B, arr, B, n, sortedBlocks, suffixSums);
            }
            else if(type == 2){
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int t = Integer.parseInt(st.nextToken());
                long sum = 0;
                int startBlock = l / B;
                int endBlock = r / B;
                
                if (startBlock == endBlock){
                    for (int i = l; i <= r; i++){
                        if(arr[i] > t) sum += arr[i];
                    }
                }
                else {
                    int endOfStartBlock = (startBlock + 1) * B - 1;
                    for (int i = l; i <= endOfStartBlock; i++){
                        if(arr[i] > t) sum += arr[i];
                    }
                    
                    for (int b = startBlock + 1; b < endBlock; b++){
                        int[] sorted = sortedBlocks[b];
                        int left = 0, right = sorted.length - 1;
                        int idx = sorted.length;
                        
                        while (left <= right){
                            int mid = left + (right - left) / 2;
                            if(sorted[mid] > t){
                                idx = mid;
                                right = mid - 1;
                            }
                            else{
                                left = mid + 1;
                            }
                        }
                        sum += suffixSums[b][idx];
                    }
                    
                    int startOfEndBlock = endBlock * B;
                    for(int i = startOfEndBlock; i <= r; i++){
                        if(arr[i] > t) sum += arr[i];
                    }
                }
                sb.append("Total stock above threshold: ").append(sum).append("\n");
            }
        }
        System.out.print(sb);
    }
    
    private static void build(int b, int[] arr, int B, int n, int[][] sortedBlocks, long[][] suffixSums){
        int start = b * B;
        int end = Math.min(start + B, n);
        int len = end - start;
        sortedBlocks[b] = new int[len];
        System.arraycopy(arr, start, sortedBlocks[b], 0, len);
        Arrays.sort(sortedBlocks[b]);
        
        suffixSums[b] = new long[len + 1];
        for (int i = len - 1; i >= 0; i--){
            suffixSums[b][i] = suffixSums[b][i + 1] + sortedBlocks[b][i];
        }
    }
}
