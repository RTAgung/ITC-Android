package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {
    ArrayList<Game> listGame = new ArrayList<>();

    public GameListAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listGame.get(position));
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivGame;
        TextView tvTitle, tvTags;
        Context context = itemView.getContext();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGame = itemView.findViewById(R.id.iv_game);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTags = itemView.findViewById(R.id.tv_tags);
        }

        void bind(final Game data) {
            Picasso.get()
                    .load(data.getImage())
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_image_24)
                    .into(ivGame);
            tvTitle.setText(data.getTitle());
            tvTags.setText(data.getTags());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Saya memilih " + tvTitle.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_GAME, data);
                    context.startActivity(intent);
                }
            });
        }
    }
}
