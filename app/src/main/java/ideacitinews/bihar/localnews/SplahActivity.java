package ideacitinews.bihar.localnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import ideacitinews.bihar.localnews.AdminApp.Adddata;
import ideacitinews.bihar.localnews.AdminApp.AdddataButtons;

public class SplahActivity extends AppCompatActivity {

    Button accountcreate,nextsteobutton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);
        auth = FirebaseAuth.getInstance();

        accountcreate = findViewById(R.id.bt_accountcreate);
        nextsteobutton = findViewById(R.id.bt_nextstep);

        nextsteobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(auth.getCurrentUser()!= null){
                    Intent mainintent = new Intent(SplahActivity.this,MainActivity.class);
                    startActivity(mainintent);
                }else {
                    Intent mainintent = new Intent(SplahActivity.this,MainActivity.class);
                    startActivity(mainintent);
                }


            }
        });

        accountcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent mainintent = new Intent(SplahActivity.this, SighupActivity.class);
                    startActivity(mainintent);

            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}