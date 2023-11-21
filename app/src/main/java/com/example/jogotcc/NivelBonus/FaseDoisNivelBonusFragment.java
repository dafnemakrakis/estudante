package com.example.jogotcc.NivelBonus;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.jogotcc.DoubleClickListener;
import com.example.jogotcc.R;

public class FaseDoisNivelBonusFragment extends Fragment {

    private VideoView videoView;
    private ImageButton playButton, pauseButton, audioButton;
    private ImageButton resposta1Button, resposta2Button;
    private ImageButton voltarFasesButton;
    private ImageButton sairButton;

    private boolean isAudioOn = true;

    private ImageView feedbackImageView;
    private GestureDetector gestureDetector;
    private static final int DURATION_FEEDBACK_IMAGE = 3000;

    private NavController navController;

    private String respostaCorreta = "Resposta A";

    public FaseDoisNivelBonusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase_dois_nivel_bonus, container, false);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        videoView = view.findViewById(R.id.videoView);
        playButton = view.findViewById(R.id.playButton);
        pauseButton = view.findViewById(R.id.pauseButton);
        audioButton = view.findViewById(R.id.audioButton);
        resposta1Button = view.findViewById(R.id.resposta1Button);
        resposta2Button = view.findViewById(R.id.resposta2Button);

        voltarFasesButton = view.findViewById(R.id.voltarFasesButton);
        sairButton = view.findViewById(R.id.sairButton);

        feedbackImageView = view.findViewById(R.id.feedbackImageView);

        gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                showFeedbackImage(true); // Exibe feedback correto
                return true;
            }
        });


        // Configurar a URI do vídeo
        Uri videoUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.doisbonus);
        videoView.setVideoURI(videoUri);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAudioOn) {
                    // Desligar o áudio
                    if (videoView.isPlaying()) {
                        videoView.pause(); // Pausa a reprodução
                    }
                } else {
                    // Ligar o áudio
                    if (!videoView.isPlaying()) {
                        videoView.start(); // Inicia a reprodução
                    }
                }
                isAudioOn = !isAudioOn; // Alternar entre ligado e desligado
            }
        });

        resposta1Button.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                verificarRespostaEExibirFeedback("Resposta A");
            }
        });

        resposta2Button.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                verificarRespostaEExibirFeedback("Resposta B");
            }
        });



        //botão de voltar
        voltarFasesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navegar de volta para a seleção de níveis
                navController.navigateUp();
            }
        });

        //botão de sair
        sairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_faseDoisNivelBonusFragment_to_fasesNivelBonusFragment
                );
            }
        });



        feedbackImageView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        return view;
    }


    private void showFeedbackImage(boolean isCorreto) {

        int feedbackImageResource = isCorreto ? R.drawable.certo : R.drawable.errado;

        feedbackImageView.setImageResource(feedbackImageResource);
        feedbackImageView.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> feedbackImageView.setVisibility(View.GONE), DURATION_FEEDBACK_IMAGE);
    }

    private void verificarRespostaEExibirFeedback(String respostaSelecionada) {
        boolean respostaCorreta = verificarResposta(respostaSelecionada);
        showFeedbackImage(respostaCorreta);
    }

    private boolean verificarResposta(String respostaSelecionada) {
        return respostaSelecionada.equals(respostaCorreta);
    }

}

