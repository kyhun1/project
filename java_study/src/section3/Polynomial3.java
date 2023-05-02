package section3;

public class Polynomial3 {

	private char name ; 
	private Term3 [] terms ; 
	private int nTerms ; 

	public Polynomial3()
	{
		nTerms = 0;
		terms = new Term3 [100];
	}
	
	public Polynomial3 ( char name )
	{
		this.name = name ;
		nTerms = 0;
		terms = new Term3 [100];
	}
	
	public char getName() //getter
	{
		return name;
	}
	
	public void addTerm( int c, int e) {  
		int index = findTerm( e ) ;
		if (index != -1 ) {
			terms[index].setCoef(terms[index].getCoef() + c); // -5x^3 +5x^3 -> 일떄는 0 이되므로 0으로 되기 떄문에 이걸 제외 시킬 수 있지만 이번에는 패스  
			//
		}
		else { // 새로 입력 받은 차수들의 위치 내림차순으로 비교 하는 코드 
			int i = nTerms-1;
			while (i >=0 && terms[i].getExpo() < e ) {
				terms[i+1] = terms[i] ;
				i--;
			}// 내림 차순 된 다항식을 저장하는 매개변수 생성 후 저장 
			terms[i+1] = new Term3( c, e );
			nTerms++;
		}
	}

	private int findTerm( int e ) { 
		for (int i = 0 ; i < nTerms && terms[i].getExpo() >=0 ; i++ )
			if (terms[i].getExpo() == e )
				return i; 
		return -1;
	}

	public int calcPolynomial( int x) {
		int result = 0;
		for (int i = 0; i<nTerms; i++)
			result += terms[i].calcTerm( x ) ;
		return result;
	}

	public void printPolynomial() { // 다항식을 화면에 출력하는 부분 
		for (int i = 0 ; i < nTerms; i++) {
			terms[i].printTerm( ) ;
			System.out.print("+");
		}
		System.out.println();
	
	}
}
