package ac.mz.listwithrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private static ArrayList<Dados> listar;


    //Construtor da classe Adapter que
    // recebe como parâmetro uma lista de objetos do tipo Dados.
    // Essa lista será atribuída à variável estática listar.
    Adapter(ArrayList<Dados> dados) {
        listar = dados;
    }

    @NonNull
    @Override
    //Método que cria e retorna um novo objeto
    // ViewHolder que representa um item da lista.
    // Nesse método é inflada a view do layout rowitem
    // e retornada um objeto ViewHolder contendo essa view.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //Método que associa os dados de um objeto da lista
    // à view de um ViewHolder. Nesse método,
    // o nome do objeto da lista na posição position
    // é associado ao TextView nomeTv do ViewHolder passado como parâmetro.
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (listar != null) {
            holder.nomeTv.setText(listar.get(position).getNome());


        }
    }

    @Override
    //Método que retorna a quantidade
    // de itens da lista. Se a lista for nula, retorna 0.
    public int getItemCount() {
        if (listar != null) {
            return listar.size();
        }
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeTv;
        private Button excluirbtn;

        private TextView id_dt, nome_dt, curso_dt, ano_dt, semestre_dt;


        // Construtor da classe ViewHolder que recebe como parâmetro a view inflada no método
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Nesse método são inicializados todos os TextViews presentes na view
            // e é configurado um listener de clique para a view do item.


            nomeTv = itemView.findViewById(R.id.nome_tv);

            id_dt = itemView.findViewById(R.id.id_detalhes_Tv);
            nome_dt = itemView.findViewById(R.id.nome_detalhes_tv);
            curso_dt = itemView.findViewById(R.id.curso_detalhes_tv);
            ano_dt = itemView.findViewById(R.id.ano_detalhes_tv);
            semestre_dt = itemView.findViewById(R.id.semestre_detalhes_tv);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abrirActivity();
                }
            });
        }

        public void abrirActivity() {
            Intent i = new Intent(itemView.getContext(), DetalhesActivity.class);
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listar != null) {
                i.putExtra("id", listar.get(position).getId());
                i.putExtra("nome", listar.get(position).getNome());
                i.putExtra("curso", listar.get(position).getCurso());
                i.putExtra("ano", listar.get(position).getAno());
                i.putExtra("semestre", listar.get(position).getSemestre());
                itemView.getContext().startActivity(i);
            }
        }
    }
}




