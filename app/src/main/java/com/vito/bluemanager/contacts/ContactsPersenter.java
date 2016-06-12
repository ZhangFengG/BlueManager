package com.vito.bluemanager.contacts;

import com.vito.bluemanager.data.Contact;
import com.vito.bluemanager.services.BlueToothService;

import java.util.List;

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

    public ContactsPersenter(ContactsContract.View view){
        mView = view;
        mView.setPersenter(this);
        mBlueToothService = BlueToothService.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void landContacts() {
        List<Contact> list = mBlueToothService.getBondedDevices();
        mView.showContacts(list);
    }
}
