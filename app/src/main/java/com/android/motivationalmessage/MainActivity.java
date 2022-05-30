package com.android.motivationalmessage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
    EditText etName;
    Button btnGenerateMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnGenerateMsg = findViewById(R.id.btnGenerateMsg);

        btnGenerateMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = etName.getText().toString();
                String[] arrayString = {
                        "Hi " +name+ ", you are amazing!",
                        "Hi " +name+ ", just remember, nobody owes you anything.",
                        "Hi " +name+ ", just hang in there, you got this.",
                        "Hi " +name+ ", remember, giving up is never the option.",
                        "Hi " +name+ ", remember why you started in the first place.",
                        "Hi " +name+ ", you are better than you think."
                };

                Random random = new Random();

                int randomString = random.nextInt(arrayString.length);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage(arrayString[randomString]);
                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //No action needed here
                    }
                });
                dialog.show();
            }
        });
    }
}