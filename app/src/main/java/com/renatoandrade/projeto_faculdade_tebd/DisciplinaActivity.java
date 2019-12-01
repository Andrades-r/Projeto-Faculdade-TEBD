package com.renatoandrade.projeto_faculdade_tebd;

import DBHelper.DisciplinaDAO;
import DBHelper.DisciplinaValue;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisciplinaActivity extends AppCompatActivity {

    private Button botao;
    private EditText edit;
    private DisciplinaValue dv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        edit = (EditText) findViewById(R.id.formDisciplinaId);
        botao = (Button) findViewById(R.id.formSalvarId);

        final DisciplinaDAO dao = new DisciplinaDAO(this);
        DisciplinaValue disciplina = new DisciplinaValue();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tmpDisciplina = edit.getText().toString();
                String disciplina =tmpDisciplina;
                dao.salvar(disciplina);
                dao.close();
                finish();
            }
        });
    }
}
