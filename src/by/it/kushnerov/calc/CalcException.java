package by.it.kushnerov.calc;

public class CalcException extends Exception{

    public CalcException() {
        super();
        Logger.getLogger().log("ERROR");
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        Logger.getLogger().log(message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        Logger.getLogger().log(message+"cause: "+cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
        Logger.getLogger().log("cause: ");
    }
}
