package com.example.ulugbek.myapplication.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ulugbek.myapplication.activities.BaseActivity;

/**
 * Created by Ulugbek on 12.02.2015.
 */
public class ProgressDialogFragment extends DialogFragment {

    private ProgressDialog nDialog;

    public ProgressDialogFragment(BaseActivity activity, String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("progress");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
    }

    void ProgressDialogFragment() {
        this.setCancelable(false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);


        nDialog = new ProgressDialog() //Here I get an error: The constructor ProgressDialog(PFragment) is undefined
        nDialog.setMessage("Loading..");
        nDialog.setTitle("Checking Network");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();
    }
}
