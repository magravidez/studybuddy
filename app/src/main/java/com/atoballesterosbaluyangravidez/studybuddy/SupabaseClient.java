package com.atoballesterosbaluyangravidez.studybuddy;

import okhttp3.*;
import java.io.IOException;

public class SupabaseClient {
    private static final String SUPABASE_URL = "https://rcoptignzxetamnxdrap.supabase.co";
    private static final String SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJjb3B0aWduenhldGFtbnhkcmFwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDA1NjIxMDgsImV4cCI6MjA1NjEzODEwOH0.XZXoyDCr7M6ixuXZ8MEo5a1EkZdhEXD9Ygoq5r8WQko"; // Replace with your key
    private static final OkHttpClient client = new OkHttpClient();

    public static void signUp(String email, String password, String redirectUrl, Callback callback) {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{\"email\":\"" + email + "\",\"password\":\"" + password + "\", \"redirect_to\": \"" + redirectUrl + "\"}"
        );

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/auth/v1/signup")
                .addHeader("apikey", SUPABASE_API_KEY)
                .addHeader("Authorization", "Bearer " + SUPABASE_API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().string());
                } else {
                    callback.onFailure("Error: " + response.code() + " - " + response.body().string());
                }
            }
        });
    }

    public static void signIn(String email, String password, Callback callback) {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }"
        );

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/auth/v1/token?grant_type=password")
                .addHeader("apikey", SUPABASE_API_KEY)
                .addHeader("Authorization", "Bearer " + SUPABASE_API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().string());
                } else {
                    callback.onFailure("Error: " + response.code() + " - " + response.body().string());
                }
            }
        });
    }

    public interface Callback {
        void onSuccess(String response);
        void onFailure(String error);
    }
}