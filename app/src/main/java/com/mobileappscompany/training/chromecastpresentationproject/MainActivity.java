package com.mobileappscompany.training.chromecastpresentationproject;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.cast.CastMediaControlIntent;


public class MainActivity extends ActionBarActivity {

    private Button buttonToTextSendReceiveActivity;
    private Button buttonToCastVideoActivity;
    private Button buttonToCastMP3Activity;
    private Button buttonToExitApp;
    private MediaRouter mMediaRouter;
    private MediaRouteSelector mMediaRouteSelector;
    private MyMediaRouterCallback mMediaRouterCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaRouter = MediaRouter.getInstance(getApplicationContext());
        mMediaRouterCallback = new MyMediaRouterCallback();

        buttonToTextSendReceiveActivity = (Button)findViewById(R.id.buttonToTextSendReceiveActivity);
        buttonToCastVideoActivity       = (Button)findViewById(R.id.buttonToCastVideoActivity);
        buttonToCastMP3Activity         = (Button)findViewById(R.id.buttonToCastMP3Activity);
        buttonToExitApp                 = (Button)findViewById(R.id.buttonToExitApp);

        buttonToTextSendReceiveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TextSendReceiveActivity.class);
                startActivityForResult(intent,Constants.TEXT_SEND_RECEIVE_RESULT_CODE);
            }
        });

        buttonToCastVideoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CastVideoActivity.class);
                startActivityForResult(intent,Constants.CAST_VIDEO_RESULT_CODE);
            }
        });

        buttonToCastMP3Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CastMP3Activity.class);
                startActivityForResult(intent,Constants.CAST_MP3_RESULT_CODE);
            }
        });

        buttonToExitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mMediaRouteSelector = new MediaRouteSelector.Builder()
                .addControlCategory(CastMediaControlIntent
                .categoryForCast(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID))
                .build();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem mediaRouteMenuItem = menu.findItem(R.id.media_route_menu_item);
        MediaRouteActionProvider mediaRouteActionProvider =
                (MediaRouteActionProvider) MenuItemCompat.getActionProvider(mediaRouteMenuItem);
        mediaRouteActionProvider.setRouteSelector(mMediaRouteSelector);

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMediaRouter.addCallback(mMediaRouteSelector, mMediaRouterCallback,
                MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY);
    }

    @Override
    protected void onPause() {
        if (isFinishing()) {
            mMediaRouter.removeCallback(mMediaRouterCallback);
        }
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMediaRouter.addCallback(mMediaRouteSelector, mMediaRouterCallback,
                MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY);
    }

    @Override
    protected void onStop() {
        mMediaRouter.removeCallback(mMediaRouterCallback);
        super.onStop();
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
}
