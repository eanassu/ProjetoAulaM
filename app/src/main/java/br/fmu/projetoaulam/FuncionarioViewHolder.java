package br.fmu.projetoaulam;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FuncionarioViewHolder extends RecyclerView.ViewHolder{
    final TextView re;
    final TextView nome;
    final TextView dataAdmissao;
    final TextView salario;
    final TextView funcao;
    public FuncionarioViewHolder( View itemView ) {
        super(itemView);
        re = itemView.findViewById(R.id.textViewRe);
        nome = itemView.findViewById(R.id.textViewNome);
        dataAdmissao = itemView.findViewById(R.id.textViewDataAdm);
        salario = itemView.findViewById(R.id.textViewSalario);
        funcao = itemView.findViewById(R.id.textViewFuncao);
    }
}
