package br.edu.ifsp.hto.exemplo20.fragment;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import br.edu.ifsp.hto.exemplo20.R;
import br.edu.ifsp.hto.exemplo20.domain.Departamento;
import br.edu.ifsp.hto.exemplo20.domain.DepartamentoService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marcio on 02/06/2016.
 */


public class NewDepartamentoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewDepartamentoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdicionarDepartamentoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewDepartamentoFragment newInstance(String param1, String param2) {
        NewDepartamentoFragment fragment = new NewDepartamentoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_departamento, container, false);
        Button btSalvar = (Button) view.findViewById(R.id.btNovoDepartamento);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoDepartamento();
            }
        });
        return view;
    }

    public void novoDepartamento() {
        String baseURL = "http://192.168.69.103:8090/";


        EditText etNomeDep = (EditText) getView().findViewById(R.id.etNomeDep);
        EditText etLocalDep = (EditText) getView().findViewById(R.id.etLocalDep);

        Departamento departamento = new Departamento();



        departamento.setNome(etNomeDep.getText().toString());
        departamento.setLocal(etLocalDep.getText().toString());

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);

        Call<Departamento> call = service.newDepartamento(departamento);

        call.enqueue(new Callback<Departamento>() {
            @Override
            public void onResponse(Call<Departamento> call, Response<Departamento> response) {

            }

            @Override
            public void onFailure(Call<Departamento> call, Throwable t) {

            }
        });
        Toast.makeText( getContext(), "Departamento Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        etNomeDep.setText("");
        etLocalDep.setText("");
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
