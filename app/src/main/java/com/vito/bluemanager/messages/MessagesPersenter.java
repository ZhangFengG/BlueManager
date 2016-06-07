package com.vito.bluemanager.messages;

import com.vito.bluemanager.data.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/6.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/6 15:08
 * @ModifiedNotes:
 * @Version
 */
public class MessagesPersenter implements MessagesContract.Persenter{

    public MessagesContract.View mMessagesView;

    public MessagesPersenter(MessagesContract.View view){
        mMessagesView = view;
        view.setPersenter(this);
    }

    @Override
    public List<Message> loadMessages() {
        List<Message> list = new ArrayList<>();
        Message msg = new Message();
        msg.setId(1);
        msg.setMsg("测试");
        msg.setUserName("ZF");
        list.add(msg);
        return list;
    }

    @Override
    public void refreshMessages() {
        List<Message> list = loadMessages();
        mMessagesView.updateShowMessages(list);
        mMessagesView.dismissRefresh();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
