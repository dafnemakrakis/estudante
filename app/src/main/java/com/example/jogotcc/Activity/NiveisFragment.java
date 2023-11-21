package com.example.jogotcc.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.jogotcc.R;

public class NiveisFragment extends Fragment {

    public NiveisFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_niveis_2, container, false);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        ImageButton btnFasesNivelUm = view.findViewById(R.id.btnFasesNivelUm);
        ImageButton btnFasesNivelDois = view.findViewById(R.id.btnFasesNivelDois);
        ImageButton btnFasesNivelTres = view.findViewById(R.id.btnFasesNivelTres);
        ImageButton btnFasesNivelBonus = view.findViewById(R.id.btnFasesNivelBonus);

        btnFasesNivelUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use o NavController para navegar para o FasesNivelUmFragment
                navController.navigate(R.id.action_navegar_para_fases_nivel_um);
            }
        });

        btnFasesNivelDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use o NavController para navegar para o FasesNivelUmFragment
                navController.navigate(R.id.action_navegar_para_fases_nivel_dois);
            }
        });

        btnFasesNivelTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use o NavController para navegar para o FasesNivelUmFragment
                navController.navigate(R.id.action_navegar_para_fases_nivel_tres);
            }
        });

        btnFasesNivelBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use o NavController para navegar para o FasesNivelUmFragment
                navController.navigate(R.id.action_navegar_para_fases_nivel_bonus);
            }
        });

        return view;
    }
}