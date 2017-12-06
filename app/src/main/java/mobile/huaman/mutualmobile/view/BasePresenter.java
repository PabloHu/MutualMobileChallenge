package mobile.huaman.mutualmobile.view;

/**
 * Created by Pablo on 11/28/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}
