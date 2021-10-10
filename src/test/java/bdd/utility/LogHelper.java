package bdd.utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHelper    {

    static {
        System.setProperty("log.timestamp",
                new  SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
    }
    final static Logger log = Logger.getLogger(LogHelper.class);

    public static void main(String [] args)    {


    }

    public static void info(String s)    {

        log.info("[INFO:]"+s);
    }

    public static void warn(String s)    {

        log.warn("[WARN:]"+s);
    }

    public static void debug(String s)    {

        log.debug("[DEBUG:]"+s);
    }

    public static void fatal(String s)    {

        log.fatal("[FATAL:]"+s);
    }

    public static void error(String s)    {

        log.error("[ERROR:]"+s);
    }


}
