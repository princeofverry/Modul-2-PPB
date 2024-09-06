package com.example.modul2_kel33;

import static android.content.Intent.getIntent;
import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private int waktu_loading = 2000;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.bg_header_home);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarGradiant(this);
        }
        setContentView(R.layout.activity_splash_screen);

        final SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall", "");

        if (FirstTime.equals("No")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intro = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intro);
                    finish();
                    overridePendingTransition(0, 0);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                }
            }, waktu_loading);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("FirstTimeInstall", "No");
                    editor.apply();
                    Intent login = new Intent(SplashScreenActivity.this, LandingPageActivity.class);
                    startActivity(login);
                    finish();
                    overridePendingTransition(0, 0);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                }
            }, waktu_loading);

        }
    }
}
