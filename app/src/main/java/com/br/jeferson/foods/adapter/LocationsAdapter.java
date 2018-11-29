package com.br.jeferson.foods.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.ui.detail.DetailFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.CardChangesViewHolder> {

    private Context context;
    private List<ListLocation> cardViewListItems;

    private OnItemClick onItemClick;

    public LocationsAdapter(List<ListLocation> palettes, OnItemClick onItemClick) {
        this.cardViewListItems = new ArrayList<ListLocation>();
        this.cardViewListItems.addAll(palettes);
        this.onItemClick = onItemClick;
        if (cardViewListItems != null)
            for (ListLocation local : cardViewListItems) {
                local.setColor(getRandomColor());
            }
    }

    @NonNull
    @Override
    public CardChangesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.list_item, viewGroup, false);
        context = viewGroup.getContext();
        return new CardChangesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardChangesViewHolder holder, int i) {

        if (cardViewListItems.get(holder.getAdapterPosition()) != null) {

            final ListLocation mItem = cardViewListItems.get(holder.getAdapterPosition());
            try {
                holder.thumbnailView.setBackgroundColor(ContextCompat.getColor(context, mItem.getColor()));
                holder.titleView.setText(mItem.getName());
                holder.subtitleView.setText(mItem.getType());
                holder.tvReview.setText(String.valueOf(mItem.getReview()));
                holder.ratingbarReview.setRating(mItem.getReview());

                holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClick.onItemClic(DetailFragment.newInstance(mItem));
                    }
                });


            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public interface OnItemClick {
        void onItemClic(Fragment fragment);
    }

    private @ColorRes
    int getRandomColor() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return R.color.colorYellowLight;

            case 1:
                return R.color.colorPinkLight;

            case 2:
                return R.color.colorAccent;

            default:
                return R.color.colorPrimary;
        }


    }

    @Override
    public int getItemCount() {
        if (cardViewListItems != null)
            return cardViewListItems.size();
        else return 0;

    }


    class CardChangesViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnailView;
        TextView titleView;
        TextView subtitleView;
        TextView tvReview;
        RatingBar ratingbarReview;
        CardView cardLayout;


        private CardChangesViewHolder(View view) {
            super(view);
            thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.tv_title);
            subtitleView = (TextView) view.findViewById(R.id.tv_subtitle);
            tvReview = (TextView) view.findViewById(R.id.tv_review);
            cardLayout = (CardView) view.findViewById(R.id.card_layout);
            ratingbarReview = (RatingBar) view.findViewById(R.id.ratingbar_review);
        }
    }

}