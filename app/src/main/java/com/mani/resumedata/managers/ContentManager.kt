package com.mani.resumedata.managers

import com.mani.resumedata.beans.ResponseModel



class ContentManager {

    companion object {
        private var uniqeInstance: ContentManager? = null
    }

    var resumeData: ResponseModel? = null

    /* making the single instance of ContentManager available across the app */
    fun getInstance(): ContentManager {

        uniqeInstance?.let { return uniqeInstance!! }

        synchronized(ContentManager::class.java) {
            // check again to avoid multi-thread access
            if (uniqeInstance == null)
                uniqeInstance = ContentManager()
            return uniqeInstance!!
        }
    }

}