package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkQuarto, checkCozinha, checkGaragem, checkSala, checkBanheiro;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome       = findViewById(R.id.editNome);
        textoResultado  = findViewById(R.id.textResultado);
        campoEmail      = findViewById(R.id.editEmail);

        //CheckBox
        checkQuarto      = findViewById(R.id.checkQuarto);
        checkCozinha     = findViewById(R.id.checkCozinha);
        checkGaragem     = findViewById(R.id.checkGaragem);
        checkSala        = findViewById(R.id.checkSala);
        checkBanheiro    = findViewById(R.id.checkBanheiro);

        //RadioButton
        sexoFeminino = findViewById(R.id.radioButtonF);
        sexoMasculino = findViewById(R.id.radioButtonM);
        opcaoSexo = findViewById(R.id.radioGroupSexo);

        observe();
    }

    public void observe() {

        String masculino = "Masculino";
        String femino = "Feminino";

        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButtonM) {

                    Toast.makeText(getApplicationContext(),masculino, Toast.LENGTH_SHORT).show();
                }
                else if(i == R.id.radioButtonF){
                    Toast.makeText(getApplicationContext(),femino, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String textRadiobutton () {

        String texto = "";
        if(sexoMasculino.isChecked()) {
            texto = "Masculino";
        }
        else {
            texto = "Feminino";
        }
        return texto;
    }

    public String textCheckbox () {

        String texto = "";
        if(checkQuarto.isChecked()){
            String corSelecionado = checkQuarto.getText().toString();
            texto += corSelecionado + ", " ;
        }
        if(checkCozinha.isChecked()){
            String corSelecionado = checkCozinha.getText().toString();
            texto += corSelecionado + ", ";
        }
        if(checkGaragem.isChecked()){
            String corSelecionado = checkGaragem.getText().toString();
            texto += corSelecionado + ", ";
        }
        if(checkSala.isChecked()){
            String corSelecionado = checkSala.getText().toString();
            texto += corSelecionado + ", ";
        }
        if(checkBanheiro.isChecked()){
            String corSelecionado = checkBanheiro.getText().toString();
            texto += corSelecionado + ", ";
        }

        return texto;
    }

    public void enviar(View view){
        String checkbox = textCheckbox();
        String radioButton = textRadiobutton();

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText("nome: " +nome + " email: " + email + "\n" + checkbox + "\n" + radioButton);

    }

    public void Limpar(View view) {

        campoNome.setText("");
        campoEmail.setText("");
        checkQuarto.setChecked(false);
        checkCozinha.setChecked(false);
        checkGaragem.setChecked(false);
        checkSala.setChecked(false);
        checkBanheiro.setChecked(false);
        textoResultado.setText("");
        opcaoSexo.clearCheck();

    }
}