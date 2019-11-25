package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.renatoandrade.projeto_faculdade_tebd.DisciplinaActivity;

import java.util.LinkedList;
import java.util.List;

public class DisciplinaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoDisciplinas";
    private static final int VERSAO = 1;

    //TABLE DISCIPLINA



    public DisciplinaDAO(Context context)	{
        super(context,	DATABASE,	null,	VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DDL= "CREATE TABLE Disciplina (id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "disciplina TEXT UNIQUE NOT NULL)";
        db.execSQL(DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DDL = "DROP TABLE IF EXISTS Disciplina";
        db.execSQL(DDL);
        onCreate(db);
    }

    public void salvar (String disciplaVal){
        ContentValues values = new ContentValues();
        values.put("disciplina", disciplaVal);

        getWritableDatabase().insert("Disciplina",null,values);
    }
/*
    public void delete(DisciplinaValue disc){
        String[] args;
        args = new String[]{disc.get_id().toString()};
        getWritableDatabase().delete("Disciplina", "id=?", args);
    }

    public void alterar(DisciplinaValue disc){
        ContentValues val = new ContentValues();
        val.put("disciplina", disc.getDisciplina());

        getWritableDatabase().update("disciplina", val, "id=?",new String[] {disc.get_id().toString()});
    }
*/




    public List getLista(){
        List<DisciplinaValue> disciplinas = new LinkedList<DisciplinaValue>();

        String q = "SELECT * FROM "+"Disciplina ORDER BY disciplina";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(q,null);

        DisciplinaValue disciplina = null;
        if( cursor.moveToFirst()){
            do{
                disciplina = new DisciplinaValue();
                disciplina.set_id(Long.parseLong(cursor.getString(0)));
                disciplina.setDisciplina(cursor.getString(1));
                disciplinas.add(disciplina);
            }while(cursor.moveToNext());
        }
        return disciplinas;
    }




}
