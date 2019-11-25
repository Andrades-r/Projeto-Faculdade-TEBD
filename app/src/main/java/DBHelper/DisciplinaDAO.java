package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.renatoandrade.projeto_faculdade_tebd.DisciplinaActivity;

public class DisciplinaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoDisciplinas";
    private static final int VERSAO = 1;

    //TABLE DISCIPLINA



    public DisciplinaDAO(Context context)	{
        super(context,	DATABASE,	null,	VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DDL= "CREATE TABLE Disciplina (id INTEGER PRIMARY KEY,"+ "disciplina TEXT UNIQUE NOT NULL)";
        db.execSQL(DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DDL = "DROP TABLE IF EXISTS Disciplina";
        db.execSQL(DDL);
        onCreate(db);
    }

    public void	salvar(DisciplinaValue disciplinaValue)	{
        ContentValues values	=	new	ContentValues();
        values.put("disciplina",	disciplinaValue.getDisciplina());
        getWritableDatabase().insert("Disciplina",	null,	values	);
    }

}
