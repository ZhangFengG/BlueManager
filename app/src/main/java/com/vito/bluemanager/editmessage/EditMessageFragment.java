package com.vito.bluemanager.editmessage;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.vito.bluemanager.R;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/8.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/8 11:16
 * @ModifiedNotes:
 * @Version
 */
public class EditMessageFragment extends Fragment implements EditMessageContract.View{

    private EditMessageContract.Persenter mEditMessage;
    private ListView mListView;
    private ImageButton mSendButton;
    private EditText mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container!=null){
            View view = inflater.inflate(R.layout.fragment_editmessage, null);
            initViews(view);
            return view;
        }
        return null;
    }

    private void initViews(View view) {
        mListView = (ListView) view.findViewById(R.id.content_lv);
        mSendButton = (ImageButton) view.findViewById(R.id.send_ib);
        mEditText = (EditText) view.findViewById(R.id.content_et);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "发送", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setPersenter(EditMessageContract.Persenter persenter) {
        mEditMessage = persenter;
    }
}
