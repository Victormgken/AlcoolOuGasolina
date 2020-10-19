package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText gas, alcool;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gas = findViewById(R.id.textGas);
        alcool = findViewById(R.id.textAlcool);
        result = findViewById(R.id.result);

    }
    /*
    Take the Alcool Price and Gas Price transform to String.
    Then do the validation, if the validation is true proceeds to the calc
    If AlcoolPrice divided by Gas price is higher or equal to 0.7 it's better use alcool. If not it's better use gasoline.
     */

    public void calculate(View view){
        String alcoolPrice = alcool.getText().toString();
        String gasPrice = gas.getText().toString();
        Boolean validationFields = validation(alcoolPrice, gasPrice);
        if(validationFields){
          Double alcoolValue = Double.parseDouble(alcoolPrice);
          Double gasValue = Double.parseDouble(gasPrice);
          if (alcoolValue/gasValue >= 0.7){
                result.setText("É melhor usar gasolina");
            } else {
                result.setText("É melhor usar Álcool");
            }
        }

    }
    /*
    The validation see if there is something in AlcoolPrice and in GasPrice if not it shows the user the field he need to fill.
     */

    public Boolean validation(String pAlcool, String pGas){
        Boolean validationFields = true;
        if(pAlcool == null || pAlcool.equals("")){
            validationFields = false;
            result.setText("Preencha o campo Preço do Álcool");
        } else if (pGas == null || pGas.equals("")){
            validationFields = false;
            result.setText("Preencha o campo Preço da Gasolina");
        }
        return validationFields;
    }
}