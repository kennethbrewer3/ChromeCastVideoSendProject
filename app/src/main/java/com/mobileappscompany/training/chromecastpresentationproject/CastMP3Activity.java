package com.mobileappscompany.training.chromecastpresentationproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class CastMP3Activity extends ActionBarActivity {

    private Context context;
    private Button  buttonCastMP3Action;
    private Button  buttonReturnToMainFromCastMP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_mp3);

        context = this;

        buttonCastMP3Action           = (Button)findViewById(R.id.buttonCastMP3Action);
        buttonReturnToMainFromCastMP3 = (Button)findViewById(R.id.buttonReturnToMainFromCastMP3);

        buttonCastMP3Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.showNotYetImplementedToast(context);
            }
        });

        buttonReturnToMainFromCastMP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(Constants.TEXT_SEND_RECEIVE_RESULT_CODE,intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cast_mp3, menu);
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
}
