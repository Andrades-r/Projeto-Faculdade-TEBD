package com.renatoandrade.projeto_faculdade_tebd;

import DBHelper.DisciplinaDAO;
import DBHelper.DisciplinaValue;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private TextView viewDisciplina;
    private DisciplinaValue disciplinaValue;
    private ArrayList<DisciplinaValue> disciplinas;
    private ArrayAdapter<DisciplinaValue> adapterDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String[] disciplinas = {"Algoritmo", "Redes", "TEBD", "TELP", "Contabilidade", "Calculo 1", "Calculo 2", "Gerência de Projetos"};

        lista = (ListView) findViewById(R.id.listViewId);
        viewDisciplina = (TextView) findViewById(R.id.selecionadaId);
        int layout = android.R.layout.simple_list_item_1;

        DisciplinaDAO dao = new DisciplinaDAO(this);
        disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());
        dao.close();

        adapterDisciplina = new ArrayAdapter<DisciplinaValue>(this, layout, disciplinas);
        lista.setAdapter(adapterDisciplina);
        this.registerForContextMenu(lista);



    }

    protected void onResume()	{
        super.onResume();
        lista = (ListView) findViewById(R.id.listViewId);
        DisciplinaDAO dao	=	new	DisciplinaDAO(this);
        disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());
        dao.close();
        int	layout	=	android.R.layout.simple_list_item_1;
        ArrayAdapter<DisciplinaValue>	adapter	= new ArrayAdapter<DisciplinaValue>(this,layout,	disciplinas);
        lista.setAdapter(adapter);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_disciplinas,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        disciplinaValue=	(DisciplinaValue)
                this.adapterDisciplina.getItem(((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
        switch(item.getItemId()){
            case R.id.action_new:
                Intent intent = new Intent(this,DisciplinaActivity.class);
                intent.putExtra("algo",disciplinaValue);
                startActivity(intent);
                return true;
            case R.id.action_delete:
                DisciplinaDAO dao = new DisciplinaDAO(MainActivity.this);
                dao.delete(disciplinaValue);
                dao.close();
                Toast.makeText(this, "deletado", Toast.LENGTH_SHORT).show();
                this.onResume();
                return true;
            case R.id.action_update:
                Intent intenti = new Intent(this, DisciplinaUpdateActivity.class);
                intenti.putExtra("disciplina",disciplinaValue);
                startActivity(intenti)  ;
                return true;
                default:
                    return super.onContextItemSelected(item);
        }

    }
}
