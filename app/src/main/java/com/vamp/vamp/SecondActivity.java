package com.vamp.vamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView PostJob;
    private TextView EditProfile;
    private TextView JobStatus;
    private TextView Jobs;
    private Button Exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        PostJob = (TextView) findViewById(R.id.tvPostJob);
        EditProfile = (TextView) findViewById(R.id.tvEditProfile);
        JobStatus = (TextView) findViewById(R.id.tvJobStatus);
        Jobs = (TextView) findViewById(R.id.tvJobs);
        Exit = (Button) findViewById(R.id.btnExit);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, login.class));
            }
        });


        PostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, postjobs.class));
            }
        });


        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, editprofile.class));
            }
        });


        JobStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, jobstatus.class));
            }
        });


        Jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, jobs.class));
            }
        });
    }}


