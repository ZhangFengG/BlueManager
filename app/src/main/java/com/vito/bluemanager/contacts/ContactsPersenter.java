package com.vito.bluemanager.contacts;

import com.vito.bluemanager.data.Contact;
import com.vito.bluemanager.services.BlueToothService;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 11:05
 * @ModifiedNotes:
 * @Version
 */
public class ContactsPersenter implements ContactsContract.Persenter {

    private ContactsContract.View mView;
    private BlueToothService mBlueToothService;
    private CompositeSubscription mCompositeSubscription;

    public ContactsPersenter(ContactsContract.View view){
        mView = view;
        mView.setPersenter(this);
        mBlueToothService = BlueToothService.getInstance();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeSubscription.clear();
    }

    @Override
    public void landContacts() {

        Subscription subscription = rx.Observable.just(mBlueToothService
        ).filter(new Func1<BlueToothService, Boolean>() {
            @Override
            public Boolean call(BlueToothService blueToothService) {
                return blueToothService.isBTEnable();
            }
        }).observeOn(Schedulers.io()
        ).map(new Func1<BlueToothService, List<Contact>>() {
            @Override
            public List<Contact> call(BlueToothService blueToothService) {
                return mBlueToothService.getBondedDevices();
            }
        }).observeOn(AndroidSchedulers.mainThread()
        ).subscribe(new Subscriber<List<Contact>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Contact> contacts) {
                mView.showContacts(contacts);
            }
        });
        mCompositeSubscription.add(subscription);
    }
}
