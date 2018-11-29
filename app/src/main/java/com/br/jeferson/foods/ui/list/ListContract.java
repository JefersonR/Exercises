package com.br.jeferson.foods.ui.list;


import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;

import java.util.List;

public interface ListContract {

    interface View extends BaseContract.View {
        void locationsResponse(List<ListLocation> itens);

        void onEmptyListResponse();
    }

    interface Presenter extends BaseContract.Presenter {
        void getLocations();

    }

}
