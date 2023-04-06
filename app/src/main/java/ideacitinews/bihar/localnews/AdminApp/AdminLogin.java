package ideacitinews.bihar.localnews.AdminApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import ideacitinews.bihar.localnews.R;
import ideacitinews.bihar.localnews.SighupActivity;

public class AdminLogin extends AppCompatActivity {

    EditText adminlogin,adminpassword;
    Button adminloginbutton;
    ImageView plusimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminlogin = findViewById(R.id.admineditTextEmail);
        adminpassword = findViewById(R.id.admineditTextPassword);
        adminloginbutton = findViewById(R.id.admincirLoginButton);
        plusimage = findViewById(R.id.plusimage);

        adminloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myeamil = "ideacitinews@gmail.com";
                String mypassword = "ideacitibesthai";
                if(adminlogin.getText().toString().equalsIgnoreCase(myeamil) && adminpassword.getText().toString().equals(mypassword)){
                    Toast.makeText(AdminLogin.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminLogin.this,AdddataButtons.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(AdminLogin.this, "Doing Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plusimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminLogin.this, SighupActivity.class);
                startActivity(intent);
            }
        });

    }
}