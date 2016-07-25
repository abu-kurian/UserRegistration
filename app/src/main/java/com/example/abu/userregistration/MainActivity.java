package com.example.abu.userregistration;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   // Button USNbutton;
    EditText USN;
    Button USNbutton = (Button) findViewById(R.id.USNbutton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText USN = (EditText) findViewById(R.id.USN);
    }

    public void onClick(View v) {
        Intent i = new Intent(this, ToScan.class);
        if (USN.getText() != null) {
            i.putExtra("USN", USN.getText());
            startActivity(i);
        }
   /* USNbutton onClick()
    {
        new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(this, ToScan.class);
                if(USN.getText() != null)
                {
                    i.putExtra("USN",USN.getText());
                    startActivity(i);
            }
        }

    }*/
    }
}

