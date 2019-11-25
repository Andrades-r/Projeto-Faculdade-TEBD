package com.renatoandrade.projeto_faculdade_tebd;

import DBHelper.DisciplinaDAO;
import DBHelper.DisciplinaValue;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listV;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_disciplinas,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_new:
                Intent intent = new Intent(this, DisciplinaActivity.class);
                startActivity(intent);
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String[] disciplinas = {"Algoritmo", "Redes", "TEBD", "TELP", "Contabilidade", "Calculo 1", "Calculo 2", "Gerência de Projetos"};
        listV = (ListView) findViewById(R.id.listViewId);
        int layout = android.R.layout.simple_list_item_1;
        DisciplinaDAO dao = new DisciplinaDAO(this);

        final ArrayList<DisciplinaValue> disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());
        dao.close();

        ArrayAdapter<DisciplinaValue> adapter = new ArrayAdapter<DisciplinaValue>(this, layout, disciplinas);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Disciplina Selecionada:\n"+disciplinas.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void onResume()	{
        super.onResume();
        listV = (ListView) findViewById(R.id.listViewId);
        DisciplinaDAO dao	=	new	DisciplinaDAO(this);
        ArrayList<DisciplinaValue>	disciplinas=	new	ArrayList(dao.getLista());
        dao.close();
        int	layout	=	android.R.layout.simple_list_item_1;
        ArrayAdapter<DisciplinaValue>	adapter	= new ArrayAdapter<DisciplinaValue>(this,layout,	disciplinas);
        listV.setAdapter(adapter);
    }
}
