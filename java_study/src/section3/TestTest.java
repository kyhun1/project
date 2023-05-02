package section3;

public class TestTest {

	public static void main(String[] args) {
		Test test1 = new Test();
		
		// tset1에 있는 객체 맴버 이기 떄문에 오류가 발생하지 않는다. 
		// 하지만 s / print2 부분은 class 안에 있을 뿐 Test안의 객체가 아니므로 오류가 발생하는 것을 확인 가능
//		test1.t = 10;
//		
//		test1.s = 100;
//		
//		test1.print1();
//		
//		test1.print2();
		
		test1.t = 10; 
		// test라는 객체
		test1.s = 100;
		//Test.print1();
		test1.print2();
		
		// 새로운 객체 하나더 생성 
		Test test2 = new Test() ; 
		test2.print1();
	    test2.print2();
		
	}

}
