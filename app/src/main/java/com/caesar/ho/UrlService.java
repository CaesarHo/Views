package com.caesar.ho;

import android.graphics.Bitmap;

import com.caesar.ho.bean.DailyYeildsInfo;
import com.caesar.ho.bean.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by demi on 2017/3/13.
 */

public interface UrlService {

    @GET("bd_logo1_31bdc765.png")
    Call<Bitmap> getImage();
    @GET("{id}/daily-yields?")
    Call<ResponseData<DailyYeildsInfo>> getDatas(@Path("id") String id , @Query("type") String type);
}
