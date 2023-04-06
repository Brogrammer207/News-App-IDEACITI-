package ideacitinews.bihar.localnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    EditText et_email,et_password;
    Button bt_login;
    TextView tv_newuser,tv_forgetpassword;
    FirebaseAuth auth;
    ImageView plusimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.editTextEmail);
        et_password = findViewById(R.id.editTextPassword);
        bt_login = findViewById(R.id.cirLoginButton);
        tv_newuser = findViewById(R.id.newusertextview);
        tv_forgetpassword = findViewById(R.id.forgetpasswordtextview);
        plusimage = findViewById(R.id.loginplusimage);

        auth = FirebaseAuth.getInstance();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= et_email.getText().toString();
                String password = et_password.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Field Incomplete", Toast.LENGTH_SHORT).show();
                }else {
                    userlogin(email,password);

                }

            }
        });

        tv_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,PasswordReaset.class);
                startActivity(intent);
            }
        });
    }

    private void userlogin(String email, String password) {

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Complete", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Some Error Accrue", Toast.LENGTH_SHORT).show();
                }

            }
        });

        plusimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SighupActivity.class);
                startActivity(intent);
            }
        });

    }
}