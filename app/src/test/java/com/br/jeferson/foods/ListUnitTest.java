package com.br.jeferson.foods;

import com.br.jeferson.foods.repository.LocationsRepositoryImpl;
import com.br.jeferson.foods.repository.api.LocationsRepository;
import com.br.jeferson.foods.ui.list.ListContract;
import com.br.jeferson.foods.ui.list.ListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ListUnitTest {
    @Mock
    private ListContract.View mView;
    @Mock
    private LocationsRepositoryImpl tvShowRepositoryImpl;
    /**
     * {ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
/*    @Captor
    private ArrayList<TvShowItem> itens;*/

    private ListPresenter mListPresenter;

    @Captor
    private ArgumentCaptor<LocationsRepository.TvShowCallBack> mGetTVCallbackCaptor;

    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mListPresenter = new ListPresenter(mView);
    }

    @Test
    public void loadTvShows() {

    }
}