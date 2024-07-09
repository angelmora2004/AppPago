package com.example.apppago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_total;
    private EditText edt_numero;
    private EditText edt_otros;
    private RadioGroup rgrupo;
    private Button btn_salir;
    private Button btn_calcular;
    private TextView txtPropina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos los controles
        edt_total = findViewById(R.id.edt_total);
        edt_numero = findViewById(R.id.edt_numero);
        edt_otros = findViewById(R.id.edt_otros);
        rgrupo = findViewById(R.id.rgrupo);
        btn_salir = findViewById(R.id.btn_salir);
        btn_calcular = findViewById(R.id.btn_calcular);
        txtPropina = findViewById(R.id.txtPropina);

        rgrupo.setOnCheckedChangeListener(((group, checkedId) -> {
            if (checkedId == R.id.r15 || checkedId == R.id.r20) {
                edt_otros.setText("");
                edt_otros.setEnabled(false);
            }
            if (checkedId == R.id.rotros) {
                edt_otros.setText("");
                edt_otros.setEnabled(true);
                edt_otros.requestFocus();
            }
        }));

        // Configurar listeners para los botones
        btn_calcular.setOnClickListener(this);
        btn_salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_calcular:
                int radioCheckedId = rgrupo.getCheckedRadioButtonId();
                if (radioCheckedId == R.id.r15){
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString())* 0.15 + "");
                }
                if (radioCheckedId == R.id.r20){
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString()) * 0.20 + "");
                }
                if (radioCheckedId == R.id.rotros){
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString()) * (Double.parseDouble(edt_otros.getText().toString()) / 100) + "");
                }
                break;
            case R.id.btn_salir:
                finish();
                break;
        }
    }
}