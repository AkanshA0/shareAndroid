package com.example.share;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   private static Uri imgUri=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton sharingButton =  findViewById(R.id.sharebutton);
        sharingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt();
            }
        });

    }
    private void shareIt() {
//sharing implementation here

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        //sharingIntent.setType("text/plain");
        //imgUri=Uri.parse("android.resource://com.example.share/drawable/sharing");
        imgUri=Uri.parse("https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/32509945_441963812897514_7806625513186787328_o.jpg?_nc_cat=102&_nc_ohc=pSlopmVwnPwAQkqUnMr5YF7QKYDwgRsBJqYHMkulTka3qVJ1YXyzdeUYg&_nc_ht=scontent.xx&oh=f8186be7800e56fc4021aa350f8c0ad4&oe=5EA33BAA");
        sharingIntent.setType("image/*");
        //String shareBody = "Here is the share content body";
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }


}
