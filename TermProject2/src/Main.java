import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand  =new Random(1000);
		
		System.out.print("N 입력 >");
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		System.out.print("K 입력 >");
		int k = scan.nextInt();
		scan.close();
		int[] kStart = new int[k];
		int[] kEnd = new int[k];
		int temp = 0;
		int[] min = new int[k]; 
		int[] max = new int[k];
		int[] sum = new int[k];
		
		for(int i=0; i< kStart.length; i++) {
			kStart[i] = rand.nextInt(N);
			kEnd[i] = rand.nextInt(N);
			if(kEnd[i] < kStart[i]) {
				temp = kStart[i];
				kStart[i] = kEnd[i];
				kEnd[i] = temp;
			}
		}
		/*
		for(int i=0; i<N; i++) {
			System.out.print("데이터 출력: ");
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("--------------------");
		for(int i=0; i<k; i++) {
			System.out.println((i+1)+"번째 구간 시작: "+ kStart[i]+" 구간 끝"+kEnd[i]);
		}
		*/
		long timeStart = System.currentTimeMillis();

		for(int i=0; i< kStart.length; i++) {
			sum[i] = 0;
			min[i] = arr[kStart[i]];
			max[i] = arr[kStart[i]];
			
			for(int j=kStart[i]; j<=kEnd[i]; j++ ) {
				sum[i] += arr[j];
				
				if(min[i] >= arr[j]) {
					min[i] = arr[j];
				}
				if(max[i]<=arr[j]) {
					min[i] = arr[j];
				}
			}
		}
		
		long timeEnd = System.currentTimeMillis();
        /*
		System.out.println("--------------------");		
		for(int i=0; i<sum.length; i++) {
			System.out.println("합계: " + sum[i]);
			System.out.println("최솟값: "+ min[i]);
			System.out.println("최댓값: "+max[i]);
			System.out.println("--------------------");
			}
		*/
		System.out.println("소요시간: "+ (timeEnd-timeStart)+"ms.");		
	}

}
