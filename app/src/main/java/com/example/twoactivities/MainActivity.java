package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = ".extra.Message";
    public static final int TEXT_REQUEST = 1;
    private TextView mItem1;
    private TextView mItem2;
    private TextView mItem3;
    private TextView mItem4;
    private TextView mItem5;
    private TextView mItem6;
    private TextView mItem7;
    private TextView mItem8;
    private TextView mItem9;
    private TextView mItem10;
    int itemsSize = 10;
    private TextView[] items = new TextView[itemsSize];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItem1 = findViewById(R.id.item1);
        mItem2 = findViewById(R.id.item2);
        mItem3 = findViewById(R.id.item3);
        mItem4 = findViewById(R.id.item4);
        mItem5 = findViewById(R.id.item5);
        mItem6 = findViewById(R.id.item6);
        mItem7 = findViewById(R.id.item7);
        mItem8 = findViewById(R.id.item8);
        mItem9 = findViewById(R.id.item9);
        mItem10 = findViewById(R.id.item10);
        TextView[] itemsArray = {mItem1, mItem2, mItem3, mItem4, mItem5, mItem5, mItem6, mItem7, mItem8, mItem9, mItem10};
        items = itemsArray;

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                for(int i = 0; i < itemsSize; i++) {
                    if(items[i].getText().toString().isEmpty()){
                        items[i].setText(reply);
                        items[i].setVisibility(View.VISIBLE);
                        break;
                    } else {
                        if(i == itemsSize-1){
                            Toast toast2 = Toast.makeText(
                                    this, "Your shopping list is completely filled out!", Toast.LENGTH_SHORT
                            );
                            toast2.show();
                            break;
                        }
                        if(items[i].getText().toString().contains(reply)){
                            Toast toast1 = Toast.makeText(
                                    this, "Item already exists in the list!", Toast.LENGTH_SHORT
                            );
                            toast1.show();
                            break;
                        }
                    }
                }


            }
        }
    }

    public void resetList(View view) {
        items = new TextView[itemsSize];
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }




}
