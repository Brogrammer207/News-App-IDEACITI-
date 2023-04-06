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
import ideacitinews.bihar.localnews.R;

public class Adddata extends AppCompatActivity {
    DatabaseReference newsreference;
    EditText editTexttitle,editTextimage,editTextdesc1,editTextdesc2,editTextdesc3;
    Button submitbutton,bt_latestnews,bt_countrynews,bt_worldnews,bt_crickrtnews,bt_politicsnews,bt_entermaintnews;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        editTextdesc1 = findViewById(R.id.et_desc1);
        editTextdesc2 = findViewById(R.id.et_desc2);
        editTextdesc3 = findViewById(R.id.et_desc3);
        editTexttitle = findViewById(R.id.et_title);
        editTextimage = findViewById(R.id.et_image);
        submitbutton = findViewById(R.id.latestnews);
        bt_latestnews = findViewById(R.id.latestnews);
        bt_countrynews = findViewById(R.id.countrynews);
        bt_worldnews = findViewById(R.id.worldnews);
        bt_crickrtnews = findViewById(R.id.cricketnews);
        bt_politicsnews = findViewById(R.id.politicsnews);
        bt_entermaintnews = findViewById(R.id.entertramaintsnews);



        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("news");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });

        bt_countrynews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("country");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });

        bt_worldnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("world");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });

        bt_crickrtnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("cricket");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });

        bt_politicsnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("politics");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });

        bt_entermaintnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsreference  = FirebaseDatabase.getInstance().getReference().child("entertainment");

                String title = editTexttitle.getText().toString();
                String image = editTextimage.getText().toString();
                String desc1 = editTextdesc1.getText().toString();
                String desc2 = editTextdesc2.getText().toString();
                String desc3 = editTextdesc3.getText().toString();
                Blog blog = new Blog(title,image,desc1,desc2,desc3);
                newsreference.push().setValue(blog);

                Toast.makeText(Adddata.this, "Thanks For Submit", Toast.LENGTH_SHORT).show();
                editTexttitle.getText().clear();
                editTextimage.getText().clear();
                editTextdesc1.getText().clear();
                editTextdesc2.getText().clear();
                editTextdesc3.getText().clear();
            }
        });
    }
}