package section2;

public class Polynomial3 {

	public char name ; // 다항식의 이름 
	public Term3 [] terms ; // 항들의 배열  
	public int nTerms ; // 다항식을 이루고 있는 항의 갯수
	
	// 매개변수를 받지 않은 생성자 
	public Polynomial3()
	{
		nTerms = 0;
		terms = new Term3 [100];
	}
	
	// 매개변수를 받는 생성자 -> 기존 코드 내에서 함수를 지정하는 char 변수를 이동했을 때 매개변수를 받는 방법 
	// char name 변수와 polynomial name 과 의 충돌이 발생하기 떄문에 객체 명을 변경 해도 되고 
	// this.name = name 으로 칭해도 된다. 
	public Polynomial3 ( char name )
	{
		this.name = name ;
		nTerms = 0;
		terms = new Term3 [100];
	}
	
	public void addTerm( int c, int e) {  
		int index = findTerm( e ) ;
		if (index != -1 ) {
			terms[index].coef += c; // -5x^3 +5x^3 -> 일떄는 0 이되므로 0으로 되기 떄문에 이걸 제외 시킬 수 있지만 이번에는 패스  
			//
		}
		else { // 새로 입력 받은 차수들의 위치 내림차순으로 비교 하는 코드 
			int i = nTerms-1;
			while (i >=0 && terms[i].expo < e ) {
				terms[i+1] = terms[i] ;
				i--;
			}// 내림 차순 된 다항식을 저장하는 매개변수 생성 후 저장 
			terms[i+1] = new Term3( c, e );
			nTerms++;
		}
	}

	public int findTerm( int e ) {
		for (int i = 0 ; i < nTerms && terms[i].expo >=0 ; i++ )
			if (terms[i].expo == e )
				return i; 
		return -1;
	}

	public int calcPolynomial( int x) {
		int result = 0;
		for (int i = 0; i<nTerms; i++)
			result += terms[i].calcTerm( x ) ;
		return result;
	}

	public void printPolynomial() {
		for (int i = 0 ; i < nTerms; i++) {
			terms[i].printTerm( ) ;
			System.out.print("+");
		}
		System.out.println();
	
	}
}
