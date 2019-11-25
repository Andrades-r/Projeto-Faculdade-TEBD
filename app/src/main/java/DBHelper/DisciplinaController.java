package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DisciplinaController {

    private SQLiteDatabase db;
    private DisciplinaDAO dao;

    public DisciplinaController(Context context ){
        dao = new DisciplinaDAO(context);
    }

    public  String inset(String disciplina){
        ContentValues values;
        long res;
        db = dao.getWritableDatabase();
        values = new ContentValues();
        return "as";
    }

}
