package ideacitinews.bihar.localnews.AdminApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ideacitinews.bihar.localnews.R;

public class AdddataButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata_buttons);

       Button newsbutton = findViewById(R.id.latestnewsbutton);
        Button youtubevideobutton = findViewById(R.id.youtubevideodatabutton);
        Button epaperbutton = findViewById(R.id.epaperdatabutton);
        newsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdddataButtons.this,Adddata.class);
                startActivity(intent);
            }
        });
        youtubevideobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdddataButtons.this,AddYoutubedata.class);
                startActivity(intent);
            }
        });

        epaperbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdddataButtons.this,Epaperdata.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}