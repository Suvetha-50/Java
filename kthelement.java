import java.util.Scanner;

public class kthelement {
    public static int find(int[] arr, int k){
        int temp=0;
        for(int i=0;i<arr.length;i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        if (k > arr.length) {
            return  -1;
        }
        return arr[k-1];
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int res=find(arr,k);
        System.out.println(res);
    }
}
