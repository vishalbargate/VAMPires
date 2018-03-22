package com.vamp.vamp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 5;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etUserName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        userRegistration = (TextView)findViewById(R.id.tvRegister);

        Info.setText("No of attempts remaining: 5");
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

      /* if(user = null)
        {
            finish();
            startActivity(new Intent(login.this, SecondActivity.class));
        }
*/

        Login.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View view)
                                     {
                                         validate(Name.getText().toString(), Password.getText().toString());
                                     }
                                 }
        );

            userRegistration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(login.this, RegistrationActivity.class));
                }
            });

    }
    private void validate(String userName,String userPassword){

        progressDialog.setMessage("loading....");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){

                    progressDialog.dismiss();

                    Toast.makeText(login.this,"Login successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, SecondActivity.class));

                } else{
                    Toast.makeText(login.this,"Login Failed", Toast.LENGTH_SHORT).show();

                    counter--;
                    Info.setText("no of attempts remaining:"+ counter);
                    progressDialog.dismiss();

                    if(counter==0){

                        Login.setEnabled(false);
                    }
                }
            }
        });

    }

}