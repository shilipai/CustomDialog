package com.example.lxs.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private ImageView imgResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn_pop_dialog_1);
        imgResponse = (ImageView) findViewById(R.id.img_response);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(MainActivity.this, "from btn_1", R.style.dialog, new CustomDialog.ICustomDialogEventListener() {
                    @Override
                    public void customDialogEvent(int id) {
                        ImageView imageView = (ImageView) findViewById(R.id.img_response);
                        imageView.setImageResource(id);
                    }
                });
                dialog.show();
            }
        });

    }
}