package com.vito.bluemanager.messages;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.vito.bluemanager.R;
import com.vito.bluemanager.data.Message;
import com.vito.bluemanager.editmessage.EditMessageActivity;

import java.util.List;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/6.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/6 11:01
 * @ModifiedNotes:
 * @Version
 */
public class MessagesFragment extends Fragment implements MessagesContract.View, SwipeRefreshLayout.OnRefreshListener{

    private MessagesContract.Persenter mPersenter;
    private MsgListAdapter mMsgListAdapter;
    private ListView mListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public MessagesFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMsgListAdapter = new MsgListAdapter(mPersenter.loadMessages());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(container!=null){
            View view = inflater.inflate(R.layout.fragment_messages, null);
            initViews(view);
            return view;
        }else {
            return null;
        }
    }

    private void initViews(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.messages_refresh);
        mSwipeRefreshLayout.setColorSchemeColors(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mListView = (ListView) view.findViewById(R.id.messages_lv);
        mListView.setAdapter(mMsgListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EditMessageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPersenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPersenter.unsubscribe();
    }

    @Override
    public void showMessages() {

    }

    @Override
    public void updateShowMessages(List<Message> list) {
        mMsgListAdapter.notifyDataSetChanged(list);
    }

    @Override
    public void dismissRefresh() {
        if(mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void setPersenter(MessagesContract.Persenter persenter) {
        mPersenter = persenter;
    }

    @Override
    public void onRefresh() {
        mPersenter.refreshMessages();
    }

    private static class MsgListAdapter extends BaseAdapter{

        private List<Message> mMessageList;

        public MsgListAdapter(List<Message> messageList) {

            mMessageList = messageList;
        }

        @Override
        public int getCount() {
            return mMessageList.size();
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
            if(convertView==null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messages, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.messsga_title_tv);
            textView.setText(mMessageList.get(position).getUserName());
            textView = (TextView) convertView.findViewById(R.id.messsga_content_tv);
            textView.setText(mMessageList.get(position).getMsg());
            return convertView;
        }

        public void notifyDataSetChanged(List<Message> messageList){
            mMessageList = messageList;
            notifyDataSetChanged();
        }
    }
}
