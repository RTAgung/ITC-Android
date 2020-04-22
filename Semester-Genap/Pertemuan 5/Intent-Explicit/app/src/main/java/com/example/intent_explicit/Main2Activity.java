package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    final static String EXTRA_USER = "extra_user";
    final static String EXTRA_PARCEL = "extra_parcel";
    TextView tvGetusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String username = getIntent().getStringExtra(EXTRA_USER);
        Mahasiswa mahasiswa = getIntent().getParcelableExtra(EXTRA_PARCEL);

        tvGetusername = findViewById(R.id.tv_getusername);
        tvGetusername.setText("Hello, " + username +
                "\n" + "Nama Saya " + mahasiswa.getName() +
                "\n" + "Nim Saya " + mahasiswa.getNim());
    }
}
