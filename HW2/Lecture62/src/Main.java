import java.util.Scanner;
public class Main {
	// 들어온 입력 문자열이 올바른 괄호 쌍을 가졌으면 true를 반환하고,
	// 그렇지 않으면 false를 반환합니다.
	public static boolean isValid(String str) {
		// stack을 위한 자료를 작성합니다.
		char[] stack = new char[1024];
		int top = -1;
		
		//for 루프를 돌면서 str 문자열 글자 하나씩 읽어나갑니다.
		for(int i=0; i<str.length(); i++)
		{
			// 1. i 인덱스에 해당하는 문자를 읽습니다.
			char ch = str.charAt(i);
			// 2. 괄호 열기 문자라면, 스택에 해당 문자를 push합니다.
			if(ch == '(' || ch=='[' || ch=='{')
			{
				stack[++top] = ch; // top++; stack[top]=ch;
			}
			// 3. 괄호가 닫기 문자라면, 스택에서 가장 위의 문자와 비교해보고,
			// 올바르면 문자 하나를 pop한다.
			else if(ch==')')
			{
				// 1. 만약 스택이 비어있다면 (top==-1), 이 뜻은 열기 괄호수보다 닫기 괄호가
				//많아졌다는 의미이므로 올바르지 않은 괄호쌍이 됩니다.
				//스택에 최상위 문자가 현재 검사하는 문자와 다른 종류라면, 역시 올바르지 않은
				//괄호쌍이 됩니다.
				if(top==-1 || stack[top] != '(')
				{
					return false;
				}
				// 2. 스택에서 최상위 아이템을 제거합니다.
				top--;
				
			}
			else if(ch=='}')
			{
				// 1. 만약 스택이 비어있다면 (top==-1), 이 뜻은 열기 괄호수보다 닫기 괄호가
				//많아졌다는 의미이므로 올바르지 않은 괄호쌍이 됩니다.
				//스택에 최상위 문자가 현재 검사하는 문자와 다른 종류라면, 역시 올바르지 않은
				//괄호쌍이 됩니다.
				if(top==-1 || stack[top] != '{')
				{
					return false;
				}
				// 2. 스택에서 최상위 아이템을 제거합니다.
				top--;
				
			}
			else if(ch==']')
			{
				// 1. 만약 스택이 비어있다면 (top==-1), 이 뜻은 열기 괄호수보다 닫기 괄호가
				//많아졌다는 의미이므로 올바르지 않은 괄호쌍이 됩니다.
				//스택에 최상위 문자가 현재 검사하는 문자와 다른 종류라면, 역시 올바르지 않은
				//괄호쌍이 됩니다.
				if(top==-1 || stack[top] != '[')
				{
					return false;
				}
				// 2. 스택에서 최상위 아이템을 제거합니다.
				top--;
				
			}
		}
		
		// 3. 스택이 비어있다면(top==-1) true 반환. 그렇지 않으면 false 반환.
		return top==-1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 반복횟수를 입력받습니다.
		int n = scan.nextInt();
		
		// for 루프를 이용해서 n번 반복 수행합니다.
		for(int i=0;i<n;i++)
		{
			String abc = scan.next();
			//	문자열이 올바르면 YES를 올바르지 않다면 NO를 출력합니다.
			if(isValid(abc)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		
		scan.close();
	}

}
