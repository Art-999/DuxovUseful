package com.example.arturmusayelyan.duxovuseful.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.arturmusayelyan.duxovuseful.R;
import com.example.arturmusayelyan.duxovuseful.interfaces.OnDialogClickCustomListener;

public class DialogUtils {
    private OnDialogClickCustomListener dialogClickCustomListener;

    public void setDialogClickCustomListener(OnDialogClickCustomListener dialogClickCustomListener) {
        this.dialogClickCustomListener = dialogClickCustomListener;
    }

    public static void showSuccessDialog(Context context, final String message, final OnDialogClickCustomListener dialogListener) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.success_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        TextView messageTv = dialog.findViewById(R.id.message_tv);
        messageTv.setText(message);

        TextView startBtn = dialog.findViewById(R.id.tv_start);
        TextView stopBtn = dialog.findViewById(R.id.tv_cancel);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListener.onPositiveClick();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListener.onNegativeClick();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
