package com.mavve.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String currentText;
    String newText;
    SharedPreferences sh;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentText = "hejsan svejsan";
        tv = (TextView) (findViewById(R.id.currentText));
        sh = getSharedPreferences("EDITOR", MODE_PRIVATE);
        currentText = sh.getString("NEWTEXT", "mavve was not here");
        tv.setText(currentText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1) {
            newText = data.getStringExtra("EDITEDTEXT");
            System.out.println("RC 1 was triggered");
            System.out.println(newText);
            tv.setText(newText);
            editor = sh.edit();
            editor.putString("NEWTEXT", newText);
            editor.commit();
            Toast.makeText(this,"text was saved",Toast.LENGTH_LONG).show();
        }
        if (resultCode == 2) {
            System.out.println("RC 2 was triggered");
        }
    }

    public void changeActivity(View view) {
        Intent swichActivityIntent = new Intent(this, SecondActivity.class);
        String currentText = tv.getText().toString();
        swichActivityIntent.putExtra("CURRENTTEXT", currentText);

        startActivityForResult(swichActivityIntent, 1);

    }
}