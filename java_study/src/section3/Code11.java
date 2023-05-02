package section3;

import java.util.Scanner;

public class Code11 {

	// 모든 데이터 필드는 private으로 바꾸고 
	 private Polynomial3 [] polys = new Polynomial3 [100] ; // 다항식의 최대 개수 
	 private int n = 0 ; // 입력되는 개수 
	
	public void procssCommand()
	{
		Scanner kb = new Scanner ( System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) { 
				char name = kb.next().charAt(0); // 공백 문자를 기준으로 문자열을 입력 받는 방법 
				
				polys[n] = new Polynomial3();
				n++;
			}
			else if
			(command.equals("add")) { // add f 2 3  
				char name = kb.next().charAt(0);
				int index = find (name); // poly 안에 함수 생성 된 부분이 있기에 그것을 찾으라는 명령문 생성 
				if(index == -1 ) { // index == -1 값이 리턴되면 polys 안에 함숙가 존재 하지 않을 떄는 아래와 같이
					System.out.println("No such polynomial exists. ") ;
				}
				else { // find 부분에서 -1이 아닐 경우에는 아래와 같이 작동 -> f 이후 2와 3을 입력 받는 방법
					int c = kb.nextInt() ; 
					int e = kb.nextInt() ; 
					polys[index].addTerm( c, e );
				}
			}
			else if(command.equals("calc")) { 
				char name = kb.next().charAt(0);
				int index = find (name);
				if(index == -1 ) {
					System.out.println("No such polynomial exists. ") ;
				}
				else { 
					int x = kb.nextInt(); 
					int result =  polys[index].calcPolynomial( x );
					System.out.println(result);
				}
			}
			else if(command.equals("print")) { // 함수를 입력 받은 뒤 함수를 확인 후 존재 하지 않으면 -1 존재 하면 else 구문
				char name = kb.next().charAt(0);
				int index = find (name);
				if(index == -1 ) {
					System.out.println("No such polynomial exists. ") ;
				}
				else {
					polys[index].printPolynomial() ; 
				}
			}
			else if
			(command.equals("exit")) 
				break;
		}
		kb.close();
	}
		
	private int find(char name) {
		for (int i=0 ; i<n ; i++)
			if (polys[i].getName() == name)	
				return i;
		return -1;
	}
	
	public static void main(String []args)
	{
		Code11 app = new Code11();
		app.procssCommand();
	}

}
