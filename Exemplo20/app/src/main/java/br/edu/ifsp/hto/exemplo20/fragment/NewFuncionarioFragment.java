package br.edu.ifsp.hto.exemplo20.fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.edu.ifsp.hto.exemplo20.R;
import br.edu.ifsp.hto.exemplo20.adapter.DepartamentoAdapter;
import br.edu.ifsp.hto.exemplo20.domain.Chefe;
import br.edu.ifsp.hto.exemplo20.domain.ChefeService;
import br.edu.ifsp.hto.exemplo20.domain.Departamento;
import br.edu.ifsp.hto.exemplo20.domain.DepartamentoService;
import br.edu.ifsp.hto.exemplo20.domain.Funcionario;
import br.edu.ifsp.hto.exemplo20.domain.FuncionarioService;
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
public class NewFuncionarioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Context context;
    private String baseURL = "http://192.168.69.103:8090/";
    private ExpandableListView listViewDepartamento;
    private ExpandableListView listViewChefe;
    private Departamento nDepartamento;
    private Spinner deps;
    private Spinner chefs;




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;

    public NewFuncionarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdicionarFuncionarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewFuncionarioFragment newInstance(String param1, String param2) {
        NewFuncionarioFragment fragment = new NewFuncionarioFragment();
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
        View view = inflater.inflate(R.layout.fragment_novo_funcionario, container, false);
        Button btSalvarFuncionario = (Button) view.findViewById(R.id.btNovoFuncionario);
        btSalvarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoFuncionario();
            }
        });

        context = container.getContext();

        listarDepartamentos();
        listarChefes();

        return view;
    }

    private void listarChefes() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ChefeService service = retrofit.create(ChefeService.class);
        Call<List<Chefe>> listCall = service.listaChefe();
        listCall.enqueue(new Callback<List<Chefe>>() {
            @Override
            public void onResponse(Call<List<Chefe>> call, Response<List<Chefe>> response) {
                final List<Chefe> chefes = response.body();
                String array_spinner[]=new String[chefes.size()];

                for (int i =0; i < chefes.size(); i++){
                    Chefe chefe = chefes.get(i);
                    array_spinner[i]=chefe.getNome();

                }

                chefs = (Spinner) getView().findViewById(R.id.sChefe);
                ArrayAdapter adap = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,array_spinner);
                chefs.setAdapter(adap);

            }

            @Override
            public void onFailure(Call<List<Chefe>> call, Throwable t) {

            }
        });

    }

    private void listarDepartamentos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> listCall = service.listDepartamento();
        listCall.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                final List<Departamento> departamentos = response.body();
                String array_spinner[]=new String[departamentos.size()];

                for (int i =0; i < departamentos.size(); i++){
                    Departamento departamento = departamentos.get(i);
                    array_spinner[i]=departamento.getNome();

                }

                deps = (Spinner) getView().findViewById(R.id.sDep);
                ArrayAdapter adap = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,array_spinner);
                deps.setAdapter(adap);

            }
            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });
    }

    public void novoFuncionario() {
        EditText etNomeFunc = (EditText) getView().findViewById(R.id.etFuncNome);
        EditText etCargoFunc = (EditText) getView().findViewById(R.id.etFuncCargo);
        EditText etSalFun = (EditText) getView().findViewById(R.id.etFuncSal);
        EditText etDiaFun = (EditText) getView().findViewById(R.id.etDiaFun);
        EditText etMesFun = (EditText) getView().findViewById(R.id.etMesFun);
        EditText etAnoFun = (EditText) getView().findViewById(R.id.etAnoFun);
        EditText etComFun = (EditText) getView().findViewById(R.id.etComFun);



        String nome = etNomeFunc.getText().toString();
        String cargo = etCargoFunc.getText().toString();
        Double sal = Double.parseDouble(etSalFun.getText().toString());
        int idDep = deps.getSelectedItemPosition();
        int idChef = chefs.getSelectedItemPosition();
        int dia = Integer.parseInt(etDiaFun.getText().toString());
        int mes = Integer.parseInt(etMesFun.getText().toString());
        int ano = Integer.parseInt(etAnoFun.getText().toString());
        String data= ano+"-"+mes+"-"+dia;
        Double com =Double.parseDouble(etComFun.getText().toString());

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        FuncionarioService service = retrofit.create(FuncionarioService.class);

        Call<Funcionario> call = service.criaFuncionario(nome,cargo,idChef,data,sal,com,idDep);


        call.enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                Toast.makeText(getContext(),"Funcionario cadastrado",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable t) {

            }
        });

        etAnoFun.setText("");
        etCargoFunc.setText("");
        etComFun.setText("");
        etDiaFun.setText("");
        etMesFun.setText("");
        etNomeFunc.setText("");
        etSalFun.setText("");


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
