package com.example.arturmusayelyan.duxovuseful;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    protected RelativeLayout loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void startLoader(){
        if(loader!=null && loader.getVisibility()!=View.VISIBLE){
            Toast.makeText(this,"Loader started",Toast.LENGTH_SHORT).show();
            loader.setVisibility(View.VISIBLE);
        }
    }
    protected void stopLoader(){
        if(loader!=null){
            loader.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if(loader!=null && loader.getVisibility()==View.VISIBLE){
            stopLoader();
            Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT).show();
        }
        else {
            super.onBackPressed();
        }
    }
}
