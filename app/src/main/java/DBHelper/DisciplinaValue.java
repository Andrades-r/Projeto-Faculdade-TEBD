package DBHelper;

public class DisciplinaValue implements java.io.Serializable {

    private long _id;
    private String disciplina;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String toString(){
        return this.disciplina;
    }

}
