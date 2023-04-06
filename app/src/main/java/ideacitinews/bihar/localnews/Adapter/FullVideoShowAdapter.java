package ideacitinews.bihar.localnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.Fullvideoshowagain;
import ideacitinews.bihar.localnews.LoginActivity;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;
import ideacitinews.bihar.localnews.R;
import ideacitinews.bihar.localnews.YoutubefullvideoActivity;

public class FullVideoShowAdapter extends RecyclerView.Adapter<FullVideoShowAdapter.MyViewHolder> {

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

    public FullVideoShowAdapter(Context context , ArrayList<YoutubevideoModel> list)
    {
        this.context = context;
        this.arrayList = list;
    }

    @NonNull
    @Override
    public FullVideoShowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_video_model, parent, false);

        return new FullVideoShowAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FullVideoShowAdapter.MyViewHolder holder, int position) {
        final YoutubevideoModel album = arrayList.get(position);

        holder.textView.setText(album.getTitle());
        Glide.with(context)
                .load(album.getVideoimage())
                .into(holder.videoimage);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Fullvideoshowagain.class);
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

