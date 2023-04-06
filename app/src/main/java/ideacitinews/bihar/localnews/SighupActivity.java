package ideacitinews.bihar.localnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import ideacitinews.bihar.localnews.AdminApp.AdminLogin;

public class SighupActivity extends AppCompatActivity {

    EditText et_name,et_email,et_phoneno,et_password;
    Button bt_register;
    TextView tv_newaccount;
    FirebaseAuth auth;
    ImageView imageView,ic_backimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighup);

        et_name = findViewById(R.id.editTextName);
        et_email = findViewById(R.id.editTextEmail);
        et_phoneno = findViewById(R.id.editTextMobile);
        et_password = findViewById(R.id.editTextPassword);
        bt_register = findViewById(R.id.RegisterButton);
        tv_newaccount = findViewById(R.id.newaccounttextview);
        imageView = findViewById(R.id.adminimage);
        ic_backimage = findViewById(R.id.ic_backimage);

        ic_backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String phoneno = et_phoneno.getText().toString();
                String password = et_password.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(SighupActivity.this, "Please Enter Email Password", Toast.LENGTH_SHORT).show();
                }else if(password.length()<6)
                {
                    Toast.makeText(SighupActivity.this, "Password is short", Toast.LENGTH_SHORT).show();
                }else {
                    registeruser(email,password);
                }
            }
        });

        tv_newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SighupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SighupActivity.this, AdminLogin.class);
                startActivity(intent);
            }
        });

    }



    private void registeruser(String email, String password) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SighupActivity.this, "Account Created Successfully ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SighupActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(SighupActivity.this, "Some Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}