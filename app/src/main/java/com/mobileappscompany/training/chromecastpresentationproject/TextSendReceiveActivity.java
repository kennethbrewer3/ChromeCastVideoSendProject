package com.mobileappscompany.training.chromecastpresentationproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TextSendReceiveActivity extends ActionBarActivity {

    private Context context;
    private EditText editTextToCast;
    private Button performAction;
    private Button buttonPreloadedText;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_send_receive);

        context = this;

        editTextToCast       = (EditText)findViewById(R.id.editTextToCast);
        performAction        = (Button)findViewById(R.id.buttonPerformAction);
        buttonPreloadedText  = (Button)findViewById(R.id.buttonPreloadedText);
        buttonClear          = (Button)findViewById(R.id.buttonClear);

        performAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(Constants.TEXT_TO_SEND_TAG,editTextToCast.getText().toString());
                setResult(Constants.TEXT_SEND_RECEIVE_RESULT_CODE,intent);
                finish();
            }
        });

        buttonPreloadedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextToCast.setText(getString(R.string.preloaded_text));
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                editTextToCast.setText("");
             }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_send_receive, menu);
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
