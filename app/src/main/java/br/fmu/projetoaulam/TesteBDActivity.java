package br.fmu.projetoaulam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class TesteBDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_bdactivity);
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDAO();
        Funcionario funcionario = new Funcionario(1,"Func1",new Date(), 2000,"Analista");
        dao.insert(funcionario);
    }
}