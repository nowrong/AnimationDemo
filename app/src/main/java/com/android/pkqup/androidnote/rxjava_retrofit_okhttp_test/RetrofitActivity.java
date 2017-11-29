package com.android.pkqup.androidnote.rxjava_retrofit_okhttp_test;

import android.os.Bundle;
import android.os.Environment;

import com.android.pkqup.androidnote.R;
import com.android.pkqup.androidnote.abase.BaseActivity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by LiuCun on 2017/11/24.<br>
 * Describe
 */

public class RetrofitActivity extends BaseActivity {

    private FirstService firstService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        firstService = RetrofitUtils.getInstance().getFirstService();

        uploadSingleFile();

        uploadMultiFile();
    }


    // Retrofit单文件上传
    private void uploadSingleFile() {
        File file = new File(Environment.getExternalStorageDirectory(), "icon.png");
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part photo =
                MultipartBody.Part.createFormData("photos", "icon.png", photoRequestBody);

        Call<User> call = firstService.registerUser(photo, RequestBody.create(null, "abc"),
                RequestBody.create(null, "123"));
    }

    // Retrofit多文件上传
    private void uploadMultiFile() {
        File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        RequestBody photo = RequestBody.create(MediaType.parse("image/png"), file);
        Map<String,RequestBody> photos = new HashMap<>();
        photos.put("photos\"; filename=\"icon.png", photo);
        photos.put("username",  RequestBody.create(null, "abc"));

        Call<User> call = firstService.registerUser(photos, RequestBody.create(null, "123"));
    }
}
