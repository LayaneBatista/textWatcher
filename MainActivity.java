package br.com.minhaempresa.alunoslista;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText nomeEditText;
    EditText nomeEditText1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = findViewById(R.id.botao1);
        botao.setOnClickListener(this);

        nomeEditText = (EditText) findViewById(R.id.senhaEditText);

        nomeEditText1 = (EditText) findViewById(R.id.senha2EditText);

        nomeEditText.addTextChangedListener(watch);
        nomeEditText1.addTextChangedListener(watch2);



    }

    @Override
    public void onClick(View v) {

        EditText editText1 = findViewById(R.id.sobrenomeEditText);
        EditText editText2 = findViewById(R.id.senha2EditText);
        Context contexto = getApplicationContext();
        EditText editText = findViewById(R.id.nomeEditText);
        String texto = "Bem Vindo, " + editText.getText().toString() + " "+ editText1.getText().toString() + " a sua senha é: " + editText2.getText().toString();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();



    }

    TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence text, int start, int before, int count) {

            EditText editText = findViewById(R.id.nomeEditText);
            EditText editText4 = findViewById(R.id.senha2EditText);
            EditText editText2 = findViewById(R.id.senhaEditText);
            Context contexto = getApplicationContext();
            String texto = "a senha possui o número mínimo de caracteres";
            String texto3 = "a senha não pode ser igual ao primeiro nome";
            int duracao = Toast.LENGTH_LONG;


            if(editText2.getText().length()==5){
                Toast toast2 = Toast.makeText(contexto,texto,duracao);
                toast2.show();

            }
            String e = editText.getText().toString();
            String e2 = editText2.getText().toString();

            if(e.equals(e2)){
                Toast toast = Toast.makeText(contexto,texto3,duracao);
                toast.show();

            }

        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };

    TextWatcher watch2 = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editText4 = findViewById(R.id.senha2EditText);
            EditText editText2 = findViewById(R.id.senhaEditText);
            String e2 = editText2.getText().toString();
            String e3 = editText4.getText().toString();
            Context contexto = getApplicationContext();
            String texto = "as senhas devem ser iguais";
            String texto2 = "as senhas estão iguais";
            int duracao = Toast.LENGTH_LONG;
            if(e3!=e2){
                Toast toast = Toast.makeText(contexto,texto,duracao);
                toast.show();
            }
            if(e3.equals(e2)){
                Toast toast = Toast.makeText(contexto,texto2,duracao);
                toast.show();

            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }

        };
    }
