package com.example.yhy.retrofix_rejava;

import com.example.yhy.retrofix_rejava.model.HttpResponse;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

/**
 * Created by yhy on 2016/8/26.
 */
public interface ZhuanLanApi{
        @GET("/api/columns/{user} ")
        Call<ZhuanLanAuthor> getAuthor(@Path("user") String user);

//        @Multipart
//        @POST("v1/public/core/?service=user.updateAvatar")
//        Observable<HttpResponse<List<String>>> uploadMultipleTypeFile(@Part("data") String des, @PartMap Map<String,RequestBody> params);

}
