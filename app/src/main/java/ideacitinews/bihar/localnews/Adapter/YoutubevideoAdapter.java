package ideacitinews.bihar.localnews.Adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.ModelClass.Blog;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;
import ideacitinews.bihar.localnews.NewsDetails;
import ideacitinews.bihar.localnews.R;
import ideacitinews.bihar.localnews.YoutubefullvideoActivity;

public class YoutubevideoAdapter extends RecyclerView.Adapter<YoutubevideoAdapter.MyViewHolder> {

    Context context;
    public ArrayList<YoutubevideoModel> arrayList;
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView videoimage;
        LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.title);
            videoimage = view.findViewById(R.id.videoimage);
            linearLayout = view.findViewById(R.id.youtubelayout);
        }

    }

    public YoutubevideoAdapter(Context context , ArrayList<YoutubevideoModel> list)
    {
        this.context = context;
        this.arrayList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video_model, parent, false);

        return new YoutubevideoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final YoutubevideoModel album = arrayList.get(position);

        holder.textView.setText(album.getTitle());
        Glide.with(context)
                .load(album.getVideoimage())
                .into(holder.videoimage);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YoutubefullvideoActivity.class);
                intent.putExtra("Title",album.getTitle());
                intent.putExtra("Url",album.getUrl());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }




}
