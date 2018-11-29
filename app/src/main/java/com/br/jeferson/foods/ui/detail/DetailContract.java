package com.br.jeferson.foods.ui.detail;


import com.br.jeferson.foods.model.CommentModel;
import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;

import java.util.List;

public interface DetailContract {

    interface View extends BaseContract.View {

         void fillData(LocationDetail locationDetail);

         void scheduleDays(String schedule);

         void getComments(List<CommentModel> comments);

        void getPhotos(List<Integer> photosMock);
    }

    interface Presenter extends BaseContract.Presenter {
        ListLocation getmItem();
    }

}
