package com.vito.bluemanager.services;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/15.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/15 16:59
 * @ModifiedNotes:
 * @Version
 */
public class BluetoothServer extends Thread{

    private final BluetoothServerSocket mBluetoothServerSocket;

    public BluetoothServer(BluetoothAdapter bluetoothAdapter){

        BluetoothServerSocket tmp = null;
        try {
            tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord("ttt",new UUID(1223,213));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mBluetoothServerSocket = tmp;
    }

    @Override
    public void run() {

        BluetoothSocket bluetoothSocket = null;
        //作为服务端循环等待连接
        while (true){
            try {
                bluetoothSocket = mBluetoothServerSocket.accept();
            } catch (IOException e) {
                break;
            }
            if(bluetoothSocket!=null){
                //todo 成功获取socket，进行数据的传输
            }
        }
    }

    /**
     * 取消该socket连接
     * @description: Created by Zhangfeng on 2016/6/15 17:16
     */
    public void cancel(){
        try {
            mBluetoothServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
