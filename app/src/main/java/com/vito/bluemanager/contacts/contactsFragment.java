package com.vito.bluemanager.contacts;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.vito.bluemanager.R;
import com.vito.bluemanager.data.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/12.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/12 11:05
 * @ModifiedNotes:
 * @Version
 */
public class ContactsFragment extends Fragment implements ContactsContract.View{

    private ContactsContract.Persenter mPersenter;
    private ListView mListView;
    private List<Contact> mContactList;
    private ContactsAdapter mContactsAdapter;

    public ContactsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContactList = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setMac("1021520");
        contact.setName("大客户");
        mContactList.add(contact);
        mContactsAdapter = new ContactsAdapter(mContactList);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container!=null){
            View view = inflater.inflate(R.layout.fragment_contacts, null);
            initViews(view);

            return view;
        }
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPersenter.landContacts();
    }

    private void initViews(View view) {
        mListView = (ListView) view.findViewById(R.id.contact_lv);
        mListView.setAdapter(mContactsAdapter);
    }

    @Override
    public void setPersenter(ContactsContract.Persenter persenter) {
        mPersenter = persenter;
    }

    @Override
    public void showContacts(List<Contact> dataSet) {
        mContactsAdapter.notifyContactsChange(dataSet);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPersenter.unsubscribe();
    }

    private static class ContactsAdapter extends BaseAdapter{

        private List<Contact> contactList;

        public ContactsAdapter(List<Contact> contacts){
            contactList = contacts;
        }

        @Override
        public int getCount() {
            return contactList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
            TextView name = (TextView) convertView.findViewById(R.id.contact_name_tv);
            TextView id = (TextView) convertView.findViewById(R.id.contact_id_tv);
            name.setText(contactList.get(position).getName());
            id.setText(contactList.get(position).getMac());
            return convertView;
        }

        public void notifyContactsChange(List<Contact> contacts){
            contactList = contacts;
            notifyDataSetChanged();
        }
    }
}
