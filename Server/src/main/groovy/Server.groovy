/*
 *
 * @author Nish, @date 11/15/15 7:33 PM
 */
import static spark.Spark.*;

class Server {

    static main(args) {
        get '/', { req, res -> Page.createPage(req.queryMap().toMap()) }
        get '/dispatch', { req, res -> Page.createPage(req.queryMap().toMap()) }

        get '/messages', { req, res -> Page.newestMessage.toString() }
    }

}
