package com.gabrielantonio.ramos.velasco.holamundoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaTActivity extends AppCompatActivity {

    private EditText editTextXA;
    private EditText editTextYA;
    private EditText editTextTotalA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_tactivity);
        editTextXA = findViewById(R.id.editTextNumberXA );


        editTextTotalA = findViewById(R.id.editTextNumberTotalA);
        editTextXA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus )
                {
                    realizaOperacion();
                }
            }
        });
        editTextYA = findViewById(R.id.editTextNumberYA );
        editTextYA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus )
                {
                    realizaOperacion();
                }
            }
        });


    }


    private void realizaOperacion() {
        float total=0;
        String resultado="";
        if(editTextXA.getText().toString() != null){
            float num1 = convertirFloat(editTextXA.getText().toString());
            total+=num1;
        }else{}
        if(editTextYA.getText().toString() != null){
            float num2 = convertirFloat(editTextYA.getText().toString());
            total*=num2;
            float area = (float) (total/2);
            resultado = Float.toString(area);
        }else{}

        editTextTotalA.setText(resultado, TextView.BufferType.SPANNABLE );
        editTextTotalA.setEnabled(false);
    }

    private float convertirFloat(String num){
        try
        {
            return Float.parseFloat(num);
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 1;
    }
}