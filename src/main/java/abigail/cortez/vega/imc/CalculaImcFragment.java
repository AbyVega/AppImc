package abigail.cortez.vega.imc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculaImcFragment extends Fragment {

    EditText etPeso, etTalla;
    TextView  tvResText; ///////variables
    ImageView ivResulytado;
    Button btnCalcular;
    ImageView imagen;
    public CalculaImcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vistaPricipal=inflater.inflate(R.layout.fragment_calcula_imc, container, false);
        etPeso=(EditText) vistaPricipal.findViewById(R.id.etPeso);
        etPeso=(EditText)vistaPricipal.findViewById(R.id.etPeso); ///variables instanciadas
        etTalla=(EditText)vistaPricipal.findViewById(R.id.etTalla);//para convertirlos a objetos java
        tvResText=(TextView)vistaPricipal.findViewById(R.id.tvResText);//y poder darles atributos
        imagen=(ImageView) vistaPricipal.findViewById(R.id.imagen);
        btnCalcular=(Button) vistaPricipal.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso, altura, imc;
                peso=Double.parseDouble(etPeso.getText().toString());
                altura=Double.parseDouble(etTalla.getText().toString());//combierte lo del edit text a dato flotante
                //calculamos el imc=peso/altura**2
                imc=peso/Math.pow(altura,2);

                int situacion=0;
                if(imc<=18.5){//compara los resultados para ver a que caso pertenece
                   situacion=1;
                     }
                if(imc>18.5 && imc<24.99){
                   situacion=2;
                }
                if (imc>25) {
                    situacion=3;
                }
                switch (situacion){
                    case 1://si el resultado pertenece al caso 1 enviara un mensage y una imagen correspndente al resultrado
                        Crouton.makeText(CalculaImcFragment.this.getActivity(),"Bajo peso", Style.INFO).show();//crouton es una libreria
                        Picasso.with(getContext().getApplicationContext()).load(R.drawable.flaco).into(imagen);// libreria
                        break;
                    case 2:
                        Crouton.makeText(CalculaImcFragment.this.getActivity(),"Peso normaln", Style.CONFIRM).show();
                        Picasso.with(getContext().getApplicationContext()).load(R.drawable.normal).into(imagen);
                        break;
                    case 3:
                        Crouton.makeText(CalculaImcFragment.this.getActivity(),"Sobrepeso", Style.ALERT).show();
                        Picasso.with(getContext().getApplicationContext()).load(R.drawable.gordo).into(imagen);
                        break;


                }
                tvResText.setText("Tu indice de masa corporal es de: "+imc);
            }
        });
        return vistaPricipal;
    }

}
