package com.vito.bluemanager.services;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * @Description: 客户端
 * @Created by Zhangfeng on 2016/6/15.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/15 17:02
 * @ModifiedNotes:
 * @Version
 */
public class BluetoothClient extends Thread{

    private final BluetoothSocket mBluetoothSocket;
    private final BluetoothDevice mBluetoothDevice;
    private final BluetoothAdapter mBluetoothAdapter;

    public BluetoothClient(BluetoothDevice bluetoothDevice, BluetoothAdapter bluetoothAdapter){

        mBluetoothAdapter = bluetoothAdapter;
        BluetoothSocket tmp = null;
        mBluetoothDevice = bluetoothDevice;

        try {
            tmp = mBluetoothDevice.createRfcommSocketToServiceRecord(new UUID(123,131));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mBluetoothSocket = tmp;

    }

    @Override
    public void run() {
        // Cancel discovery because it will slow down the connection
        mBluetoothAdapter.cancelDiscovery();

        try {
            // Connect the device through the socket. This will block
            // until it succeeds or throws an exception
            mBluetoothSocket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and get out
            try {
                mBluetoothSocket.close();
            } catch (IOException closeException) { }
            return;
        }
        //todo 使用socket连接进行通信
    }

    public void cancel(){
        try {
            mBluetoothSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
