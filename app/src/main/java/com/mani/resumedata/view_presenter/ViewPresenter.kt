package com.mani.resumedata.view_presenter

import com.mani.resumedata.beans.ResponseModel
import retrofit2.Response



interface ViewPresenter {

    interface MainView {

        fun validateError()
        fun showProgressbar()
        fun hideProgressbar()
        fun onSuccess(reposnseModel: Response<ResponseModel>)
        fun onError(throwable: Throwable)
        fun checkInternet(): Boolean
    }

    interface MainPresenter {
        fun loadData()
        fun onStop()
    }
}