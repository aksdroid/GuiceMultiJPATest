package guice.multi.jpa.module;

import java.sql.SQLException;

public class Utils
{

    protected static String getErrorMessage(RuntimeException e)
    {
        Throwable throwable = e;
        while (throwable != null && !(throwable instanceof SQLException))
        {
            throwable = throwable.getCause();
        }
        if (throwable instanceof SQLException)
        {
            SQLException sqlex = (SQLException) throwable;
            String errorCode = sqlex.getMessage();
            return errorCode;
        }
        return "NONE";
    }

}
