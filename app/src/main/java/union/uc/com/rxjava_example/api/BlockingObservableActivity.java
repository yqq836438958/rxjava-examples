package union.uc.com.rxjava_example.api;


import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import union.uc.com.rxjava_example.base.APIBaseActivity;

/**
 * Created by wangli on 4/12/16.
 */
public class BlockingObservableActivity extends APIBaseActivity {

  @Override
  protected void onRegisterAction(ActionRegistery registery) {
    registery.add("forEach", new Runnable() {
      @Override
      public void run() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().forEach(new Action1<Integer>() {
          @Override
          public void call(Integer integer) {
            log(integer);
          }
        });
      }
    });
    registery.add("first", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().first();
        log(i);
      }
    });
    registery.add("firstOrDefault", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().firstOrDefault(5000);
        log(i);
      }
    });
    registery.add("last", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().last();
        log(i);
      }
    });
    registery.add("lastOrDefault", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().lastOrDefault(5000);
        log(i);
      }
    });
    registery.add("mostRecent", new Runnable() {
      @Override
      public void run() {
        Iterator<Integer> itr = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().mostRecent(5000).iterator();
        while (itr.hasNext()) {
          log(itr.next());
        }
      }
    });
    registery.add("next", new Runnable() {
      @Override
      public void run() {
        Iterator<Integer> itr = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().next().iterator();
        while (itr.hasNext()) {
          log(itr.next());
        }
      }
    });
    registery.add("latest", new Runnable() {
      @Override
      public void run() {
        Iterator<Integer> itr = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().latest().iterator();
        while (itr.hasNext()) {
          log(itr.next());
        }
      }
    });
    registery.add("single", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().single();
        log(i);
      }
    });
    registery.add("singleOrDefault", new Runnable() {
      @Override
      public void run() {
        Integer i = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().singleOrDefault(3000);
        log(i);
      }
    });
    registery.add("toFuture", new Runnable() {
      @Override
      public void run() {
        Future<Integer> future = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().toFuture();
        try {
          log(future.get());
        } catch (InterruptedException e) {
          e.printStackTrace();
          log(e);
        } catch (ExecutionException e) {
          e.printStackTrace();
          log(e);
        }
      }
    });
    registery.add("toIterable", new Runnable() {
      @Override
      public void run() {
        Iterator<Integer> itr = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().toIterable().iterator();
        while (itr.hasNext()) {
          log(itr.next());
        }
      }
    });
    registery.add("getIterator", new Runnable() {
      @Override
      public void run() {
        Iterator<Integer> itr = Observable.create(new Observable.OnSubscribe<Integer>() {
          @Override
          public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onCompleted();
          }
        }).subscribeOn(Schedulers.newThread()).toBlocking().getIterator();
        while (itr.hasNext()) {
          log(itr.next());
        }
      }
    });
  }
}