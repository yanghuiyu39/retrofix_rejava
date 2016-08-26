package com.example.yhy.retrofix_rejava;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yhy.retrofix_rejava.model.HttpResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    public static final String API_URL = "https://zhuanlan.zhihu.com";
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //      uploadFile();
                uploadFile();
            }
        });
       // getData();

    }

//    private void getData(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//
//                .build();
//        ZhuanLanApi api = retrofit.create(ZhuanLanApi.class);
//
//        Call<ZhuanLanAuthor> call = api.getAuthor("qinchao");
//
//            // 请求数据，并且处理response
//        call.enqueue(new Callback<ZhuanLanAuthor>() {
//            @Override
//            public void onResponse(Call<ZhuanLanAuthor> call, Response<ZhuanLanAuthor> response) {
//                System.out.println("name： " + response.getClass().getName());
//            }
//
//            @Override
//            public void onFailure(Call<ZhuanLanAuthor> call, Throwable t) {
//
//            }
//
//        });
//
//    }

    public void uploadFile() {
        String path1 = Environment.getExternalStorageDirectory() + File.separator + "test.png";
        String path2 = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
        ArrayList<String> pathList = new ArrayList<>();
        pathList.add(path1);
        pathList.add(path2);

        Map<String, RequestBody> bodyMap = new HashMap<>();
        if(pathList.size() > 0) {
            for (int i = 0; i < pathList.size(); i++) {
                File file = new File(pathList.get(i));
                bodyMap.put("file"+i+"\"; filename=\""+file.getName(), RequestBody.create(MediaType.parse("image/png"),file));
            }
        }

        APIWrapper.getInstance().uploadMultipleTypeFile("jdsjlzx",bodyMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HttpResponse<List<String>>>() {
                    @Override
                    public void onCompleted() {
                        Snackbar.make(fab, "ok", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(fab, "e", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }

                    @Override
                    public void onNext(HttpResponse<List<String>> response) {

                     Snackbar.make(fab, "onNext", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show(); }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
