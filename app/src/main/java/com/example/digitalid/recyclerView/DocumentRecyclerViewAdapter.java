package com.example.digitalid.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digitalid.R;
import com.example.digitalid.entities.Document;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DocumentRecyclerViewAdapter extends RecyclerView.Adapter<DocumentViewHolder> {

    private List<Document> documents;
    private Context context;
    private OnDocumentListener onDocumentListener;

    public List<Document> getDocuments(){return documents;}

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View documentView = inflater.inflate(R.layout.recycler_item_view, parent, false);

        //Return a new holder instance.
        DocumentViewHolder documentViewHolder = new DocumentViewHolder(documentView, onDocumentListener);
        return documentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document document = documents.get(position);
        // call the method to set the values in the MonsterViewHolder
        holder.updateDocument(document);
        holder.bind(document, onDocumentListener);
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }


}
