package com.example.com.breadtour.add;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.com.breadtour.R;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class AddActivity extends Activity {

    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mImageView = (ImageView) findViewById(R.id.dialog_image);


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(AddActivity.this, MainActivity.class);
//                startActivity(intent);
                finish();
//                Toast.makeText(AddActivity.this.getApplicationContext(), "你好吗？", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
