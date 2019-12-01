package com.renatoandrade.projeto_faculdade_tebd;

import DBHelper.DisciplinaDAO;
import DBHelper.DisciplinaValue;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class DisciplinaUpdateActivity extends Activity {

    private DisciplinaValue disciplina;
    private EditText disciplinaNome;
    private Button botaoId;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disiciplina_update);

        disciplinaNome = (EditText) findViewById(R.id.editDisciplinaId);
        botaoId = (Button) findViewById(R.id.updateBotaoId);
        t = (TextView) findViewById(R.id.idDisicplinaView);

        disciplina = (DisciplinaValue) getIntent().getSerializableExtra("disciplina");
        disciplinaNome.setText(disciplina.getDisciplina());
        t.setText(valueOf(disciplina.get_id()));

        botaoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newDisiciplina = disciplinaNome.getText().toString();
                disciplina.setDisciplina(newDisiciplina);
                DisciplinaDAO dao = new DisciplinaDAO(DisciplinaUpdateActivity.this);
                dao.alterar(disciplina);
                dao.close();
                finish();
            }
        });


    }
}
