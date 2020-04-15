package com.example.itccafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTambahMakan, btnKurangMakan, btnTambahMinum, btnKurangMinum, btnReset, btnBuy;
    TextView tvJumlahMakan, tvJumlahMinum, tvHarga, tvPurchased;

    int jumlahMakan = 0;
    int jumlahMinum = 0;
    int totalHarga = 0;
    final int HARGA_MAKAN = 10000;
    final int HARGA_MINUM = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahMakan = findViewById(R.id.btn_tambahmakan);
        btnKurangMakan = findViewById(R.id.btn_kurangmakan);
        btnTambahMinum = findViewById(R.id.btn_tambahminum);
        btnKurangMinum = findViewById(R.id.btn_kurangminum);
        btnBuy = findViewById(R.id.btn_buy);
        btnReset = findViewById(R.id.btn_reset);

        tvJumlahMakan = findViewById(R.id.tv_jumlahmakan);
        tvJumlahMinum = findViewById(R.id.tv_jumlahminum);
        tvHarga = findViewById(R.id.tv_harga);
        tvPurchased = findViewById(R.id.tv_purchased);

        btnTambahMakan.setOnClickListener(this);
        btnKurangMakan.setOnClickListener(this);
        btnTambahMinum.setOnClickListener(this);
        btnKurangMinum.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        tvPurchased.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahmakan:
                // operasinya disini
                tambahPesanan(R.id.btn_tambahmakan);
                break;
            case R.id.btn_kurangmakan:
                kurangPesanan(R.id.btn_kurangmakan);
                break;
            case R.id.btn_tambahminum:
                tambahPesanan(R.id.btn_tambahminum);
                break;
            case R.id.btn_kurangminum:
                kurangPesanan(R.id.btn_kurangminum);
                break;
            case R.id.btn_buy:
                tvPurchased.setText("Purchased");
                break;
            case R.id.btn_reset:
                reset();
                break;
        }
    }

    void reset(){
        jumlahMakan = 0;
        jumlahMinum = 0;
        totalHarga = 0;

        tvJumlahMakan.setText("0");
        tvJumlahMinum.setText("0");
        tvHarga.setText("Rp.0");
        tvPurchased.setText("");
    }

    void tambahPesanan(int asal){
        if (asal == R.id.btn_tambahmakan){
            if (jumlahMakan < 10){
                jumlahMakan++;
                totalHarga = totalHarga + HARGA_MAKAN;

                tvJumlahMakan.setText(""+jumlahMakan);
                tvHarga.setText("Rp."+totalHarga);
            }
        }
        if (asal == R.id.btn_tambahminum){
            if (jumlahMinum < 10){
                jumlahMinum++;
                totalHarga = totalHarga + HARGA_MINUM;

                tvJumlahMinum.setText(""+jumlahMinum);
                tvHarga.setText("Rp."+totalHarga);
            }
        }
    }

    void kurangPesanan(int asal){
        if (asal == R.id.btn_kurangmakan){
            if (jumlahMakan > 0){
                jumlahMakan--;
                totalHarga = totalHarga - HARGA_MAKAN;

                tvJumlahMakan.setText(""+jumlahMakan);
                tvHarga.setText("Rp."+totalHarga);
            }
        }
        if (asal == R.id.btn_kurangminum){
            if (jumlahMinum > 0){
                jumlahMinum--;
                totalHarga = totalHarga - HARGA_MINUM;

                tvJumlahMinum.setText(""+jumlahMinum);
                tvHarga.setText("Rp."+totalHarga);
            }
        }
    }
}
