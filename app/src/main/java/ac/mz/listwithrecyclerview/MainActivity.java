package ac.mz.listwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome, id, curso, semestre, ano;
    private Button save, listar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome_ed);
        id = findViewById(R.id.id_ed);
        curso = findViewById(R.id.curso_ed);
        semestre = findViewById(R.id.semestre_ed);
        ano = findViewById(R.id.ano_ed);

        save = findViewById(R.id.gravarbtn);
        listar = findViewById(R.id.listarbtn);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int ide = Integer.parseInt(id.getText().toString());
                    String name = nome.getText().toString();
                    String crs = curso.getText().toString();
                    int year = Integer.parseInt(ano.getText().toString());
                    int smstr = Integer.parseInt(semestre.getText().toString());



                    Dados dados = new Dados(name, crs, ide, smstr,year);
                    DataAcessObject.dados.add(dados);


                    Toast.makeText(MainActivity.this, "Gravado com sucesso", Toast.LENGTH_SHORT).show();

                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "Preecnha os campos correctamente", Toast.LENGTH_SHORT).show();
                }


            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListarActivity.class);

                for (Dados dados : DataAcessObject.dados){
                    i.putExtra("id", dados.getId());
                    i.putExtra("nome", dados.getNome());
                    i.putExtra("curso", dados.getCurso());
                    i.putExtra("ano", dados.getAno());
                    i.putExtra("semestre", dados.getSemestre());


                }
                startActivity(i);


            }
        });






    }
}