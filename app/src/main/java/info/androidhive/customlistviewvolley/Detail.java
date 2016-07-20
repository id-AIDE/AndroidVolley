package info.androidhive.customlistviewvolley;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import info.androidhive.customlistviewvolley.app.AppController;

public class Detail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("image");

        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        BitmapDrawable background = new BitmapDrawable(bmp);
        findViewById(R.id.thumbnail).setBackgroundDrawable(background);

        Intent i = getIntent();
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        String bitmap = i.getStringExtra("image");
        String title = i.getStringExtra("title");
        NetworkImageView thumbNail = (NetworkImageView) findViewById(R.id.thumbnail);
        thumbNail.setImageUrl(bitmap, imageLoader);
        TextView DetailTitle = (TextView) findViewById(R.id.detail_title);

        DetailTitle.setText(title);
    }
}
