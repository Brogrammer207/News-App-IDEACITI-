package ideacitinews.bihar.localnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsDetails extends AppCompatActivity {

    ImageView mainimageView,whatsappimage,facebookimage,instagramimage,twiterimage;
    TextView titletextview,destextview1,destextview2,destextview3;
    String Title,Desc1,Image,Desc2,Desc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        mainimageView = findViewById(R.id.mainimage);
        whatsappimage = findViewById(R.id.whatsappimage);
        facebookimage = findViewById(R.id.facebookimage);
        instagramimage = findViewById(R.id.instagramimage);
        twiterimage = findViewById(R.id.twiterimage);
        titletextview = findViewById(R.id.titletextview);
        destextview1 = findViewById(R.id.desctextview);
        destextview2 = findViewById(R.id.desctextview2);
        destextview3 = findViewById(R.id.desctextview3);

        Intent intent = getIntent();

        if(isStoragePermissionGranted())
        {
            Title = intent.getStringExtra("Title");
            Desc1 = intent.getStringExtra("Desc1");
            Image = intent.getStringExtra("Image");
            Desc2 = intent.getStringExtra("Desc2");
            Desc3 = intent.getStringExtra("Desc3");

            titletextview.setText(Title);
            destextview1.setText(Desc1);
            destextview2.setText(Desc2);
            destextview3.setText(Desc3);
            Glide.with(this)
                    .load(Image)
                    .into(mainimageView);
        }else {
            Title = intent.getStringExtra("Title");
            Desc1 = intent.getStringExtra("Desc1");
            Image = intent.getStringExtra("Image");
            Desc2 = intent.getStringExtra("Desc2");
            Desc3 = intent.getStringExtra("Desc3");

            titletextview.setText(Title);
            destextview1.setText(Desc1);
            destextview2.setText(Desc2);
            destextview3.setText(Desc3);
            Glide.with(this)
                    .load(Image)
                    .into(mainimageView);
        }

        whatsappimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) mainimageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                String bitmappath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
                Uri uri = Uri.parse(bitmappath);
                String message1 = titletextview.getText().toString();
                String link  = "For Full News Download The App Now - https://play.google.com/store/apps/details?id=ideacitinews.bihar.localnews";
                String data =message1 + "\n" + link;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/png");
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT, data);
                startActivity(intent);
            }
        });
        twiterimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) mainimageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                String bitmappath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
                Uri uri = Uri.parse(bitmappath);
                String message1 = titletextview.getText().toString();
                String link  = "For Full News Download The App Now - https://play.google.com/store/apps/details?id=ideacitinews.bihar.localnews";
                String data =message1 + "\n" + link;
                Intent twiterintent = new Intent(Intent.ACTION_SEND);
                twiterintent.setType("image/png");
                twiterintent.setType("text/plain");
                twiterintent.putExtra(Intent.EXTRA_STREAM,uri);
                twiterintent.putExtra(Intent.EXTRA_TEXT, data);
                startActivity(twiterintent);
            }
        });
        facebookimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) mainimageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                String bitmappath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
                Uri uri = Uri.parse(bitmappath);
                String message1 = titletextview.getText().toString();
                String link  = "For Full News Download The App Now - https://play.google.com/store/apps/details?id=ideacitinews.bihar.localnews";
                String data =message1 + "\n" + link;
                Intent facebookintent = new Intent(Intent.ACTION_SEND);
                facebookintent.setType("image/png");
                facebookintent.setType("text/plain");
                facebookintent.putExtra(Intent.EXTRA_STREAM,uri);
                facebookintent.putExtra(Intent.EXTRA_TEXT, data);
                startActivity(facebookintent);
            }
        });
        instagramimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) mainimageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                String bitmappath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
                Uri uri = Uri.parse(bitmappath);
                String message1 = titletextview.getText().toString();
                String link  = "For Full News Download The App Now - https://play.google.com/store/apps/details?id=ideacitinews.bihar.localnews";
                String data =message1 + "\n" + link;
                Intent instaintent = new Intent(Intent.ACTION_SEND);
                instaintent.setType("image/png");
                instaintent.setType("text/plain");
                instaintent.putExtra(Intent.EXTRA_STREAM,uri);
                instaintent.putExtra(Intent.EXTRA_TEXT, data);
                startActivity(instaintent);
            }
        });


    }
    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Grant", "Permission is granted");
                return true;
            } else {

                Log.v("Revoked", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Granted", "Permission is granted");
            return true;
        }
    }
}