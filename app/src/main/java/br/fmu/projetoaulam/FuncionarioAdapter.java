package br.fmu.projetoaulam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter {
    private static final String TAG="FuncionarioAdapter";
    private List<Funcionario> funcionarios;
    private Context context;
    public FuncionarioAdapter(List<Funcionario> funcionarios, Context context) {
        this.funcionarios = funcionarios;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_funcionario,parent,false);
        return new FuncionarioViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG,"position:"+position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FuncionarioViewHolder funcionarioViewHolder =(FuncionarioViewHolder) holder;
        Funcionario funcionario = funcionarios.get(position);
        funcionarioViewHolder.re.setText(Integer.toString(funcionario.getRe()));
        funcionarioViewHolder.nome.setText(funcionario.getNome());
        funcionarioViewHolder.dataAdmissao.setText(dateFormat.format(funcionario.getDataAdmissao()));
        funcionarioViewHolder.salario.setText(Double.toString(funcionario.getSalario()));
        funcionarioViewHolder.funcao.sextText(funcionario.getFuncao());
    }
    @Override
    public int getItemCount() {
        return funcionarios.size();
    }
}
