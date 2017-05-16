package com.ybxcc.testinysx.mytestapp.testClass;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ybx on 2017/5/9.
 */

public class RxJavaTestClass {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String setIn = scanner.next();


        Observable observable;
        Observer<String> observer;
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                System.out.print("输出是：" + s + "\n");
            }
        };


//        observable = Observable.just("1111", "2222").repeat(7);


//        observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext(setIn);
//            }
//        });


//        List<String> str = new ArrayList<>();
//        str.add("1");
//        str.add("2");
//        str.add("3");
//        str.add("4");
//        observable = Observable.from(str);


        observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("1", "2", "3");
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String o) {
                return o + "dd";
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.immediate())
        ;


//        observable = Observable.interval(1, TimeUnit.SECONDS);


//        observable = Observable.range(13,10);


//        observable = Observable.timer(2, TimeUnit.SECONDS);

//        observable.subscribe(observer);


        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.e("rxjava", "输出是：" + o + "\n");
                System.out.print("输出是：" + o + "\n");
            }
        });



    }
}
