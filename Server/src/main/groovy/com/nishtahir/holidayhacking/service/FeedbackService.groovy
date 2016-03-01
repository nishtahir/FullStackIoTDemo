package com.nishtahir.holidayhacking.service

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.table.TableUtils
import com.nishtahir.holidayhacking.Server
import com.nishtahir.holidayhacking.model.Feedback
import org.joda.time.DateTime

/**
 * Created by Nish on 12/13/15.
 */
class FeedbackService {
    Dao<Feedback, String> feedbackDao;

    FeedbackService(){
        feedbackDao = DaoManager.createDao(Server.connectionSource, Feedback.class)
    }

    void saveFeedback(String content) {
        Feedback feedback = new Feedback(content: content, date: new DateTime())
        feedbackDao.create(feedback)
    }
}
