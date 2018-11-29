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
import com.br.jeferson.foods.model.CommentModel;

import java.util.ArrayList;
import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CardChangesViewHolder> {
    private Context context;
    private List<CommentModel> cardViewListItems;

    public CommentAdapter(List<CommentModel> palettes) {
        this.cardViewListItems = new ArrayList<CommentModel>();
        this.cardViewListItems.addAll(palettes);

    }

    @NonNull
    @Override
    public CardChangesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.comment_item, viewGroup, false);
        context = viewGroup.getContext();
        return new CardChangesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardChangesViewHolder holder, int i) {

        if (cardViewListItems.get(holder.getAdapterPosition()) != null) {

            final CommentModel mItem = cardViewListItems.get(holder.getAdapterPosition());
            try {
                if (mItem.getPhoto() != 0)
                    holder.ivPhoto.setImageDrawable(ContextCompat.getDrawable(context, mItem.getPhoto()));
                holder.tvTitle.setText(mItem.getName());
                holder.tvComment.setText(mItem.getComment());
                holder.tvPlace.setText(mItem.getPlace());
                holder.ratingbarReview.setRating(mItem.getReview());

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
        ImageView ivPhoto;
        RatingBar ratingbarReview;
        TextView tvTitle;
        TextView tvComment;
        TextView tvPlace;

        private CardChangesViewHolder(View view) {
            super(view);
            ivPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            tvTitle = (TextView) view.findViewById(R.id.tv_name);
            tvComment = (TextView) view.findViewById(R.id.tv_comment);
            tvPlace = (TextView) view.findViewById(R.id.tv_place);
            ratingbarReview = (RatingBar) view.findViewById(R.id.ratingbar_review);
        }

    }

}