package ideacitinews.bihar.localnews;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.Adapter.RecyclerviewAdapter;
import ideacitinews.bihar.localnews.ModelClass.Blog;


public class FirstFragment extends Fragment {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;
    RecyclerviewAdapter artistAdapter;
    public static ArrayList<Blog> list;
    ProgressDialog progressDialog;
    YouTubePlayerView youTubePlayerView;
    DatabaseReference ref;
    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mBlogList =view.findViewById(R.id.mainrecyclerview);

        youTubePlayerView = view.findViewById(R.id.youtube_player_view);

        ref = FirebaseDatabase.getInstance().getReference().child("videoId");
        ref.keepSynced(true);

        mBlogList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mBlogList.setLayoutManager(layoutManager);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("news");
        mDatabase.keepSynced(true);
        Loaddata();
        return view;
    }

    public void Loaddata() {

        if (progressDialog == null) {
            // in standard case YourActivity.this
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mDatabase.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Blog artist = postSnapshot.getValue(Blog.class);
                    list.add(artist);
                }

                artistAdapter = new RecyclerviewAdapter(getContext(),list);
                mBlogList.setAdapter(artistAdapter);
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    YoutubeVideo video = postSnapshot.getValue(YoutubeVideo.class);
                    String s = video.toString();
                    String s2=String.valueOf(video);

                    getLifecycle().addObserver(youTubePlayerView);
                    youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                        @Override
                        public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                            Log.d("hello", "hello");

                            youTubePlayer.loadVideo(s2, 0);
                        }
                    });
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public static class YoutubeVideo{
        public String id;
        public YoutubeVideo(String id){
          this.id = id;
        }
        public YoutubeVideo(){

        }
    }


}