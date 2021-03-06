package reactorex01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

//<T> 구독할 데이터의 타입
public class MySubscriber implements Subscriber<Integer>{

	private Integer size=1000000000; 	//nobounded
	private Subscription s;
	private Integer temp = size;
	
	public void onSubscribe(Subscription s) {
		this.s=s;
		System.out.println("3. MySubscriber - 구독정보가 생성된 것을 subscriber가 돌려받음"); //구독이 시작 되었다는 것이다.
		//subscriber가 구독을 응답 완료한다. 자동으로 때려줌
		
		//신문줘!!
		s.request(size); //내가 하루에 읽은 수 있는 글자수에 한계가 있다.(내가 소화할 수 있는 양만큼 요청) - 백프레셔(BackPressor)
	}

	// 데이터를 돌려 받는 함수
	public void onNext(Integer t) {
		System.out.println("onNext() - 신문"+t);
		size --; //1
		if(size == 0) {
			size = temp;
			s.request(size);
		}
	}

	public void onError(Throwable t) {
		
	}

	public void onComplete() {
		System.out.println("신문 다 받음");
	}

}
