package com.vito.bluemanager.contacts;

import com.vito.bluemanager.data.Contact;
import com.vito.bluemanager.services.BluetoothManager;

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
    private BluetoothManager mBluetoothManager;
    private CompositeSubscription mCompositeSubscription;

    public ContactsPersenter(ContactsContract.View view){
        mView = view;
        mView.setPersenter(this);
        mBluetoothManager = BluetoothManager.getInstance();
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

        Subscription subscription = rx.Observable.just(mBluetoothManager
        ).filter(new Func1<BluetoothManager, Boolean>() {
            @Override
            public Boolean call(BluetoothManager blueToothService) {
                return blueToothService.isBTEnable();
            }
        }).observeOn(Schedulers.io()
        ).map(new Func1<BluetoothManager, List<Contact>>() {
            @Override
            public List<Contact> call(BluetoothManager blueToothService) {
                return mBluetoothManager.getBondedDevices();
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
