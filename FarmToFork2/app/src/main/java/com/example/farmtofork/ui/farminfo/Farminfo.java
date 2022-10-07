package com.example.farmtofork.ui.farminfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.farmtofork.databinding.FragmentFarminfoBinding;

public class Farminfo extends Fragment {

    private FragmentFarminfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FarminfoViewModel galleryViewModel =
                new ViewModelProvider(this).get(FarminfoViewModel.class);

        binding = FragmentFarminfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textGallery;
        // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}