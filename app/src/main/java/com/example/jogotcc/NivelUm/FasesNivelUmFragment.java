package com.example.jogotcc.NivelUm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.jogotcc.R;

public class FasesNivelUmFragment extends Fragment {

    private NavController navController;

    public FasesNivelUmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fases_nivel_um, container, false);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Encontre o botão "Voltar para Níveis"
        ImageButton btnVoltarParaNiveis = view.findViewById(R.id.btnVoltarParaNiveis);

        // Configure um OnClickListener para o botão de voltar
        btnVoltarParaNiveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navegar de volta para a seleção de níveis
                navController.navigateUp();
            }
        });

        // Botão "Fase Um"
        ImageButton btnFaseUm = view.findViewById(R.id.btnFaseUm);

        btnFaseUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use o Navigation Component para navegar para o fragment da Fase Um
                navController.navigate(R.id.action_navegar_para_fase_um);
            }
        });

        // Botão "Fase Dois"
        ImageButton btnFaseDois = view.findViewById(R.id.btnFaseDois);

        btnFaseDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use o Navigation Component para navegar para o fragment da Fase Um
                navController.navigate(R.id.action_navegar_para_fase_dois);
            }
        });

        return view;
    }
}
