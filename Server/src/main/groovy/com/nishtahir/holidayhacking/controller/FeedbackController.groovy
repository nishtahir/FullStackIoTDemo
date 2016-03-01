package com.nishtahir.holidayhacking.controller

import com.nishtahir.holidayhacking.service.FeedbackService
import spark.Spark

/**
 * Created by Nish on 12/13/15.
 */
class FeedbackController implements IController{

    FeedbackService service;

    void init(){
        Spark.get '/feedback/:feedback', { req, res ->
            res.type("application/json");

            def feedback = req.params('feedback')
            service.saveFeedback(feedback);

            return "ok";
        }
    }
}
