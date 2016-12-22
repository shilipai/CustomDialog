package com.example.lxs.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lxs on 2016/12/22.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private String mString;
    private TextView textView;
    private ICustomDialogEventListener mCustomDialogEventListener;

    public CustomDialog(Context context) {
        super(context);
        mContext = context;
    }

    public CustomDialog(Context context, String string, int themeResId, ICustomDialogEventListener listener) {
        super(context, themeResId);
        mContext = context;
        mString = string;
        mCustomDialogEventListener = listener;
    }

    //增加一个回调函数,用以从外部接收返回值
    public interface ICustomDialogEventListener {
        void customDialogEvent(int id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog, null);
        setContentView(layout);
        textView = (TextView) findViewById(R.id.text_from);
        textView.setText(mString);
        bindImageClickEvent(layout);
    }

    private void bindImageClickEvent(View layout) {
        ImageView img1 = (ImageView) layout.findViewById(R.id.img1);
        ImageView img2 = (ImageView) layout.findViewById(R.id.img2);
        ImageView img3 = (ImageView) layout.findViewById(R.id.img3);
        ImageView img4 = (ImageView) layout.findViewById(R.id.img4);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int drawableID = -1;
        switch (v.getId()) {
            case R.id.img1:
                drawableID = R.drawable.img1;
                break;
            case R.id.img2:
                drawableID = R.drawable.img2;
                break;
            case R.id.img3:
                drawableID = R.drawable.img3;
                break;
            case R.id.img4:
                drawableID = R.drawable.img4;
                break;
        }
        if (drawableID != -1) {
            mCustomDialogEventListener.customDialogEvent(drawableID);
        }
        dismiss();
    }
}
