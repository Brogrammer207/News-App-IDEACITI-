package ideacitinews.bihar.localnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.FullImageEpaper;
import ideacitinews.bihar.localnews.ModelClass.NewsEpaperModel;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;
import ideacitinews.bihar.localnews.R;
import ideacitinews.bihar.localnews.YoutubefullvideoActivity;

public class NewsEpaperAdapter extends RecyclerView.Adapter<NewsEpaperAdapter.MyViewHolder> {

    Context context;
    public  ArrayList<NewsEpaperModel> newsEpaperModelslist;
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView epaper;
        TextView datetext;
        LinearLayout linearLayout;

        public MyViewHolder(View view){
            super(view);
            epaper = view.findViewById(R.id.epeprimageview);
            datetext = view.findViewById(R.id.datetext);
            linearLayout = view.findViewById(R.id.epaperlayout);

        }

    }
    public NewsEpaperAdapter(Context context , ArrayList<NewsEpaperModel> list)
    {
        this.context = context;
        this.newsEpaperModelslist = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsepeper,parent,false);
        return new NewsEpaperAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        final NewsEpaperModel album = newsEpaperModelslist.get(position);

        holder.datetext.setText(album.getDate());
        Glide.with(context)
                .load(album.getPaperimages())
                .into(holder.epaper);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageEpaper.class);
                intent.putExtra("Title",album.getDate());
                intent.putExtra("Url",album.getPaperimages());
                intent.putExtra("Image1",album.getImage1());
                intent.putExtra("Image2",album.getImage2());
                intent.putExtra("Image3",album.getImage3());
                intent.putExtra("Image4",album.getImage4());
                intent.putExtra("Image5",album.getImage5());
                intent.putExtra("Image6",album.getImage6());
                intent.putExtra("Image7",album.getImage7());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsEpaperModelslist.size();
    }


}
