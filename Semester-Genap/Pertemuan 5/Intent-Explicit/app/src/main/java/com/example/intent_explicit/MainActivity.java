package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setName("Anjar");
                mahasiswa.setNim("123180056");

                if (username.equals("admin") && password.equals("admin123")){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra(Main2Activity.EXTRA_USER, username);
                    intent.putExtra(Main2Activity.EXTRA_PARCEL, mahasiswa);
                    startActivity(intent);
                }
            }
        });
    }
}
