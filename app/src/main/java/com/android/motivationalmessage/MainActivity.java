package com.android.motivationalmessage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

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

        btnGenerateMsg.setOnClickListener(view -> {
            String name = etName.getText().toString();

            if (!name.isEmpty()) {
                String[] arrayString = {
                        "Hi " + name + ", you are amazing!",
                        "Hi " + name + ", just remember, nobody owes you anything.",
                        "Hi " + name + ", just hang in there, you got this.",
                        "Hi " + name + ", remember, giving up is never the option.",
                        "Hi " + name + ", remember why you started in the first place.",
                        "Hi " + name + ", you are better than you think."
                };

                Random random = new Random();

                int randomString = random.nextInt(arrayString.length);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage(arrayString[randomString]);
                dialog.setNegativeButton("OK", (dialogInterface, i) -> {
                    //No action needed here
                });
                dialog.show();
                etName.setText("");
            }
            else{
                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            }
        });
    }
}