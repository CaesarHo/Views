package com.caesar.ho.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caesar.ho.R;
import com.caesar.ho.UrlService;
import com.caesar.ho.bean.DailyYeildsInfo;
import com.caesar.ho.bean.ResponseData;
import com.caesar.ho.factory.ProfitsConverterFactory;
import com.caesar.ho.view.ProfitsChartView;
import com.caesar.ho.view.TabContainer;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by demi on 2017/5/16.
 */

public class ProfitsChartFragment extends Fragment {
    private TabContainer tab;
    private ProfitsChartView chart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profit_chart, container, false);
        tab = (TabContainer) view.findViewById(R.id.tab);
        chart = (ProfitsChartView) view.findViewById(R.id.chart);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDatas();
    }


    public void getDatas() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fe-api.zixuangu8.com/stock-portfolios/")
                .addConverterFactory(new ProfitsConverterFactory())
                .client(okHttpClient)
                .build();
        UrlService service = retrofit.create(UrlService.class);
        Call<ResponseData<DailyYeildsInfo>> call = service.getDatas("520","LAST_ALL");
        call.enqueue(new Callback<ResponseData<DailyYeildsInfo>>() {
            @Override
            public void onResponse(Call<ResponseData<DailyYeildsInfo>> call, Response<ResponseData<DailyYeildsInfo>> response) {
                // JSONObject js =new JSONObject(json);
                chart.setData(response.body().getInfo());
            }

            @Override
            public void onFailure(Call<ResponseData<DailyYeildsInfo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
