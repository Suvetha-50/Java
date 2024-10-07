import java.util.Scanner;

public class search {
    public static int searching(int[] arr,int x){
        //arr=[1,2,3,4,5]
        if(arr.length==0){
            return 0;
        }
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == x) {
                return i;
            }
        }
                return -1;

    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int x=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int res=searching(arr,x);
        System.out.println(res);
    }
}
