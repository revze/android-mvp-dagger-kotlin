package id.revan.mvpwithdagger.ui.base

interface Presenter<T : View> {
    fun onAttach(view: T);

    fun onDetach();
}