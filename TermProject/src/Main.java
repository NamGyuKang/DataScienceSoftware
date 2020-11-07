import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(1000);
		System.out.print("N 입력 >");
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		System.out.print("a,b 입력 >");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println();
		int min;
		int max;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		min = arr[a-1];
		max = arr[a-1];
		for(int i=a; i<=b; i++) {
			sum += arr[i-1];
			if(min >= arr[i-1]) {
				min = arr[i-1];
			}
			if(max <= arr[i-1]) {
				max = arr[i-1];
			}
		}
		System.out.println();
		System.out.println("최솟값: " + min);
		System.out.println("최댓값: " + max);
		System.out.println("합계: " + sum);
		
	    scan.close();
	}

}
