package com.vito.bluemanager.messages;

import com.vito.bluemanager.BasePresenter;
import com.vito.bluemanager.BaseView;
import com.vito.bluemanager.data.Message;

import java.util.List;

/**
 * @Description: 契约
 * @Created by Zhangfeng on 2016/6/6.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/6 14:24
 * @ModifiedNotes:
 * @Version
 */
public interface MessagesContract {

    interface View extends BaseView<Persenter>{
        void showMessages();
        void updateShowMessages(List<Message> list);
        void dismissRefresh();
    }

    interface Persenter extends BasePresenter{
        List<Message> loadMessages();
        void refreshMessages();
    }

}
