package reactorex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> 발행할 데이터의 타입
public class MyPublisher implements Publisher<Integer> {//일단 숫자를 Publisher하겠다.(영상을 Publisher하겠다고 하면 Object)

	// 데이터베이스 - 정보를 가지고 있음.
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	// 이 데이터는 지금은 고정이지만 만약 데이터베이스에 붙여놓으면 
	// DB에 있는 데이터면 동적으로 변할 것이다.
	 
	
	//구독
	public void subscribe(Subscriber<? super Integer> s) {	//Publisher의 책임 = 구독(함수)
		System.out.println("1. MyPublisher - 구독");
		s.onSubscribe(new MySubScription((MySubscriber)s,its));	//구독정보에 Publisher가 얼만큼의 정보를 가지고 있는지
	}	
}
