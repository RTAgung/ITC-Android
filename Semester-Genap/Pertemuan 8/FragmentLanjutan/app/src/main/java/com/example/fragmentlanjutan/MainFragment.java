package com.example.fragmentlanjutan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText etDataSetter = view.findViewById(R.id.et_data_setter);
        final EditText etDataArgs = view.findViewById(R.id.et_data_args);
        Button btnSend = view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReceiveFragment receiveFragment = new ReceiveFragment();

                String dataSetter = etDataSetter.getText().toString();
                String dataArgs = etDataArgs.getText().toString();

                // cara setter
                receiveFragment.setDataSetter(dataSetter);

                // cara bundle arguments
                Bundle bundle = new Bundle();
                bundle.putString(ReceiveFragment.EXTRA_DATA, dataArgs);
                receiveFragment.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, receiveFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}