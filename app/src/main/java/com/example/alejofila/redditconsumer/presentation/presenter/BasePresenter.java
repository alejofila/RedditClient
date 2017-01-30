package com.example.alejofila.redditconsumer.presentation.presenter;

import rx.Scheduler;
import rx.internal.util.SubscriptionList;

/**
 * Created by alejofila on 28/01/17.
 */

abstract class BasePresenter  {
    Scheduler mainThreadScheduler;
    protected BasePresenter(Scheduler mainThreadScheduler){
        this.mainThreadScheduler = mainThreadScheduler;

    }
    SubscriptionList subscriptionList = new SubscriptionList();
    public  void onStart(){
    }
    public void  onStop(){
        subscriptionList.unsubscribe();
    }

}
