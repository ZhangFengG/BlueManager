package com.vito.bluemanager.contacts;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vito.bluemanager.R;
import com.vito.bluemanager.services.BluetoothManager;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 10:55
 * @ModifiedNotes:
 * @Version
 */
public class ContactsActivity extends AppCompatActivity{

    private BluetoothManager mBluetoothManager;
    private ContactsPersenter mContactsPersenter;

    private static final int REQUEST_BT_ENABLE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        init();

    }

    private void init() {
        mBluetoothManager = BluetoothManager.getInstance();
        FragmentManager fragmentManager = getFragmentManager();
        ContactsFragment contactsFragment = (ContactsFragment) fragmentManager.findFragmentById(R.id.content_fragment);
        if(contactsFragment==null){
            contactsFragment = new ContactsFragment();
            fragmentManager.beginTransaction().add(R.id.content_fragment, contactsFragment).commit();
        }
        mContactsPersenter = new ContactsPersenter(contactsFragment);
        mBluetoothManager.enableBlueToothForResult(this, REQUEST_BT_ENABLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_BT_ENABLE == requestCode){
            if(requestCode == RESULT_OK){
                mContactsPersenter.landContacts();
            }
        }
    }
}
