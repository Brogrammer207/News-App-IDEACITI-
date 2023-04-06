package ideacitinews.bihar.localnews.AdminApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ideacitinews.bihar.localnews.ModelClass.Blog;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;
import ideacitinews.bihar.localnews.R;

public class AddYoutubedata extends AppCompatActivity {

    EditText videotitle,videourl,videoimage;
    Button videosubmit;

    DatabaseReference videodataref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_youtubedata);

        videotitle = findViewById(R.id.et_videotitle);
        videoimage = findViewById(R.id.et_videoimage);
        videourl = findViewById(R.id.et_videourl);
        videosubmit = (Button) findViewById(R.id.bt_submitvideo);

        videosubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videodataref  = FirebaseDatabase.getInstance().getReference().child("youtube");

                String title = videotitle.getText().toString();
                String url = videourl.getText().toString();
                String videoimages = videoimage.getText().toString();

                YoutubevideoModel youtubevideoModel = new YoutubevideoModel(title,url,videoimages);
                videodataref.push().setValue(youtubevideoModel);

                Toast.makeText(AddYoutubedata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                videotitle.getText().clear();
                videoimage.getText().clear();
                videourl.getText().clear();

            }
        });

    }
}