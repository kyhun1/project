package section2;

public class OrthoPolygon {
	public int n ; // 다각형의 꼭지점 개수
	public MyPoint2 [] vertices ; //꼭지점들의 집합 배열 생성
	
	// 다각형의 꼭지점 개수는 아직 확인 못하기에 -> 다각형의 개수를 받아서 추가하는 방식 
	public OrthoPolygon (int k) {
		n=0; // 실제 입력된 꼭지점 개수
		vertices = new MyPoint2 [k] ; 
	}
	
	public void addVertex( int x, int y )
	{
		vertices[n++] = new MyPoint2(x, y) ;
	}
	
	// x 좌표의 최대값을 확인 하기 위한 코드  
	public int maxX()
	{
		int max = vertices[0].x;
		for (int i= 1 ; i <n ; i++) {
			if (vertices[i].x > max)
				max = vertices[i].x;
		}
		return max;
	}
	// 다각형 내부에 좌표 유,무를 확인 하는 방법
	public boolean contains ( MyPoint2 p) {
		OrthoLine arrow = new OrthoLine ( p, new MyPoint2 ( maxX()+1 , p.y) ) ; 
		int count = 0;
		for (int i=0 ; i<n ; i++) {
			OrthoLine edge = new OrthoLine( vertices[i], vertices[ (i+1) % n ] );
			if ( arrow.intersects(edge))
				count++;
		}
		return ( count %2 == 1 ) ; // 2로나누었을떄 1이 남으면 홀수 이기때문에 밖으로 내보낸다.
	}
}
