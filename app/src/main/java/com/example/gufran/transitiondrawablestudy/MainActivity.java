package com.example.gufran.transitiondrawablestudy;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int mCurrentDrawable = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        Drawable d1 = ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher);
        Drawable d2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.android_mascot);

        Drawable[] drawables = {d1, d2};

        final TransitionDrawable transitionDrawable = new TransitionDrawable(drawables);
        imageView.setImageDrawable(transitionDrawable);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentDrawable == 0) {
                    transitionDrawable.startTransition(1000);
                    mCurrentDrawable = 1;
                } else {
                    transitionDrawable.reverseTransition(1000);
                    mCurrentDrawable = 0;
                }
            }
        });
    }


}
