package com.example.farmtofork.ui.Geolocation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.farmtofork.databinding.FragmentGeolocationBinding;
import com.example.farmtofork.ui.gallery.GalleryViewModel;

public class Geolocation extends Fragment {

    private FragmentGeolocationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GeolocationViewModel galleryViewModel =
                new ViewModelProvider(this).get(GeolocationViewModel.class);

        binding = FragmentGeolocationBinding.inflate(inflater, container, false);
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