package br.com.minhaempresa.alunoslista;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    List<String> nomesLista = new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomesLista.add("João");
        nomesLista.add("Maria");
        nomesLista.add("José");
        nomesLista.add("Emanuel");
        nomesLista.add("Joaquim");

        Button botao = findViewById(R.id.botao1);
        botao.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.list1);
        adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1,nomesLista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.edi1);
        String nomes = editText.getText().toString();

        nomesLista.add(nomes);
        adapter.notifyDataSetChanged();
        
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
