package ideacitinews.bihar.localnews;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.Adapter.FullVideoShowAdapter;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;

public class Fullvideoshowagain extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;
    TextView youtubevideotitle;
    String Title,Url;
    RecyclerView youtubedetailsrecyclerView;
    DatabaseReference databaseReference;
    ArrayList<YoutubevideoModel> youtubevideoModelArrayList = new ArrayList<>();
    FullVideoShowAdapter adapter;
    ImageView enterPipMode,likebutton,commentbutton,sharebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullvideoshowagain);
        enterPipMode = findViewById(R.id.enter_pip);
        likebutton = findViewById(R.id.IV_like);
        commentbutton = findViewById(R.id.IV_comment);
        sharebutton = findViewById(R.id.IV_share);

        youTubePlayerView = findViewById(R.id.youtubevideoview);
        youtubevideotitle = findViewById(R.id.youtubevideotitle);
        Intent intent = getIntent();
        Title = intent.getStringExtra("Title");
        Url = intent.getStringExtra("Url");
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady( YouTubePlayer youTubePlayer) {
                String videoId = Url;
                youTubePlayer.loadVideo(videoId, 0);

                super.onReady(youTubePlayer);
            }
        });
        youtubevideotitle.setText(Title);

        youtubedetailsrecyclerView = findViewById(R.id.youtubedetailsrecyclerView);
        youtubedetailsrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        youtubedetailsrecyclerView.setLayoutManager(layoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("youtube");
        databaseReference.keepSynced(true);

        adapter = new FullVideoShowAdapter(Fullvideoshowagain.this,youtubevideoModelArrayList);
        youtubedetailsrecyclerView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    YoutubevideoModel model = snapshot1.getValue(YoutubevideoModel.class);
                    youtubevideoModelArrayList.add(model);
                    Log.d("hello","manish");
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                String message1 = "https://www.youtube.com/watch?v=" + Url;
                String link  = "Download The App Now - https://play.google.com/store/apps/details?id=ideacitinews.bihar.localnews";
                String data =message1 + "\n" + link;
                intent.putExtra(Intent.EXTRA_TEXT,data);
                startActivity(Intent.createChooser(intent, "Share link!"));
            }
        });
        initPictureInPicture();
    }

    private void initPictureInPicture() {
        enterPipMode.setOnClickListener( view -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                boolean supportsPIP = getPackageManager().hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE);
                if(supportsPIP)
                    enterPictureInPictureMode();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Can't enter picture in picture mode")
                        .setMessage("In order to enter picture in picture mode you need a SDK version >= N.")
                        .show();
            }
        });
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        if(isInPictureInPictureMode) {
            youTubePlayerView.enterFullScreen();
        } else {
            youTubePlayerView.exitFullScreen();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

}