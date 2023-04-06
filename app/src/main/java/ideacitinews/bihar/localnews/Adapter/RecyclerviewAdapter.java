package ideacitinews.bihar.localnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ideacitinews.bihar.localnews.FirstFragment;
import ideacitinews.bihar.localnews.MainActivity;
import ideacitinews.bihar.localnews.ModelClass.Blog;
import ideacitinews.bihar.localnews.NewsDetails;
import ideacitinews.bihar.localnews.R;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Blog> filteredData;
    private ArrayList<Blog> originalData = null;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public final LinearLayout layout;
        public final ImageView post_image;
        public final TextView moviename;


        public MyViewHolder(View view) {
            super(view);

            layout = (LinearLayout) view.findViewById(R.id.layout);
            post_image = (ImageView) view.findViewById(R.id.pics);
            moviename = (TextView) view.findViewById(R.id.post_title);


        }
    }


    public RecyclerviewAdapter(Context mContext, ArrayList<Blog> albumList) {
        this.mContext = mContext;
        this.filteredData = albumList;
    }
    public void filterList(ArrayList<Blog> filterlist) {
        this.filteredData = filterlist;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpagenews, parent, false);

        return new MyViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Blog album = filteredData.get(position);

        holder.moviename.setText(album.getTitle());
        Log.d(">>>",album.getImage());
        Glide.with(mContext)
                .load(album.getImage())
                .into(holder.post_image);



        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, NewsDetails.class);
                intent.putExtra("Title",album.getTitle());
                intent.putExtra("Image",album.getImage());
                intent.putExtra("Desc1",album.getDesc1());
                intent.putExtra("Desc2",album.getDesc2());
                intent.putExtra("Desc3",album.getDesc3());

                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return filteredData.size();
    }



}