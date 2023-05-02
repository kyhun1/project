package Section1;

public class Code1_2 {

	public static void main(String[] args) {
		Person1 first; // Person1 데이터 타입 / first : 데이터 객체 -> 참조변수 
		first = new Person1 () ; // 배열을 호출하는 모습과 비슷하다. -> 클래스 타입의 객체를 생성하는 모습(object)_

		first.name = "John" ; // first 객체의 name에 john을 Person1 클래스 타입에 집어 넣어라 
		first.number = "0104565235";

		System.out.println("Name : " + first.name + " , Number : " + first.number);

		Person1 second = first; // first 변수를 second에 first변수 주소를 저장 first = second 
								// first = second 동일 객체를 이용하기 떄문에 동일 정보 출력
		second.name = "Tom";    // second.name 부분만 변경을 했지만 Tom으로 변경이 된걸 확인 
								// first=second 동일한 객체 주소를 참조 하고 있기 떄문에 second.name를 추가했어도
								// Tom이 생성 된것을 확인 할 수 있다. 
		
		System.out.println("Name : " + first.name + " , Number : " + first.number);
		
		Person1 [ ] members = new Person1 [100] ; // 배열을 선언 하는 방법 
		members[0] = first;
		members[1] = second;
		System.out.println("Name : " + members[0].name + " , Number : " + members[0].number);
		System.out.println("Name : " + members[1].name + " , Number : " + members[1].number);
		// 위에 객체는 하나 이지만 -> first/second/ member 전체가 공유 하고 있다. 
		
		//members[2].name = "David" ;  // members[2]는 객체 주소를 넣어 줘야 하는데 현재 객체 주소를 넣어주지 않아서 오류가 발생 
		//members[2].number = "550565456";
		
		// 위의 코드와 다른 점은 객체의 주소를 참조 할 수 있는 참조 변수를 먼저 지칭 하고 안하고의 차이점 
		members[2] = new Person1() ; 
		members[2].name = "David" ; 
		members[2].number = "550565456";
		
		System.out.println("Name : " + members[2].name + " , Number : " + members[2].number);
		
	}

}

//int [] number = new int[8] -> number는 프리미티브 변수가 x -> 배열의 주소를 참조하는 참조 변수 이다.
// new int[8] -> new로 시작하는 참조 변수 이지만 각각의 배열은 프리미티브 변수 이다.
//클래스
//Person1 [] members = new Person1 [8] -> members는 Person1 자체가 프리미티브 변수가 x 떄문에 참조 변수 이다.
//new Person1 으로 인해 배열이 생성되고 그에 따른 주소를 members에 주소가 참조가 된다. 
//new Person1 각각의 배열의 칸은 Person1 형태 이기 떄문에 Person1 타입도 참조 변수 이다.
// int-> 프리미티브 변수 O/ int[] -> 프리미티브 변수 x 
// 프리미티브 타입 : int/ double / float ....

// 값에 의한 호출 : 배열 
// 실제 배열을 참조 변수로 사용하기 떄문에 
