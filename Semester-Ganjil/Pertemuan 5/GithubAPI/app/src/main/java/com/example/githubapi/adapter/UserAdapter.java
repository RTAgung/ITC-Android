package com.example.githubapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.githubapi.R;
import com.example.githubapi.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> listUser = new ArrayList<>();

    public void setUsers(ArrayList<User> listUser){
        this.listUser.clear();
        this.listUser.addAll(listUser);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listUser.get(position));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar;
        private TextView tvUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvUser = itemView.findViewById(R.id.tv_user);
        }

        public void bind(User user){
            tvUser.setText(user.getLogin());
            Picasso.get()
                    .load(user.getAvatar_url())
                    .into(ivAvatar);
        }
    }
}
