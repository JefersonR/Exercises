package com.br.jeferson.foods.ui.bases.main.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.util.Consts;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {

    private BaseContract.Presenter presenter;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (contentView() != 0) {
            setContentView(contentView());
        }
        setPresenter(mPresenter());
        if (presenter != null && savedInstanceState != null && savedInstanceState.containsKey(Consts.EXTRA.BUNDLE)) {
            presenter.init(savedInstanceState.getBundle(Consts.EXTRA.BUNDLE));
        } else if (presenter != null) {
            presenter.init(getIntent().getExtras());
        }
        configView();
    }

    protected abstract @LayoutRes
    int contentView();

    protected abstract BaseContract.Presenter mPresenter();

    protected abstract void configView();

    private void setPresenter(BaseContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateToolbar(Toolbar toolbar, TextView toolbarTitle, String title, boolean displayHomeAsUp) {
        setSupportActionBar(toolbar);
        toolbarTitle.setText(title != null ? title : "");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUp);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (presenter != null && presenter.getExtras() != null) {
            outState.putBundle(Consts.EXTRA.BUNDLE, presenter.getExtras());
        }
        super.onSaveInstanceState(outState);
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    public void setSavedInstanceState(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Esconde o teclado
        hideKeyboard();
    }

    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }


    @Override
    public void notifyError(final ErrorResponse error) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

}
