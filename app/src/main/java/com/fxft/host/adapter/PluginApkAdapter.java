package com.fxft.host.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.fxft.host.R;
import com.fxft.host.data.response.PluginApkList;

import java.util.List;

/**
 * Created by hzl520 on 2017/8/14.
 */
public class PluginApkAdapter extends SimpleBaseAdapter<PluginApkList.DataBean> {

    public PluginApkAdapter(Context context, List<PluginApkList.DataBean> data) {
        super(context, data);
    }

    @Override
    public int getItemResource() {
        return R.layout.list_item;
    }

    @Override
    public View getItemView(int position, View convertView, ViewHolder holder) {
        PluginApkList.DataBean model=data.get(position);
        TextView textPluginTitle=holder.getView(R.id.textPluginTitle);
        TextView textPluginDetail=holder.getView(R.id.textPluginDetail);
        textPluginTitle.setText(model.getPluginTitle());
        textPluginDetail.setText(model.getPluginDetail());
        return convertView;
    }
}
