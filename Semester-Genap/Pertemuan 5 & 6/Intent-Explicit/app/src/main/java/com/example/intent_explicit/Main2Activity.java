package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    final static String EXTRA_USER = "extra_user";
    final static String EXTRA_PARCEL = "extra_parcel";
    TextView tvGetusername;
    ImageView ivPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String username = getIntent().getStringExtra(EXTRA_USER);
        final Mahasiswa mahasiswa = getIntent().getParcelableExtra(EXTRA_PARCEL);

        tvGetusername = findViewById(R.id.tv_getusername);
        tvGetusername.setText("Hello, " + username +
                "\n" + "Nama Saya " + mahasiswa.getName() +
                "\n" + "Nim Saya " + mahasiswa.getNim() +
                "\n" + "No Hp " + mahasiswa.getContact());

        ivPhone = findViewById(R.id.iv_phone);
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mahasiswa.getContact()));
                startActivity(intent);
            }
        });
    }
}
