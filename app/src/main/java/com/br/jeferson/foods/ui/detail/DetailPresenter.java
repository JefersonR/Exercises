package com.br.jeferson.foods.ui.detail;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.model.CommentModel;
import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.repository.LocationsRepositoryImpl;
import com.br.jeferson.foods.repository.api.LocationsRepository;
import com.br.jeferson.foods.ui.bases.main.fragment.BasePresenter;
import com.br.jeferson.foods.util.Consts;

import java.util.ArrayList;
import java.util.List;


public class DetailPresenter extends BasePresenter implements DetailContract.Presenter {

    private DetailContract.View mView;
    private ListLocation mItem;
    private LocationsRepositoryImpl locationRepositoryImpl;
    ;

    DetailPresenter(DetailContract.View view) {
        super(view);
        mView = view;
        locationRepositoryImpl = new LocationsRepositoryImpl();
    }

    @Override
    public void init() {
        if (getExtras() != null && getExtras().containsKey(Consts.EXTRA.ITEM))
            mItem = getExtras().getParcelable(Consts.EXTRA.ITEM);

        if (mItem != null) {
            locationRepositoryImpl.getLocationsByID(mItem.getId(), onResponse());
        }
    }

    private LocationsRepository.LocationsByIDCallBack onResponse() {
        return new LocationsRepository.LocationsByIDCallBack() {
            @Override
            public void onSuccess(LocationDetail response) {
                if (response != null) {
                    mView.fillData(response);
                    if (response.getSchedule() != null && !response.getSchedule().isEmpty()) {
                        mView.scheduleDays(getSchedule(response));
                    } else {
                        mView.scheduleDays("");
                    }
                    mView.getComments(getCommentsMock());
                    mView.getPhotos(getPhotosMock());

                }
            }

            @Override
            public void notifyError(ErrorResponse response) {
                mView.notifyError(response);
            }
        };
    }

    private String getSchedule(LocationDetail response) {
        final String DOM = "Dom", SEG = "Seg", TER = "Ter", QUA = "Qua", QUI = "Qui", SEX = "Sex", SAB = "Sab";
        List<List<ScheduleSimple>> schedules = new ArrayList<>();


        if (response.getSchedule().get(0).getSunday() != null) {
            List<ScheduleSimple> listInit = new ArrayList<>();
            schedules.add(listInit);
            listInit.add(new ScheduleSimple(DOM, response.getSchedule().get(0).getSunday().getOpen(), response.getSchedule().get(0).getSunday().getClose()));
        }
        if (response.getSchedule().get(0).getMonday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getMonday().getOpen(), response.getSchedule().get(0).getMonday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(SEG, response.getSchedule().get(0).getMonday().getOpen(), response.getSchedule().get(0).getMonday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(SEG, response.getSchedule().get(0).getMonday().getOpen(), response.getSchedule().get(0).getMonday().getClose()));
            }
        }

        if (response.getSchedule().get(0).getThursday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(TER, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(TER, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose()));

            }
        }


        if (response.getSchedule().get(0).getWednesday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getWednesday().getOpen(), response.getSchedule().get(0).getWednesday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(QUA, response.getSchedule().get(0).getWednesday().getOpen(), response.getSchedule().get(0).getWednesday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(QUA, response.getSchedule().get(0).getWednesday().getOpen(), response.getSchedule().get(0).getWednesday().getClose()));

            }
        }

        if (response.getSchedule().get(0).getThursday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(QUI, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(QUI, response.getSchedule().get(0).getThursday().getOpen(), response.getSchedule().get(0).getThursday().getClose()));
            }
        }

        if (response.getSchedule().get(0).getFriday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getFriday().getOpen(), response.getSchedule().get(0).getFriday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(SEX, response.getSchedule().get(0).getFriday().getOpen(), response.getSchedule().get(0).getFriday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(SEX, response.getSchedule().get(0).getFriday().getOpen(), response.getSchedule().get(0).getFriday().getClose()));
            }
        }

        if (response.getSchedule().get(0).getSaturday() != null) {
            boolean exists = false;
            for (List<ScheduleSimple> lists : schedules) {
                exists = verifyExists(lists, response.getSchedule().get(0).getSaturday().getOpen(), response.getSchedule().get(0).getSaturday().getClose());
                if (exists) {
                    lists.add(new ScheduleSimple(SAB, response.getSchedule().get(0).getSaturday().getOpen(), response.getSchedule().get(0).getSaturday().getClose()));
                    break;
                }
            }
            if (!exists) {
                List<ScheduleSimple> list = new ArrayList<>();
                schedules.add(list);
                list.add(new ScheduleSimple(SAB, response.getSchedule().get(0).getSaturday().getOpen(), response.getSchedule().get(0).getSaturday().getClose()));
            }
        }

        String schedulesFinal = "\n";

        for (List<ScheduleSimple> lists : schedules) {
            for (ScheduleSimple scheduleSimple : lists) {
                schedulesFinal += scheduleSimple.getName() + ", ";
            }
            if (schedulesFinal.length() > 2)
                schedulesFinal = schedulesFinal.substring(0, schedulesFinal.length() - 2);
            schedulesFinal += " : " + lists.get(0).getOpen() + " ás " + lists.get(0).getClose() + "\n";
        }

        return schedulesFinal;
    }

    private boolean verifyExists(List<ScheduleSimple> schedules, String open, String close) {
        for (ScheduleSimple scheduleSimple : schedules) {
            if (open.equals(scheduleSimple.getOpen()) && close.equals(scheduleSimple.getClose())) {
                return true;
            }
        }
        return false;
    }

    private class ScheduleSimple {
        private String name;
        private String open;
        private String close;

        ScheduleSimple(String name, String open, String close) {
            this.name = name;
            this.open = open;
            this.close = close;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }
    }

    @Override
    public ListLocation getmItem() {
        return mItem;
    }

    private List<CommentModel> getCommentsMock() {
        List<CommentModel> commentsMock = new ArrayList<>();
        commentsMock.add(new CommentModel("Fantástico!!", 5, "Tortas deliciosas. Os waffles também estavam muito bons. Equipe muito atenciosa. :)", "Tomás Montenegro, Belo Horizonte - MG"));
        commentsMock.add(new CommentModel("Café da manhã delicioso", 4, "Nós fomos para o brunch e estava realmente delicioso. Pães, ovos, café, sucos naturais. Não é muito barato mas vale a pena.", "Glória Ruiz, São João Del Rey - MG"));
        commentsMock.add(new CommentModel("Ótima comida", 4, "Comidas frescas e de boa qualidade. Pães e quitandas saindo do forno toda hora. Cafés especiais e ambiente agradável.", "Shirley Jones, Mountain View - CA"));
        return commentsMock;
    }

    private List<Integer> getPhotosMock() {
        List<Integer> photoMock = new ArrayList<>();
        photoMock.add(R.drawable.photo_1);
        photoMock.add(R.drawable.photo_2);
        photoMock.add(R.drawable.photo_3);
        photoMock.add(R.drawable.photo_4);
        photoMock.add(R.drawable.photo_5);
        return photoMock;
    }
}
