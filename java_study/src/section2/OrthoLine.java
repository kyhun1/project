package section2;

public class OrthoLine {
	public MyPoint2 u; 
	public MyPoint2 v;
	
	public OrthoLine (MyPoint2 p, MyPoint2 q)
	{
		u = p;
		v = q;
		if  (p.x > q.x || p.x == q.x && p.y > q.y)
			swap () ;
	}
	
	public void swap() {
		MyPoint2 tmp = u ; 
		u = v ;
		v = tmp;
	}
	
	// 좌표값 4개를 받는 방법 
	public OrthoLine (int x1, int y1, int x2, int y2)
	{
		u = new MyPoint2 (x1, y1);
		v = new MyPoint2 (x2, y2);
	}
	
	// 수직 선분인지 아닌지 확인 하는 방법
	public boolean isVertical ()
	{
		return (u.x == v.x); // 입력 자체에 문제가 없다. 
	}
	
	// 교차하는지 안하는지 알아보기 위한 구간
	public boolean intersects ( OrthoLine other )
	{
		if (isVertical () && !other.isVertical( )) // 내가 수직선 이면서 수평선인 경우
			return ( other.u.x < u.x && other.v.x > u.x && u.y < other.u.y && v.y > other.u.y);
		else if (isVertical () && other.isVertical( ))  // 내가 수평 선이고 수직 선인 경우
			return ( other.u.y < u.y && other.v.y > u.y && u.x < other.u.x && v.x > other.u.x);
		else // 위의 두 경우가 아닌 경우에는 false  
			return false;
	}
}
