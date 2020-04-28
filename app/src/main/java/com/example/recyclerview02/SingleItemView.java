package com.example.recyclerview02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemView extends AppCompatActivity {

    TextView name;
    TextView id;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view);

        ActionBar actionBar = getSupportActionBar();

        name = findViewById(R.id.item_name);
        id = findViewById(R.id.item_id);
        status = findViewById(R.id.item_status);

        Intent intent = getIntent();
        String mName = intent.getStringExtra("iName");
        String mId = intent.getStringExtra("iId");
        String mStatus = intent.getStringExtra("iStatus");

        name.setText(mName);
        id.setText(mId);
        status.setText(mStatus);
    }
}
