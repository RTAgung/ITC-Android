package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.githubapi.model.User;
import com.example.githubapi.service.GithubApi;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PARCEL = "extra_parcel";
    private User user;
    private CircleImageView ivAvatar;
    private TextView tvLogin, tvName, tvFollowers, tvFollowing, tvRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null){
            user = getIntent().getParcelableExtra(EXTRA_PARCEL);
        }

        ivAvatar = findViewById(R.id.iv_avatar);
        tvLogin = findViewById(R.id.tv_login);
        tvName = findViewById(R.id.tv_name);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowing = findViewById(R.id.tv_following);
        tvRepos = findViewById(R.id.tv_repos);

        GithubApi githubApi = new GithubApi();
        githubApi.getDetailUser(userListener, user.getLogin());
    }

    ApiListener<User> userListener = new ApiListener<User>() {
        @Override
        public void onSuccess(User user) {
            Picasso.get()
                    .load(user.getAvatar_url())
                    .into(ivAvatar);
            tvLogin.setText(user.getLogin());
            tvName.setText(user.getName());
            tvFollowers.setText("Followers : " + user.getFollowers());
            tvFollowing.setText("Following : " + user.getFollowing());
            tvRepos.setText("Repositories : " + user.getPublic_repos());
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ERROR API", msg);
        }
    };
}