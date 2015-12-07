package com.nishtahir.holidayhacking;

/*
 *
 * @author Nish, @date 11/15/15 7:33 PM
 */
import static spark.Spark.*;

class Server {

    static main(args) {
        staticFileLocation("/public")

        get '/', { req, res -> res.redirect("/index.html") }
        get '/api', { req, res -> println req }
        // get '/dispatch', { req, res -> Page.createPage(req.queryMap().toMap()) }
        //
        // get '/messages', { req, res -> Page.newestMessage.toString() }
    }

}
