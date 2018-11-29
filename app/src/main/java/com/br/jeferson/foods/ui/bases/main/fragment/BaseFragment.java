package com.br.jeferson.foods.ui.bases.main.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.util.Consts;

import butterknife.ButterKnife;
import butterknife.Unbinder;



public abstract class BaseFragment extends Fragment implements BaseContract.View{

    private Unbinder unbinder;
    private BaseContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResourceView(), container, false);
        unbinder = ButterKnife.bind(this, view);

        setPresenter(mPresenter());
        if (presenter != null && savedInstanceState != null && savedInstanceState.containsKey(Consts.EXTRA.BUNDLE)) {
            presenter.init(savedInstanceState.getBundle(Consts.EXTRA.BUNDLE));
        } else if (presenter != null) {
            presenter.init(getArguments());
        }

        setupView();
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null && presenter.getExtras() != null) {
            outState.putBundle(Consts.EXTRA.BUNDLE, presenter.getExtras());
        }
    }

    protected abstract BaseContract.Presenter mPresenter();


    private void setPresenter(BaseContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Esconde o teclado
        if (getActivity() != null && getActivity().getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null && getView() != null) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getActivity() != null)
                    getActivity().onBackPressed();
                return true;
        }

        return false;
    }

    @Override
    public void notifyError(final ErrorResponse error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.str_error_msg)
                .setTitle(R.string.str_title_error);
        builder.setPositiveButton(R.string.str_retry, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                recall(error);
            }
        });
        builder.setNegativeButton(R.string.str_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @SuppressWarnings("unchecked")
    public void recall(final ErrorResponse error) {
        if (error != null)
            error.getCall().enqueue(error.getCallback());
    }
    /**
     * layout resource id
     *
     * @return
     */
    protected abstract @LayoutRes
    int getResourceView();

    /**
     * initialize views
     */
    protected abstract void setupView();


}
