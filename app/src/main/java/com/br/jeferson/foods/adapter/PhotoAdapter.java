package com.br.jeferson.foods.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.br.jeferson.foods.R;

import java.util.ArrayList;
import java.util.List;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.CardChangesViewHolder> {
    private Context context;
    private List<Integer> cardViewListItems;

    public PhotoAdapter(List<Integer> palettes) {
        this.cardViewListItems = new ArrayList<Integer>();
        this.cardViewListItems.addAll(palettes);

    }

    @NonNull
    @Override
    public CardChangesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.photo_item, viewGroup, false);
        context = viewGroup.getContext();
        return new CardChangesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardChangesViewHolder holder, int i) {

        if (cardViewListItems.get(holder.getAdapterPosition()) != null) {

            final Integer mItem = cardViewListItems.get(holder.getAdapterPosition());
            try {
                if (mItem != 0)
                    holder.ivThumbnail.setImageDrawable(ContextCompat.getDrawable(context, mItem));
                
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @Override
    public int getItemCount() {
        if (cardViewListItems != null)
            return cardViewListItems.size();
        else return 0;

    }


    class CardChangesViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        
        private CardChangesViewHolder(View view) {
            super(view);
            ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);
        }

    }

}