package com.star.uibestpractice;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends ArrayAdapter<Msg> {

    private int resource;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Msg msg = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
        }

        LinearLayout leftLayout = (LinearLayout) convertView.findViewById(R.id.left_layout);
        TextView leftMsg = (TextView) convertView.findViewById(R.id.left_msg);

        LinearLayout rightLayout = (LinearLayout) convertView.findViewById(R.id.right_layout);
        TextView rightMsg = (TextView) convertView.findViewById(R.id.right_msg);

        if (msg.getType() == Msg.TYPE_RECEIVED) {
            leftLayout.setVisibility(View.VISIBLE);
            rightLayout.setVisibility(View.GONE);
            leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT) {
            leftLayout.setVisibility(View.GONE);
            rightLayout.setVisibility(View.VISIBLE);
            rightMsg.setText(msg.getContent());
        }

        return convertView;
    }
}
