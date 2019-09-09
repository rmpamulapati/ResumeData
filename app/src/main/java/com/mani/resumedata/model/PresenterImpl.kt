package com.mani.resumedata.model

import android.support.annotation.NonNull
import com.mani.resumedata.network.ApiClient
import com.mani.resumedata.view_presenter.ViewPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException



class PresenterImplementation : ViewPresenter.MainPresenter {

    var mainView: ViewPresenter.MainView? = null

    var disposable: Disposable? = null

    /* getting a reference of view to update views*/
    constructor(mainView: ViewPresenter.MainView?) {
        this.mainView = mainView
    }

    /* pings api and subscribes to its response */

    override fun loadData() {
        mainView!!.showProgressbar()

        if (mainView!!.checkInternet()) {

            disposable = ApiClient.instance
                .fetchResumeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listResponse ->
                    mainView!!.hideProgressbar()
                    val responseCode = listResponse.code()
                    when (responseCode) {
                        200, 201, 202 -> { mainView!!.onSuccess(listResponse) }
                        401 -> { } // TODO -  handle errors
                        402 -> { }
                        500 -> { }
                        501 -> { }
                    }
                }, { error ->
                    mainView!!.hideProgressbar()
                    if (error is HttpException) {
                        val response = (error as HttpException).response()
                        when (response.code()) {
                            //Responce Code
                        }
                    } else {
                        //Handle Other Errors
                    }
                    mainView!!.onError(error)
                })
        } else {
            mainView!!.hideProgressbar()
            mainView!!.validateError()
        }
    }

    override fun onStop() {
        if (disposable != null) {
            disposable!!.dispose()
        }
    }
}