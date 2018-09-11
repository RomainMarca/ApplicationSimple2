package com.example.romain.applicationsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAccept = findViewById(R.id.button);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFirst = findViewById(R.id.Edit_first);
                EditText editLast = findViewById(R.id.Edit_last);
                String firstnameValue = editFirst.getText().toString();
                String lastnameValue = editLast.getText().toString();
                if (firstnameValue.isEmpty() || lastnameValue.isEmpty()){
                    Toast.makeText(context: MainActivity.this, getString(R.string.error_empty), Toast.LENGTH_SHORT).show();
                }else{
                    TextView textCongrat = findViewById(R.id.text_congrat);
                    textCongrat.setVisibility(View.VISIBLE);
                    textCongrat.setText(String.format(getString(R.string.congratt), firstnameValue, lastnameValue));

                }

        }});

        CheckBox checkAccept = findViewById(R.id.checkbox1);
        checkAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
               EditText editFirst = findViewById(R.id.Edit_first);
               EditText editLast = findViewById(R.id.Edit_last);
               Button buttonAccept = findViewById(R.id.button);

               editFirst.setEnabled(isChecked);
               editLast.setEnabled(isChecked);
               buttonAccept.setEnabled(isChecked);
            }
        });
    }
}
