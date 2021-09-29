package com.mavve.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
        String currentText;
        String editedText;
        EditText editCurrentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button secondButton = (Button)findViewById(R.id.buttonDone);
        editCurrentText = (EditText)findViewById(R.id.editCurrentText);

        Intent intent = getIntent();

        currentText = intent.getStringExtra("CURRENTTEXT");
        editCurrentText.setText(currentText);

    }

    public void doneClick(View view) {
        editedText = String.valueOf(editCurrentText.getText());
        Intent intent = new Intent();
        intent.putExtra("EDITEDTEXT",editedText);
        System.out.println("second btn");
        setResult(1,intent);
        finish();
    }
}