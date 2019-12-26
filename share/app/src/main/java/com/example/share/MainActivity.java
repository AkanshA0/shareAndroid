package com.example.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Target;

import okhttp3.internal.Util;

public class MainActivity extends AppCompatActivity {

    private static Uri imgUri = null;
    public ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageview);

        ImageButton sharingButton = findViewById(R.id.sharebutton);
        sharingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()," on click ",Toast.LENGTH_SHORT);
                shareIt();
                Toast.makeText(getApplicationContext()," o c after shareit ",Toast.LENGTH_SHORT);
            }
        });


    }

    private void shareIt() {
//sharing implementation here
/*
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        //sharingIntent.setType("text/plain");
        //imgUri=Uri.parse("android.resource://com.example.share/drawable/sharing");
        imgUri=Uri.parse("https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/32509945_441963812897514_7806625513186787328_o.jpg?_nc_cat=102&_nc_ohc=pSlopmVwnPwAQkqUnMr5YF7QKYDwgRsBJqYHMkulTka3qVJ1YXyzdeUYg&_nc_ht=scontent.xx&oh=f8186be7800e56fc4021aa350f8c0ad4&oe=5EA33BAA");
        sharingIntent.setType("image/*");
        //String shareBody = "Here is the share content body";
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
*/

        Toast.makeText(getApplicationContext()," before load ",Toast.LENGTH_SHORT);
       // String url = "https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/32509945_441963812897514_7806625513186787328_o.jpg?_nc_cat=102&_nc_ohc=pSlopmVwnPwAQkqUnMr5YF7QKYDwgRsBJqYHMkulTka3qVJ1YXyzdeUYg&_nc_ht=scontent.xx&oh=f8186be7800e56fc4021aa350f8c0ad4&oe=5EA33BAA";
       String url="https://scontent.xx.fbcdn.net/v/t1.0-9/29684065_422846671475895_60612627247842958_n.jpg?_nc_cat=109&_nc_ohc=chpSwP3774QAQmtxFwK7Rl2Ds_49Sf1jR62ZRKEWG8ZvBouN4dVCdWuVA&_nc_ht=scontent.xx&oh=4dc8e896d348b8699ae2dd94f8741c2c&oe=5EB37557";
        //new ImageLoadTask(url, imgView1).execute();
        Picasso.get().load(url).into(imageView1);
        Toast.makeText(getApplicationContext()," after load ",Toast.LENGTH_SHORT);


        Bitmap bitmap = getBitmapFromView(imageView1);
        try {
            Toast.makeText(getApplicationContext(), " in try ", Toast.LENGTH_SHORT);
            File file = new File(this.getExternalCacheDir(), "im.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            Picasso.get().load(url).into(imageView1);
        }catch (Exception e)
        {e.printStackTrace();}




        shareContent();




 /*
        Picasso.get().load(url).into(new Target() {
            @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("image/*");
                i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap));
                startActivity(Intent.createChooser(i, "Share Image"));
            }
            @Override public void onBitmapFailed(Drawable errorDrawable) { }
            @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
        });
    }

    public Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }
*/

//shareImage(url,this);

    }

/*
    public void shareImage(String url, final Context context) {
        Picasso.get().load(url).into(new Target() {
            @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("image/*");
                i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap, context));
                context.startActivity(Intent.createChooser(i, "Share Image"));
            }
            @Override public void onBitmapFailed(Drawable errorDrawable) { }
            @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
        });
    }
    public Uri getLocalBitmapUri(Bitmap bmp, Context context) {
        Uri bmpUri = null;
        try {
            File file =  new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

*/

    public void shareContent() {
        Toast.makeText(getApplicationContext()," shareContent method ",Toast.LENGTH_SHORT);

        Bitmap bitmap = getBitmapFromView(imageView1);
        try {
            Toast.makeText(getApplicationContext()," in try ",Toast.LENGTH_SHORT);
            File file = new File(this.getExternalCacheDir(), "im.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/*");
            startActivity(Intent.createChooser(intent, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext()," catch "+e+"",Toast.LENGTH_SHORT);
        }

    }

    private Bitmap getBitmapFromView(View view) {

        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;



/*
    v.setDrawingCacheEnabled(true);

// this is the important code :)
// Without it the view will have a dimension of 0,0 and the bitmap will be null
v.measure(View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED));
v.layout(0,0,v.getMeasuredWidth(),v.getMeasuredHeight());

v.buildDrawingCache(true);
    Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
v.setDrawingCacheEnabled(false); // clear drawing cache
return b;
*/

       /* Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
        */

}

}
