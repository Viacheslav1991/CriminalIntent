package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;


public class PhotoPickerFragment extends DialogFragment {
    private static final String ARG_FILE_PATH = "path";


    ImageView mImageView;


    public static PhotoPickerFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FILE_PATH, path);

        PhotoPickerFragment fragment = new PhotoPickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String path = (String) getArguments().getSerializable(ARG_FILE_PATH);
        final Dialog dialog = new Dialog(getActivity());

        LayoutInflater layoutInflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout2 = layoutInflater.inflate(R.layout.dialog_larger_image, null);
        dialog.setContentView(layout2);

        mImageView = (ImageView) layout2.findViewById(R.id.larger_image);

        Bitmap myBitmap = BitmapFactory.decodeFile(path);
        mImageView.setImageBitmap(myBitmap);


        dialog.setTitle("Item Details");
        dialog.show();
        return dialog;
    }

}
