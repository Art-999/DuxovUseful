package com.example.arturmusayelyan.duxovuseful;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.arturmusayelyan.duxovuseful.interfaces.OnDialogClickCustomListener;
import com.example.arturmusayelyan.duxovuseful.utils.DialogUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener,OnDialogClickCustomListener {
    private Button showDialogBtn;
    private Button startLoaderBtn;
    private Button stopLoaderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        loader=findViewById(R.id.loader_layout);
        showDialogBtn=findViewById(R.id.show_dialog_btn);
        startLoaderBtn=findViewById(R.id.start_loader_btn);
        stopLoaderBtn=findViewById(R.id.stop_loader_btn);

        showDialogBtn.setOnClickListener(this);
        startLoaderBtn.setOnClickListener(this);
        stopLoaderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_loader_btn:
                startLoader();
                break;
            case R.id.stop_loader_btn:
                stopLoader();
                break;
            case R.id.show_dialog_btn:
                DialogUtils.showSuccessDialog(this,"Barev bolorin",this);
                break;
        }
    }

    @Override
    public void onPositiveClick() {
        Toast.makeText(this,"Dialog positive click worked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeClick() {
        Toast.makeText(this,"Dialog negative click worked",Toast.LENGTH_SHORT).show();
    }
}
