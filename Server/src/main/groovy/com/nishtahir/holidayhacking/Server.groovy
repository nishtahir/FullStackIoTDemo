package com.nishtahir.holidayhacking

import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import com.nishtahir.holidayhacking.controller.DeviceController
import com.nishtahir.holidayhacking.controller.FeedbackController
import com.nishtahir.holidayhacking.model.Feedback
import com.nishtahir.holidayhacking.service.FeedbackService
import spark.Spark

class Server {

    static ConnectionSource connectionSource;

    public Server(args) {
        Spark.staticFileLocation("/public")
        initCli(args)
        initDb();

        new DeviceController().init()
        Spark.get '/', { req, res -> res.redirect("/index.html") }
        new FeedbackController(service: new FeedbackService()).init()
    }

    /**
     * Initialize command line
     * @param args arguments
     */
    void initCli(args) {
        def cli = new CliBuilder(usage: '[p]')
        cli.with {
            p longOpt: 'port', 'Run on selected port', args: 1
        }

        def options = cli.parse(args)

        if (options.p) {
            Spark.port(Integer.parseInt(options.p))
        }
    }

    /**
     * Initialize SQLite database
     */
    static void initDb() {
        Class.forName("org.sqlite.JDBC")
        connectionSource = new JdbcConnectionSource('jdbc:sqlite:holiday_hacking.sqlite')
        TableUtils.createTableIfNotExists(connectionSource, Feedback.class)

    }

    static void main(args) {
       new Server(args)
    }
}