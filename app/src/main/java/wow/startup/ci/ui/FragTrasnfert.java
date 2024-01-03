package wow.startup.ci.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wow.startup.ci.R;
import wow.startup.ci.databinding.FragmentFragTrasnfertBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragTrasnfert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragTrasnfert extends Fragment {


    private FragmentFragTrasnfertBinding binding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFragTrasnfertBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.sendTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_fragTrasnfert_to_fragSucces);
            }
        });

    }
}