package section3;

public class Term3 { // 하나의 항 계수 / 차수 

//	public int coef ;
//	public int expo ;
//	
//	아래와 같이 private으로 변경으러 하면 Polynomial3 클래스에서 오류가 발생한다. 
//  private은 Term3 클래스 내부에서만 사용할 수 있게 만들기 떄문이다.  
	
	private int coef ; // 계수에 추가를 해줘야 하기 떄문에 
	// refactor -> encapsulation feld // public -> private으로 변하면서 getCoef / setCoef 메서드 생성
	// public가 private으로 변경이 되면 모든 클래스를 찾아다니면서 변경을 
	private int expo ; 
	
	public Term3(int c, int e) // 계수 / 차수의 초기값  
	// 셍성자 앞의 public 
	{
		setCoef(c); 
		expo = e;
	}
	
	// 계수는 변경 되는 부분이 아니기 떄문에 읽 수 있게만 하기 위해 getExpo 메서드만 사용
	public int getExpo() // getter method
	{
		return expo;
	}
	// 위와 같은 메서드를 만들으면 private으로 된 객체를 다른 클래스에서 사용할 수 있게 변경을 해준 부분
	// getExpo 메서드를 이용하여 다른 클래스에서 expo 부분을 읽을 수 있지만 쓰기는 불가능하다.
	// 그 이유는 private으로 권한 부여로 인해서
	// 하지만 public 으로 객체를 생성할 경우에는 읽기 / 쓰기가 가능하다.
	
	public int calcTerm( int x ) {
		return(int) (getCoef() * Math.pow( x, expo ));
	}
	
	public void printTerm() {
		System.out.print(getCoef() + "x^" + expo) ; 
	}

	// public -> private으로 변경을 하면서 
	// private 객체를 다른 클래스에서 읽을 수 있게 해주는 매서드는 getCoef 
	// 다른 클래스에서 쓸 수 있게 해주는 메서드는 setCoef 메서드 부분이다.
	public int getCoef() { // getter, accesstor
		return coef;
	}

	public void setCoef(int coef) { // setter, mutator
		this.coef = coef;
	}
	
}
