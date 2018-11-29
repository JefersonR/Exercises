package com.br.jeferson.foods.util;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


public class ActivityUtils {

    public ActivityUtils() {

    }

    /**
     * Methods below changes activities
     */
    public void replaceActivityShow(Context context, Class activity, Bundle bundle, boolean finish) {
        Intent intent = new Intent(context, activity);
        if (bundle != null)
            intent.putExtras(bundle);

        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        if (finish)
            ((Activity) context).finish();

    }

    public void replaceActivityNoAnimation(Context context, Class activity, Bundle bundle, boolean finish) {
        Intent intent = new Intent(context, activity);
        if (bundle != null)
            intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
        if (finish)
            ((Activity) context).finish();

    }

    public void replaceActivity(Context context, Intent intent) {
        replaceActivity(context, intent, false);
    }

    public void replaceActivity(Context context, Intent intent, boolean finish) {

        context.startActivity(intent);

        if (finish)
            ((Activity) context).finish();

    }


    public void replaceActivityForResult(Context context, Intent intent, int requestCode) {
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public void replaceActivityForResult(Context context, Class activity, int requestCode) {
        replaceActivityForResult(context, activity, requestCode, null);
    }

    public void replaceActivityForResult(Context context, Class activity, int requestCode, Bundle bundle) {
        Intent intent = new Intent(context, activity);

        if (bundle != null)
            intent.putExtras(bundle);

        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    /**
     * Methods below adds a fragment to an activity
     **/
    public void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId) {
        try {
            checkNotNull(fragmentManager);
            checkNotNull(fragment);

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Methods below adds a fragment to an activity
     **/
    public void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, tag);
        transaction.commit();
    }

    /**
     * Methods below replaces fragments on activities
     */
    public void replaceFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId) {
        replaceFragment(fragmentManager, fragment, frameId, true);
    }


    public void replaceFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId, boolean addToBackStack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getName());


        transaction.replace(frameId, fragment);
        transaction.commit();
    }


}

