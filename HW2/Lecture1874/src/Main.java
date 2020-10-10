 import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ster = new StringBuilder();
		int size = sc.nextInt();
		int[] ary = new int[size];
		int[] ary_result = new int[size];
		int cnt=0;
		int[] stack = new int[size];
		int top = -1;
		for(int k=0; k<size; k++)
		{
			ary[k] = sc.nextInt();
		}
		sc.close();
		
		int idx =0;
		
		
		for(int j=0; j<size; j++)
		{
			stack[++top] = j+1;
			ster.append("+\n");
					
			while(top!=-1 && stack[top] == ary[idx])
			{
				ary_result[cnt++] = stack[top--];
                ster.append("-\n");
		        idx++;
			}
			
		}
		
		if(top!=-1) {
			System.out.println("NO");
		}else {
			System.out.println(ster);
		}
    }
}
