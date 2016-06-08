package com.vito.bluemanager.editmessage;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/8.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/8 11:16
 * @ModifiedNotes:
 * @Version
 */
public class EditMessagePersenter implements EditMessageContract.Persenter{

    private EditMessageContract.View mEditFragment;

    public EditMessagePersenter(EditMessageContract.View view){
        mEditFragment = view;
        view.setPersenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
