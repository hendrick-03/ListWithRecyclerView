package ac.mz.listwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    private TextView id_dt,nome_dt, curso_dt, ano_dt, semestre_dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        id_dt = findViewById(R.id.id_detalhes_Tv);
        nome_dt = findViewById(R.id.nome_detalhes_tv);
        curso_dt = findViewById(R.id.curso_detalhes_tv);
        ano_dt = findViewById(R.id.ano_detalhes_tv);
        semestre_dt = findViewById(R.id.semestre_detalhes_tv);


        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            int id = bundle.getInt("id");
            String nome = bundle.getString("nome");
            String curso = bundle.getString("curso");
            int ano = bundle.getInt("ano");
            int semestre = bundle.getInt("semestre");

            id_dt.setText(String.valueOf(id));
            nome_dt.setText(nome);
            curso_dt.setText(curso);
            ano_dt.setText(String.valueOf(ano));
            semestre_dt.setText(String.valueOf(semestre));
        }


    }
}