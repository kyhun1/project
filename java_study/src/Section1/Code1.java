package Section1;

public class Code1 {

	public static void main(String[] args) {
		// Person1 : 사용자 정의 타입 -> 상요자가 정의한 새롱누 타입
		Person1 first; // Person1 데이터 타입 / first : 데이터 객체 -> 참조변수 
		first = new Person1 () ; // 배열을 호출하는 모습과 비슷하다. -> 클래스 타입의 객체를 생성하는 모습(object)_
								 // int [] data ; 
					 	 	 	 // data = new int [100];
		
		first.name = "John" ; // first 객체의 name에 john을 Person1 클래스 타입에 집어 넣어라 
		first.number = "0104565235";
		
		System.out.println("Name : " + first.name + " , Number : " + first.number);
		
		Person1 [ ] members = new Person1 [10] ; // 배열을 선언 하는 방법 
		members[0] = first ; 
		members[1] = new Person1();
		members[1].name = "David" ; 
		members[1].number = "0105035353" ;
		
		System.out.println("Name : " + members[1].name + " , Number : " + members[1].number);
		
		
	}

}

// Person1 a; 변수의 타입이 된다. -> Person1은 int x / double y 와 같은 변수의 타입과 동일하다. 
 // Person1 타입에 a를 저장한다.  int x ; x=100;

// int count = 0 ;
// 프리미티 타입 : count 라는 이름의 변수를 만들고 그 ""안에"" 정수 값이 저장된다. 변수 안에 데이터 타입이 저장
// 
// 사람이름과 번호는 new로 새로운 객체 안에 저장이 되는것이 프리미티브 타입과 클래스(사용자정의변수)와의 차이가 존재한다. 
// 반드시 new를 이용하여 새로운 객체 안에 값들이 저장된다. 즉 주소(참조)를 저장한다.
// 포인터 / 주소는 C언어 

// int a 
// person1 first;
// a와 first 변수의 차이가 존재 한다. 
// 모든프리미티브 타입의 변수는 보통 변수 이다 -> 그 변수 자체에 값이 저장이 된다. 
// 프리키티 타입이 아닌 모든 변수는 참조 변수이다. -> 참조 변수 안에 사람과 번호는 new 명령으로 따로 만들어아 햐고 new 입력된 값들은
// 객체의 주소를 저장 한다. = 객체의 주소를 참조한다. (name/number)