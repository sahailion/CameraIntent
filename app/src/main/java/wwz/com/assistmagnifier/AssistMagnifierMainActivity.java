package wwz.com.assistmagnifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.provider.MediaStore;

public class AssistMagnifierMainActivity extends AppCompatActivity {

    private static final int ACTIVITY_START_CAMERA_APP = 0;
    private ImageView photoCapturedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_magnifier_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View photoCapturedView = (ImageView) findViewById(R.id.capturePhotoImageView);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assist_magnifier_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void takePhoto(View view)
    {
        Intent callCameraApplicationIntent = new Intent();
        callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(callCameraApplicationIntent, ACTIVITY_START_CAMERA_APP);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == ACTIVITY_START_CAMERA_APP &&  resultCode == RESULT_OK)
        {
            Toast.makeText(this, "Picture taken successfully", Toast.LENGTH_SHORT).show();
        }
    }

}