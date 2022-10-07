package com.example.farmtofork.ui.cropinfo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.farmtofork.R;
import com.example.farmtofork.databinding.FragmentCropcalenderBinding;
import com.example.farmtofork.databinding.FragmentCropinfoBinding;
import com.example.farmtofork.ui.cropcalender.CropCalenderViewModel;

import java.util.Calendar;

public class CropInfo extends Fragment {
    Calendar cal = Calendar.getInstance();
    private FragmentCropinfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cropinfo, container, false);



        binding = FragmentCropinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        EditText cultdate=view.findViewById(R.id.infocultidate);
        cultdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });
        return root;
    }

    public void openDatePickerDialog(final View v) {
        // Get Current Date
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                (view, year, monthOfYear, dayOfMonth) -> {
                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    switch (v.getId()) {
                        case R.id.infocultidate:
                            ((EditText)v).setText(selectedDate);
                            break;
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));


        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}