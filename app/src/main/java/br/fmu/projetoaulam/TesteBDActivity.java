package br.fmu.projetoaulam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteBDActivity extends AppCompatActivity {

    private EditText editTextRe;
    private EditText editTextNome;
    private EditText editTextDataAdmissao;
    private EditText editTextSalario;
    private EditText editTextCargo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_bdactivity);
        editTextRe = findViewById(R.id.editTextRe);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataAdmissao = findViewById(R.id.editTextDataAdmissao);
        editTextSalario = findViewById(R.id.editTextSalario);
        editTextCargo = findViewById(R.id.editTextCargo);
    }

    public void cadastrar(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDAO();
        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao = null;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        String funcao = editTextCargo.getText().toString();
        Funcionario funcionario = new Funcionario(re,nome, dataAdmissao, salario,funcao);
        dao.insert(funcionario);
        System.out.println("Cadastrado");
    }

    public void excluir(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDAO();
        int re = Integer.parseInt(editTextRe.getText().toString());
        Funcionario funcionario = dao.buscarPeloRe(re);
        dao.delete(funcionario);
        System.out.println("Excluido");
    }

    public void alterar(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDAO();
        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();

        Date dataAdmissao = null;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        String funcao = editTextCargo.getText().toString();
        Funcionario funcionario = new Funcionario(re,nome, dataAdmissao, salario,funcao);
        dao.update(funcionario);
        System.out.println("Atualizado");
    }

    public void buscar( View view ) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDAO();
        int re = Integer.parseInt(editTextRe.getText().toString());
        Funcionario funcionario = dao.buscarPeloRe(re);
        editTextNome.setText(funcionario.getNome());
        editTextDataAdmissao.setText(dateFormat.format(funcionario.getDataAdmissao()));
        editTextSalario.setText(Double.toString(funcionario.getSalario()));
        editTextCargo.setText(funcionario.getFuncao());
    }

}