package section2;

public class Polynomial2 {

	public char name ; // 다항식의 이름 
	public Term2 [] terms ; // 항들의 배열  
	public int nTerms =0 ; // 다항식을 이루고 있는 항의 갯수
	
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
			terms[i+1] = new Term2();
			terms[i+1].coef = c;
			terms[i+1].expo = e;
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
