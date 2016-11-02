package org.natuan.asynchttpclient.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;

import org.natuan.asynchttpclient.AsyncHttpClient;
import org.natuan.asynchttpclient.AsyncHttpClientImpl;
import org.natuan.asynchttpclient.HTTPRequest;
import org.natuan.asynchttpclient.JsonResponseHandler;
import org.natuan.asynchttpclient.samples.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nguyen Anh Tuan on 15/10/2016.
 * natuan.org@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvMessage;
    private RecyclerView rvUser;
    private ProgressBar prbLoadig;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        prbLoadig = (ProgressBar) findViewById(R.id.prbLoading);
        rvUser = (RecyclerView) findViewById(R.id.rvUser);
        rvUser.setHasFixedSize(true);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        mUserAdapter = new UserAdapter();
        rvUser.setAdapter(mUserAdapter);
        try {
            HTTPRequest.Builder builder = new HTTPRequest.Builder();
            builder.setVerb(HTTPRequest.Verb.GET);
            builder.setUrl("http://jsonplaceholder.typicode.com/users");
            HTTPRequest request = builder.build();
            AsyncHttpClient client = new AsyncHttpClientImpl();
            //client.excuteAsync(request, jsonResponseHandler);
            User[] users = (User[]) client.excuteSync(request, User[].class);
            List<User> userList = Arrays.asList(users);
            if (userList != null) {
                mUserAdapter.updateData(userList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JsonResponseHandler<List<User>> jsonResponseHandler =
        new JsonResponseHandler<List<User>>(
                new TypeToken<ArrayList<User>>() {
                }.getType()
        ) {
            @Override
            public void onSuccess(List<User> response) {
                prbLoadig.setVisibility(View.GONE);
                if (response != null && response.size() > 0) {
                    mUserAdapter.updateData(response);
                }
            }

            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: " + error.getMessage(), error);
                prbLoadig.setVisibility(View.GONE);
                tvMessage.setVisibility(View.VISIBLE);
                tvMessage.setText(error.getMessage());
            }
        };
}
