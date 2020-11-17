import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		int[] q = new int[n];
		int front=0;
        int rear = 0;
        
		for(int i=0; i<n; i++) {
			String[] first=null;
			try {
				first = br.readLine().split(" ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(first[0].contains("push")) {
				q[rear] = Integer.parseInt(first[1]);
                rear = (rear+1)%n;
			}			
			else if(first[0].equals("pop")) {
				if(front==rear) System.out.println(-1);
				else {
				System.out.println(q[front]);
				front = (front+1)%n;
				}
			}
			else if(first[0].equals("size")) {
				System.out.println((rear-front+n)%n);
			}
			else if(first[0].equals("empty")) {
				if(front==rear) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}

			}
			else if(first[0].equals("front")) {
				if(front==rear) System.out.println(-1);
				else System.out.println(q[front]);
			}
			else if(first[0].equals("back")) {
				if(front==rear) System.out.println(-1);
				else System.out.println(q[rear-1]);
			}
		}

	}

}