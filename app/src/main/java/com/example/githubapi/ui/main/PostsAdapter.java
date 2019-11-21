package com.example.githubapi.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubapi.R;
import com.example.githubapi.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<PostModel> moviesList = new ArrayList<>();

    Context context ;

    public PostsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.username.setText(moviesList.get(position).getLogin());
        holder.URL.setText(moviesList.get(position).getHtmlUrl());

        Glide.with(context)
                .load(moviesList.get(position).getAvatarUrl())
                .into(holder.userImg);



    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView username , URL;
        ImageView userImg ;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.userName);
            userImg=itemView.findViewById(R.id.imageView);
            URL = itemView.findViewById(R.id.URL);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){

                        PostModel clicked = moviesList.get(pos);
                        Intent intent = new Intent(context,DetailsActivity.class);
                        intent.putExtra("login",clicked.getLogin());
                        intent.putExtra("URL",clicked.getHtmlUrl());
                        intent.putExtra("Img",clicked.getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();


                    }


                }
            });


        }
    }
}
