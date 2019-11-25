package com.renatoandrade.projeto_faculdade_tebd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisciplinaActivity extends AppCompatActivity {

    private Button botao;
    private EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        edit = (EditText) findViewById(R.id.formDisciplinaId);
        botao = (Button) findViewById(R.id.formSalvarId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
