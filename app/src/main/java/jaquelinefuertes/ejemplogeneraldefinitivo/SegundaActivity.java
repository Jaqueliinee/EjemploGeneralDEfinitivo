package jaquelinefuertes.ejemplogeneraldefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jaquelinefuertes.ejemplogeneraldefinitivo.databinding.ActivityMainBinding;
import jaquelinefuertes.ejemplogeneraldefinitivo.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    ActivitySegundaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //recibir la info que envio la primera
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){// si no esta vacio
            String texto = bundle.getString("TEXTO");//cojo la info
            binding.lblRecibidoSegunda.setText(texto);//muestro la info
        }

        binding.btnEnviarSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enviar info a la primera
                Intent intent1 = new Intent();
                Bundle mochila = new Bundle();
                mochila.putString("TXT", binding.txtEnviarSegunda.getText().toString());
                intent1.putExtras(mochila);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}