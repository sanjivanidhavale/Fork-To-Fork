package com.example.farmtofork.ui.cropcalender;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.farmtofork.MainActivity;
import com.example.farmtofork.R;
import com.example.farmtofork.databinding.FragmentCropcalenderBinding;
import com.example.farmtofork.databinding.FragmentCropinfoBinding;
import com.example.farmtofork.databinding.FragmentFarminfoBinding;
import com.example.farmtofork.ui.cropinfo.CropInfoViewModel;
import com.example.farmtofork.ui.farminfo.FarminfoViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CropCalender extends Fragment {


    private FragmentCropcalenderBinding binding;
    final Calendar myCalendar =  Calendar.getInstance();
    EditText editText;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cropcalender, container, false);

        String [] values =
                {"Vegetables and Fruits","Tomato","Potato","Brinjal","Apple","Grapes","Mango","Chiku",};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_languages);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter1);
        return v;
       // CropInfoViewModel cropcalender =
        //        new ViewModelProvider(this).get(CropInfoViewModel.class);

        //binding = FragmentCropcalenderBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();


        //ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // final TextView textView = binding.textGallery;
        // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
       // return root;

        //editText=(EditText)container.findViewById(R.id.Birthday);
//        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int day) {
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH,month);
//                myCalendar.set(Calendar.DAY_OF_MONTH,day);
//                updateLabel();
//            }
//        };
//        editText.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onClick(View view) {
//
//                new DatePickerDialog(CropCalender,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//
//            }
//        });
//
   }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }
}