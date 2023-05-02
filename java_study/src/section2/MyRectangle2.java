package section2;

public class MyRectangle2 {

	public MyPoint2 lu;
	public int width;
	public int height;
	
	// 값이 4개 필요하다 
	public MyRectangle2 ( int x, int y , int w, int h) {
		lu = new MyPoint2 ( x, y ) ;
		width = w;
		height = h;
	}
	// 두개의 생성자를 가질 수 있다. 
	public MyRectangle2 ( MyPoint2 p , int w, int h) {
		lu = p;
		width = w;
		height = h;
	}
	
	// 면적순으로 나열 하는거 
	public int calcArea( )
	{
		return width * height;
	}
	
	public String toString() // toString 부분은 다른 이름으로 변경 하지 않는게 좋다. -> 내부 클래스를 string으로 표현하기 위해
	{
		return "(" + lu.x + ", " + lu.y + ") "+ width + " " + height;
	}
	
	
}
