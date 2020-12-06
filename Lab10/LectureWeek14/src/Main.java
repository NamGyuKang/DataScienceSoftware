//	Lecture 14 ������׷����� ���� ū ���簢�� ���� ���ϱ�
//	������׷��� ������ �׷����� �׸� ���Դϴ�.
//	�̶� ��������� ������׷� �׷������� ���� ���� ���簢�� ���̸� ���ϴ� ������
//	�������� �˰����� ��ǥ�� �����Դϴ�.
//	�Է��� ������ ��(N)�� �Է¹ް� �� ������ ������ �Է¹޽��ϴ�.
//	{ 3, 1, 4, 3 } �� ������ ���� ����� �Է�����
//	4 3 1 4 3 �� �Է¹޽��ϴ�.
//	����� ���� ū ���簢�� ���̸� ����ϸ� �˴ϴ�.
//	
import java.util.Scanner;
public class Main {
	
	//���������� ���� histo �Լ�
	// { 3, 1, 4, 3 }
	// b = a+k
	// c = a+int(k/2)
	// 2 2
	// 4 3
	//7, 2 1 4 5 1 3 3
	static int histo(int[] v, int a, int b) {
		
		int c= (a+b)/2;
		int sum = 0;
		int sum2 = 0;
		int final_result = 0;
		int adx = c;
		int bdx = c+1;
		int hight=0;
		if (b-a+1 ==0) return 0;
		if (a==b) return v[a];
				
		sum = histo(v, a, c);
		sum2 = histo(v, c+1, b);
		
		if(sum > sum2) 	final_result = sum;
		else final_result = sum2;
		
		if (v[adx]>v[bdx]) hight = v[bdx];
		else hight = v[adx];
		
		if(final_result < hight*2) final_result = hight*2; 

		while(a < adx || b > bdx) {
			//System.out.println("F2"+final_result+"hight" + hight+"b"+bdx+"a"+adx);
			
			if(a < adx && (b==bdx || v[adx-1] > v[bdx+1])) {
				adx--;
				if(hight > v[adx]) {
					hight = v[adx];
				}
				
			}else {
				bdx++;
				if(hight > v[bdx]) {
					hight = v[bdx];
				}
			}
			
			if(final_result < hight*((bdx-adx+1))) {
				final_result = hight*((bdx-adx+1));
			}
			
		}
		
		return final_result;
	}
	//	���� ū ���簢�� ���̸� ��ȯ�մϴ�.
	//	n: ������ ��
	//	v: n���� ���õ��� ����
	//	��ȯ: ���簢���� ����
	static int histo(int[] v, int n) {
        if(n==0) return 0;
        
		return histo(v,0,n-1);
	}

	
	
	public static void main(String[] args) {
		// ��ĳ�� ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	������ �� �Է�
		int n = scan.nextInt();
		//	������ ������ �迭 ����
		int[] v = new int[n];
		//	n���� ������ �Է¹޾� �迭 v�� ����.
		for(int i=0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		// ���� ū ���簢���� ���� ���
		int r = histo(v, n);
		//	���
		System.out.println(r);
		scan.close();

		
	}

}