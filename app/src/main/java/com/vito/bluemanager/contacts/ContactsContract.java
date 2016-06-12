package com.vito.bluemanager.contacts;

import com.vito.bluemanager.BasePresenter;
import com.vito.bluemanager.BaseView;
import com.vito.bluemanager.data.Contact;

import java.util.List;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 11:03
 * @ModifiedNotes:
 * @Version
 */
public interface ContactsContract {

    interface View extends BaseView<Persenter>{

        void showContacts(List<Contact> dataSet);

    }

    interface Persenter extends BasePresenter{

        void landContacts();

    }
}
