package com.example.yhy.retrofix_rejava;



import com.example.yhy.retrofix_rejava.model.HttpResponse;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

public class APIWrapper extends RetrofitUtil {

    private static APIWrapper mAPIWrapper;

    public APIWrapper() {
    }

    public static APIWrapper getInstance() {
        if (mAPIWrapper == null) {
            mAPIWrapper = new APIWrapper();
        }
        return mAPIWrapper;
    }

    public Observable<HttpResponse<List<String>>> uploadMultipleTypeFile(String des, Map<String,RequestBody> params) {
        return getAPIService().uploadMultipleTypeFile(des, params);
    }

}
