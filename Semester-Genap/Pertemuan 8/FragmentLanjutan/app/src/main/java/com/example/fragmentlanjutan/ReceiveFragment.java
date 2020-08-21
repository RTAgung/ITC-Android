package com.example.fragmentlanjutan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
    Cara kirim data lewat fragment ada 2
    1. pakai Setter
    2. pakai Bundle Arguments
 */

public class ReceiveFragment extends Fragment {

    public static final String EXTRA_DATA = "extra_data";
    private String dataSetter;
    private String dataArgs;

    public void setDataSetter(String dataSetter) {
        this.dataSetter = dataSetter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            dataArgs = getArguments().getString(EXTRA_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvDataSetter = view.findViewById(R.id.tv_data_setter);
        TextView tvDataArgs = view.findViewById(R.id.tv_data_args);

        tvDataSetter.setText(dataSetter);
        tvDataArgs.setText(dataArgs);
    }
}