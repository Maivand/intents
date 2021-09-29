package com.mavve.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String currentText;
        String newText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentText = "hejsan svejsan";
        tv = (TextView) (findViewById(R.id.currentText));
        tv.setText(currentText);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == 1){
                newText = data.getStringExtra("EDITEDTEXT");
            System.out.println("RC 1 was triggered");
            System.out.println(newText);
            tv.setText(newText);
            } if(resultCode == 2){
            System.out.println("RC 2 was triggered");
        }
    }

    public void changeActivity(View view) {
        Intent swichActivityIntent = new Intent(this,SecondActivity.class);
        String currentText = tv.getText().toString();
        swichActivityIntent.putExtra("CURRENTTEXT", currentText);

        startActivityForResult(swichActivityIntent,1);

    }
}