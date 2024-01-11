package wow.startup.ci.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wow.startup.ci.R;
import wow.startup.ci.databinding.FragmentFragLoginBinding;
import wow.startup.ci.databinding.FragmentFragRegisterBinding;
import wow.startup.ci.model.APIResponse;
import wow.startup.ci.model.RegisterBody;
import wow.startup.ci.network.APIService;
import wow.startup.ci.network.RectrofilClient;
import wow.startup.ci.viewModel.APIViewModel;


public class FragRegister extends Fragment {

    private FragmentFragRegisterBinding binding;

    private APIViewModel apiViewModel;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialiser notre viewModel
        apiViewModel = new ViewModelProvider(this).get(APIViewModel.class);
        apiViewModel.init(RectrofilClient.getInstance().create(APIService.class));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFragRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText fullnameField = (EditText) view.findViewById(R.id.fullname);
        Editable fullname = fullnameField.getText();

        EditText PhoneField = (EditText) view.findViewById(R.id.phone);
        Editable phone = fullnameField.getText();

        EditText passwordField = (EditText) view.findViewById(R.id.password);
        Editable password = fullnameField.getText();


        Button registerBtn = (Button) view.findViewById(R.id.login_Register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Fullname: ",fullname.toString());
                RegisterBody registerBody = new RegisterBody(
                        fullname.toString(),
                        phone.toString(),
                        password.toString()

                );
                apiViewModel.register(registerBody).observe(getViewLifecycleOwner(), new Observer<APIResponse>() {
                    @Override
                    public void onChanged(APIResponse apiResponse) {
                        Toast.makeText(getContext().getApplicationContext(),apiResponse.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.i("onChanged: " , apiResponse.isSuccess().toString());
                        if (apiResponse.isSuccess()){
                            Log.i("onChanged: " , apiResponse.isSuccess().toString());

                            NavController navController = Navigation.findNavController(view);
                            navController.navigate(R.id.action_fragRegister_to_fragLogin);

                        }
                        //Toast.makeText(getContext().getApplicationContext(),apiResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



//        binding.loginRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavController navController = Navigation.findNavController(view);
//                navController.navigate(R.id.action_fragRegister_to_fragLogin);
//            }
//
//
//        });

    }
}