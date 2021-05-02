package com.example.digitalid.recyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalid.R;
import com.example.digitalid.entities.Document;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class DocumentViewHolder extends ViewHolder {
    public final ImageView documentImageView;
    public final TextView documentNameTextView;
    public final TextView documentTypeTextView;
    private OnDocumentListener onDocumentListener;

    public DocumentViewHolder(@NonNull View itemView, OnDocumentListener onDocumentListener) {
        super(itemView);

        documentImageView = itemView.findViewById(R.id.documentImageView);
        documentNameTextView = itemView.findViewById(R.id.documentTextView);
        documentTypeTextView = itemView.findViewById(R.id.documentTypeTextView);

        this.onDocumentListener = onDocumentListener;
    }
    public void updateDocument(Document document){
        documentNameTextView.setText(document.getDocumentName());
        documentTypeTextView.setText(document.getDocumentType());

        documentImageView.setImageBitmap(StringToBitMap(document.getPhotoDocument()));
    }


    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }
    public void bind(final Document document, final OnDocumentListener onDocumentListener){
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("booo", "click using the interface");
                onDocumentListener.onDocumentClick(document);
            }
        });
        documentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(documentImageView.getRootView(), "Hi I'm a "+ document.getDocumentType() ,
                        Snackbar.LENGTH_LONG).show();
            }
        });

    }

}
