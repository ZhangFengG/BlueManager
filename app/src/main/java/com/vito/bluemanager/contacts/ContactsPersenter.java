package com.vito.bluemanager.contacts;

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

    public ContactsPersenter(ContactsContract.View view){
        mView = view;
        mView.setPersenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
