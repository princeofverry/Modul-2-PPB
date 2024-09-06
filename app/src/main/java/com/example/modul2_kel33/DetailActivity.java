package com.example.modul2_kel33;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_first_name);

        if (getIntent().hasExtra("name")) {

            String nama = getIntent().getStringExtra("name");
            tvNama.setText(nama);
        }
    }
}
