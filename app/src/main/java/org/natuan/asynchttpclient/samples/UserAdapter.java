package org.natuan.asynchttpclient.samples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.natuan.asynchttpclient.samples.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Anh Tuan on 22/10/2016.
 * natuan.org@gmail.com
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> mUsers;

    public UserAdapter() {
        this.mUsers = new ArrayList<>();
    }

    public void updateData(List<User> users) {
        if (users == null)
            return;
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        if (user != null) {
            holder.tvUserName.setText(user.getName());
        }
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUserName;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
        }
    }
}
