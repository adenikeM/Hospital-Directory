package omakHospital;

public class InvalidPatientIdException extends Throwable {
    public InvalidPatientIdException(String message) {
        super(message);
    }
}
