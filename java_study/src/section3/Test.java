package section3;

public class Test {

	static int s = 0;
	int t = 0 ;
	
	public static void print1()
	{
		System.out.println("s = " + s) ; 
//		System.out.println("t = " + t ); -> non static 에서 에러 발생 확인 
	// t는 non-static 이기에 오브젝트 멤버 이기 떄문에 test 안에 따로 오브젝트를 생성해야 오류가 발생하지 않는다.
    // 하지만 s는 static으로 main 함수 안에 클래스 변수 이기 떄문에 오류가 발생하지 않는다.
	}
	
	public void print2()
	{
		System.out.println("s = " + s);
		System.out.println("t = " + t);
		// 객체를 생성하지 않았지만 print2 에서는 객체가 있기 때문에 오류가 발생하지 않는다. 
	}
	
	public static void main (String [] args)
	{

		s = 100;
//		t = 100;
		print1();
//		print2();
		
		// test 타입의 객체 선언 필요
		Test test1 = new Test();
		test1.t = 100;
		test1.print2();
		
	}
	
	
}
