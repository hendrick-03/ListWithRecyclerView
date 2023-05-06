package ac.mz.listwithrecyclerview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class Dados {

    private String nome, curso;
    private int id, semestre, ano;

    public Dados(String nome, String curso, int id, int semestre, int ano) {
        this.nome = nome;
        this.curso = curso;
        this.id = id;
        this.semestre = semestre;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }



}
