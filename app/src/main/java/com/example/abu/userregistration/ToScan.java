package com.example.abu.userregistration;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Precision.Component.FP.BiomSDK.BiometricComponent;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class ToScan extends AppCompatActivity {

    //TextView USNDisplay;
    Button save;
    Button scan;
    byte[] isoTemplate;
    DBHandler DBHandler;
    final BiometricComponent biometricComponent = new BiometricComponent(ToScan.this);
    TextView USNDisplay = (TextView) findViewById(R.id.USNDisplay);

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_scan);
        Button scan = (Button) findViewById(R.id.scan);
        Button save = (Button) findViewById(R.id.save);
        //final BiometricComponent biometricComponent = new BiometricComponent(ToScan.this)
        DBHandler = new DBHandler(this, null, null, 1);
       // String passedValue = getIntent().getExtras().getString(USN);
       // USNDisplay.setText(passedValue);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("USN");
        //TextView txtView = (TextView) findViewById(R.id.your_resource_textview);
        USNDisplay.setText(message);
    }


    public void onClick(View v) {
        int result = biometricComponent.FPCapture(1);
        if (result == 0) {
            isoTemplate = biometricComponent.getISOTemplate();
            Toast.makeText(getApplicationContext(), "Finger Print Sucessfully Captured", Toast.LENGTH_SHORT).show();
        } else if (result == -1) {
            Toast.makeText(getApplicationContext(), "Finger Print Capture Failed", Toast.LENGTH_SHORT).show();
        } else if (result == 500) {
            Toast.makeText(getApplicationContext(), "License Failed", Toast.LENGTH_SHORT).show();
        } else if (result == -501) {
            Toast.makeText(getApplicationContext(), "License Not Found", Toast.LENGTH_SHORT).show();
        } else if (result == 600) {
            Toast.makeText(getApplicationContext(), "Scanner Initialization Failed", Toast.LENGTH_SHORT).show();
        } else if (result == 700) {
            Toast.makeText(getApplicationContext(), "No Scanner Found", Toast.LENGTH_SHORT).show();
        } else if (result == 701) {
            Toast.makeText(getApplicationContext(), "Image Not Captured", Toast.LENGTH_SHORT).show();
        } else if (result == 702) {
            Toast.makeText(getApplicationContext(), "Extraction Failed", Toast.LENGTH_SHORT).show();
        } else if (result == 704) {
            Toast.makeText(getApplicationContext(), "Generate ISO Image Failed", Toast.LENGTH_SHORT).show();
        } else if (result == 707) {
            Toast.makeText(getApplicationContext(), "Scanner Already Initalized", Toast.LENGTH_SHORT).show();
        } else if (result == 718) {
            Toast.makeText(getApplicationContext(), "Exeption In Process", Toast.LENGTH_SHORT).show();
        }

    }

    public void addToDB() {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(getIntent().getExtras().getString("USN"), isoTemplate);
    }


    /*@Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ToScan Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.abu.userregistration/http/host/path")
        );
       // AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ToScan Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.abu.userregistration/http/host/path")
        );
      //  AppIndex.AppIndexApi.end(client, viewAction);
      //  client.disconnect();
    }*/
}
