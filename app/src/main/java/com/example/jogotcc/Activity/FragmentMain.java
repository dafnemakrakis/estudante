package com.example.jogotcc.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.jogotcc.R;

public class FragmentMain  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button playButton = view.findViewById(R.id.btnJogar);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use o NavController para navegar para o NiveisFragment
                navController.navigate(R.id.action_fragmentMain_to_niveisFragment);
            }
        });

        return view;
    }
}
