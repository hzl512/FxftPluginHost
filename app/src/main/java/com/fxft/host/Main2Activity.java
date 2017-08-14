package com.fxft.host;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.fxft.host.adapter.PluginApkAdapter;
import com.fxft.host.data.ApiConnection;
import com.fxft.host.data.request.BaseRequest;
import com.fxft.host.data.response.PluginApkList;
import com.qihoo360.replugin.RePlugin;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends Activity {

    @BindView(R.id.listView)
    ListView listView;
    PluginApkAdapter mAdapter=new PluginApkAdapter(this,null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        listView.setAdapter(mAdapter);

        BaseRequest baseRequest=new BaseRequest();
        baseRequest.paging=true;
        baseRequest.page_no=1;
        baseRequest.page_size=10;
        ApiConnection.getPluginApi().getPluginApkList(4,baseRequest).enqueue(new Callback<PluginApkList>() {
            @Override
            public void onResponse(Call<PluginApkList> call, Response<PluginApkList> response) {
                if (response.isSuccess()){
                    if (response.body().getData()!=null){
                        mAdapter.update(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<PluginApkList> call, Throwable t) {
                Toast.makeText(Main2Activity.this,"response onFailure",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PluginApkList.DataBean model=mAdapter.getItem(position);
                RePlugin.startActivity(Main2Activity.this, RePlugin.createIntent(model.getPluginName(), model.getPluginClass()));

            }
        });

    }

}
