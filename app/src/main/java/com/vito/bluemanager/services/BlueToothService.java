package com.vito.bluemanager.services;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

import com.vito.bluemanager.data.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 16:42
 * @ModifiedNotes:
 * @Version
 */
public class BlueToothService {

    private BluetoothAdapter mBluetoothAdapter;
    private static BlueToothService mBlueToothService;

    private BlueToothService(){
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null){
            //不支持蓝牙
        }
    }

    public static BlueToothService getInstance(){
        if(mBlueToothService==null){
            mBlueToothService = new BlueToothService();
        }
        return mBlueToothService;
    }

    public void enableBlueToothForResult(Activity activity, int requestCode){
        if (!mBluetoothAdapter.isEnabled()){
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public List<Contact> getBondedDevices(){
        List<Contact> list = new ArrayList<Contact>();
        Set<BluetoothDevice> set = mBluetoothAdapter.getBondedDevices();
        for (BluetoothDevice bluetoothDevice : set) {
            Contact contact = new Contact();
            contact.setName(bluetoothDevice.getName());
            contact.setMac(bluetoothDevice.getAddress());
            list.add(contact);
        }
        return list;
    }

    public boolean isBTEnable(){
        return mBluetoothAdapter.isEnabled();
    }
}
