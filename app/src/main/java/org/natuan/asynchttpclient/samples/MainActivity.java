package org.natuan.asynchttpclient.samples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import org.natuan.asynchttpclient.AsyncHttpClient;
import org.natuan.asynchttpclient.AsyncHttpClientImpl;
import org.natuan.asynchttpclient.HTTPRequest;
import org.natuan.asynchttpclient.JsonResponseHandler;
import org.natuan.asynchttpclient.samples.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Anh Tuan on 15/10/2016.
 * natuan.@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            HTTPRequest.Builder builder = new HTTPRequest.Builder();
            builder.setVerb(HTTPRequest.Verb.GET);
            builder.setUrl("http://jsonplaceholder.typicode.com/users");
            HTTPRequest request = builder.build();
            AsyncHttpClient client = new AsyncHttpClientImpl();
            client.excute(request, jsonResponseHandler);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JsonResponseHandler<List<User>, Error> jsonResponseHandler =
            new JsonResponseHandler<List<User>, Error>(
                    new TypeToken<ArrayList<User>>() {
                    }.getType(),
                    new TypeToken<Error>() {
                    }.getType()
            ) {
                @Override
                public void onSuccess(List<User> response) {
                    Log.e(TAG, "onSuccess: ");
                    if (response != null && response.size() > 0) {
                        for (User user : response) {
                            Log.e(TAG, "onSuccess: " + user.getName());
                        }
                    }
                }

                @Override
                public void onFailure(Error response) {
                    Log.e(TAG, "onFailure: " + response.toString());
                }

                @Override
                public void onError(Throwable error) {
                    Log.e(TAG, "onError: " + error.getMessage(), error);
                }
            };
}
