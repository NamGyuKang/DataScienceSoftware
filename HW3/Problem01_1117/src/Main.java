import java.util.Scanner;
import java.util.Random;

class Queue<E>{
	int front;     
	int rear;     
	E[] data;     
	int size;      

	Queue(){
		front = rear = 0;
		size = 1024;		
		data = (E[])new Object[size];
	}
	
	public void add(E v) {
		data[rear] = v;
		rear = (rear+1)%size;
	}
	
	public void remove() {
		data[front]=null;
		front = (front+1)%size;
	}
	public E peek() {
		return data[front];
	}
	
	public boolean empty() {
		return front==rear;
	}
	
	public int size() {
		return (rear-front+size)%size;
	}
}

class Stack<E> {
	    E[] data;  
		int top;   
		
		Stack(){
			data = (E[])new Object[1024];
			top = -1;
		}
		public void push(E v) {
			top++;
			data[top]= v;
		}
		
		public void pop() {
			top--;
		}
		
		public E top() {
		    return data[top];
		}
		
		public boolean empty() {
			return top == -1;
		}
		
		public int size() {
			return top+1;
		}
	}


public class Main {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue();
		Stack<Integer> stack = new Stack();
		Random rand = new Random(100);
		
		System.out.print("숫자 n을 입력하시오 >");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		for(int i=0; i<n; i++) {
			q.add(rand.nextInt(10001));
		}
		

		for(int i=0; q.empty()!=true; i++) {
			int val = (int)q.peek();
			q.remove();
			while((stack.top!= -1) && (val>=(int)stack.top())) {
			    q.add(stack.top());
				stack.pop();
			}
				stack.push(val);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(stack.top());
			stack.pop();
		}
	}
}
