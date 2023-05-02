package Section1;

import java.util.Scanner;

public class Code06 {

	static Polynomial [] polys = new Polynomial [100] ; // 다항식의 최대 개수 
	static int n = 0 ; // 입력되는 개수 
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner ( System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create")) { 
				char name = kb.next().charAt(0); // 공백 문자를 기준으로 문자열을 입력 받는 방법 
				
				//Polynomial p = new Polynomial();
				//p.name = name ; 
				//p.nTerms=0;
				
				//polys[n] = p;
				//n++;
				
				// 위와 같은 코드를 축약해서 아래와 같이 표현 가능 
				polys[n] = new Polynomial();
				polys[n].name = name ; 
				polys[n].terms = new Term[100]; // 문자열을 받는 참조 변수를 받을 수 있게 지정 
				polys[n].nTerms=0;
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
					// polys의 index 걕체를 받기 위해 ploys[index]
					addTerm( polys[index], c, e );
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
					int result = calcPolynomial ( polys[index] , x );
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
					printPolynomial( polys[index]) ; 
				}
			}
			else if
			(command.equals("exit")) 
				break;
		}
		kb.close();
	}


	private static int calcPolynomial(Polynomial p, int x) {
		int result = 0;
		for (int i = 0; i<p.nTerms; i++)
			result += calcTerm( p.terms[i] , x ) ;
		return result;
	}

	// 다항식을 계산하기 위해 만들어진 함수. 
	private static int calcTerm(Term term, int x) {
		return(int) (term.coef * Math.pow( x, term.expo ));
	}

	private static void printPolynomial(Polynomial p) {
		for (int i = 0 ; i < p.nTerms; i++) {
			printTerm( p.terms[i]) ;
			System.out.print("+");
		}
	}

	// 각각의 다항식을 출력하기 위해 만들어진 함수(메서드) 
	private static void printTerm(Term term) {
		System.out.print(term.coef + "x^" + term.expo) ; // -x^2 ==> -1 x^2 으로 출력 
	}

	private static void addTerm(Polynomial p, int c, int e) { // 항들이 입력 받을 떄 내림 차순으로 받을 수 있게 지정 
		// 차수 안에 이미 동일한 차수 있을 경우에는 더하기만 하면 되지만 -> 동일 차수가 없을 경우 추가 되어야 하는 2가치 case 존재 
		int index = findTerm(p , e) ;
		if (index != -1 ) {
			p.terms[index].coef += c; // -5x^3 +5x^3 -> 일떄는 0 이되므로 0으로 되기 떄문에 이걸 제외 시킬 수 있지만 이번에는 패스  
			//
		}
		else { // 새로 입력 받은 차수들의 위치 내림차순으로 비교 하는 코드 
			int i = p.nTerms-1;
			while (i >=0 && p.terms[i].expo < e ) {
				p.terms[i+1] = p.terms[i] ;
				i--;
			}// 내림 차순 된 다항식을 저장하는 매개변수 생성 후 저장 
			p.terms[i+1] = new Term();
			p.terms[i+1].coef = c;
			p.terms[i+1].expo = e;
			p.nTerms++;
		}
	}

	private static int findTerm(Polynomial p, int e) {
		//  polys 부분에서 입력 받은 동일 차수 유,무를 확인 하기 위한 부분 
		for (int i = 0 ; i < p.nTerms && p.terms[i].expo >=0 ; i++ )
			if (p.terms[i].expo == e )
				return i; 
		return -1;
	}

	// polys 객체에 내에 저장되어 있는 함수 중 name이 동일한 함수를 찾아서 i로 return 해주라는 코드 
	private static int find(char name) {
		for (int i=0 ; i<n ; i++)
			if (polys[i].name == name)	
				return i;
		return -1;
	}

}
