package jaquelinefuertes.ejemplogeneraldefinitivo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jaquelinefuertes.ejemplogeneraldefinitivo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> launcherEjemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarLaunchers();
        binding.btnEnviarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TEXTO", binding.txtEnviarMain.getText().toString());
                intent.putExtras(bundle);
                launcherEjemplo.launch(intent);
            }
        });
    }

    private void inicializarLaunchers() {
        launcherEjemplo = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK){//recibir informacion creo
                    if (o.getData() != null && o.getData().getExtras() != null){//lo que me queria enviar se ha enviado correctamente
                        String texto = o.getData().getExtras().getString("TXT");
                        binding.lblRecibirMain.setText(texto);
                    }
                }
            }
        });
    }
}