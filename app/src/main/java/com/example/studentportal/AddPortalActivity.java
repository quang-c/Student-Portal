package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {

    private EditText titleText;
    private EditText urlText;
    private Button addPortalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleText = findViewById(R.id.editTitle);
        urlText = findViewById(R.id.editUrl);
        addPortalButton = findViewById(R.id.addPortalButton);

        addPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //user input to string
                String title = titleText.getText().toString();
                String url = urlText.getText().toString();

                if (title.length() != 0 && url.length() != 0) {
                    Portal newPortal = new Portal(title, url);
                    MainActivity.mPortals.add(newPortal);

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.NEW_PORTAL, "");
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    Snackbar.make(view, "Please enter the portal title and url", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }
}
