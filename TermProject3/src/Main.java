import java.util.Random;
import java.util.Scanner;

public class Main {
	// k에 대해 시작구간을 담은 kStart[i] 와 끝 구간을 담은 kEnd[i]의 차이를 계산하여 cnt[i]에 저장하고, 
	// 구간이 짧은 것 부터 나열되도록 합병정렬을 수행했습니다.
	// 그 결과 다음 구간이 이전 구간을 포함하는 경우가 많아지게 되었고,
	// 이전의 구간을 포함할 때 이미 구해놓은 sum값을 사용하는 메모이제이션 기법을 사용했습니다.
	
	static int[] tva;
	static int[] tvb;
	static int[] tvc;
	static void merge(int[] va, int[] vb,int[] cnt, int a, int b, int c) {
		int i=a, j=c+1, ka=a, kc = a, kb=a; 
		while(i<=c && j<=b) {
			if(cnt[i]<cnt[j]) {
				tvc[kc++] = cnt[i];
				tva[ka++] = va[i];
				tvb[kb++] = vb[i++];
			}else{
				tvc[kc++] = cnt[j];
				tva[ka++] = va[j];
				tvb[kb++] = vb[j++];
			}
		}
		
		while(i<=c) {
			tvc[kc++] = cnt[i];
			tva[ka++] = va[i];
			tvb[kb++] = vb[i++];
		}
		while(j<=b) {
			tvc[kc++] = cnt[j];
			tva[ka++] = va[j];
			tvb[kb++] = vb[j++];
		}
		
		
		for(int k=a;k<=b;k++) {
			cnt[k] = tvc[k];
			va[k] = tva[k];
			vb[k] = tvb[k];
		}
		
			
	}
	static void mergeSort(int[] va, int[] vb, int k) {
		tva = new int[k];
		tvb = new int[k];
		tvc = new int[k];
		int cnt[] = new int[k];
		for(int i=0; i<k; i++) {
			cnt[i] = vb[i]- va[i];
		}
		
		mergeSort(va,vb,cnt,0,k-1);
		
	}
	static void mergeSort(int[] va, int[] vb, int[] cnt, int a, int b) {
		if(a>=b) return;
		int c= (a+b)/2;
		mergeSort(va,vb,cnt,a,c);
		mergeSort(va,vb,cnt,c+1,b);
		merge(va,vb,cnt,a,b,c);
	}
	static void minmaxsum(int[] v, int n, int[] a, int[] b, int k, int[] rmin, int[] rmax, long[] rsum) {
		
		int min;
		int max;
		long[] sum = new long[k];
		int[] sumIdx = new int[k];
		int[] sumJdx = new int[k];
		int temp = -1;
		
		mergeSort(a,b,k);
		
		for(int i=0; i< a.length; i++) {	
			min = v[a[i]-1];
			max = v[a[i]-1];
			sum[i] = v[a[i]-1];
			
			sumIdx[i] = a[i]-1;
			sumJdx[i] = b[i]-1;
			
			if(i!=0 && (a[i] < sumIdx[i-1]) && (b[i] > sumJdx[i-1])) {
				temp  = i-1; 
			}
			if(i>0 && temp != -1){
				sum[i] = sum[temp];
				for(int j = a[i]; j<sumIdx[temp]; j++) {
					sum[i]+= v[j];
					if(min > v[j]) {
						min = v[j];
					}
					if(max < v[j]) {
						max = v[j];
					}
				}
				for(int j = sumJdx[temp]+1; j< b[i]; j++) {
					sum[i]+=v[j];
					if(min > v[j]) {
						min = v[j];
					}
					if(max < v[j]) {
						max = v[j];
					}
				}
			}else {
				for(int j=a[i]; j<b[i]; j++ ) {
					sum[i] += v[j];
					if(min > v[j]) {
						min = v[j];
					}
					if(max < v[j]) {
						max = v[j];
					}
				}
			}
			rmin[i] = min;
			rmax[i] = max;
			rsum[i] = sum[i];
			
		}
		
}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand  =new Random(10000);
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt();
		}
		int k = scan.nextInt();
		scan.close();
		int[] kStart = new int[k];
		int[] kEnd = new int[k];
		int[] min = new int[k]; 
		int[] max = new int[k];
		long[] sum = new long[k];
		
		for(int i=0; i< kStart.length; i++) {
			int x = rand.nextInt(N)+1;
			int y = rand.nextInt(N)+1;
			
			if(x < y) {
				kStart[i] = x;
				kEnd[i] = y;
			}else {
				kStart[i] = y;
				kEnd[i] = x;
			}
		}
		
		long timeStart = System.currentTimeMillis();
		minmaxsum(arr, N, kStart, kEnd, k, min, max, sum);
		long timeEnd = System.currentTimeMillis();
       
		System.out.println("소요시간: "+ (timeEnd-timeStart)+"ms.");		
	}

}
