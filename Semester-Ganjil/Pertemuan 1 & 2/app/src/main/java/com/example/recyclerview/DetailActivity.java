package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_GAME = "extra_game";
    private Game game;
    private ImageView ivGame;
    private TextView tvTitle, tvTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivGame = findViewById(R.id.iv_game);
        tvTitle = findViewById(R.id.tv_title);
        tvTags = findViewById(R.id.tv_tags);

        game = getIntent().getParcelableExtra(EXTRA_GAME);

        Picasso.get()
                .load(game.getImage())
                .into(ivGame);
        tvTitle.setText(game.getTitle());
        tvTags.setText(game.getTags());
    }
}