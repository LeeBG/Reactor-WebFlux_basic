package reactorex01;

import java.util.Iterator;

import org.reactivestreams.Subscription;

// 구독 정보
public class MySubScription implements Subscription {
	
	private final MySubscriber subscriber;
	private Iterator<Integer> it;
	
	public MySubScription(MySubscriber s,Iterable<Integer> its) {
		System.out.println("2. MySubScription - 구독정보 생성");
		this.subscriber = s;
		this.it = its.iterator();
	}

	public void request(long n) { //2 - 2개씩 구독 시작
		System.out.println("4.MySubScription - "+n+"개씩 구독 시작");
		// N개씩 구독자에게 돌려주는 로직이 필요하다.
		while(n>0) {
			if(it.hasNext()) {
				subscriber.onNext(it.next()); //1,2,3,4,5...
			}else {
				subscriber.onComplete(); //구독 완료
				break;
			}
			n--;
		}
		System.out.println("===========================================");
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}
