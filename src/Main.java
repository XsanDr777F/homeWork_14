import Exception.WrongLoginException;
import Exception.WrongPasswordException;
public class Main {
    private static final String VALIDATE_PATTERN = "^[\\w{1,20}]+$";

    public static void main(String[] agrs) {
        check ("login","pass","pass");
        check ("login11111111111111111111111","pass","pass");
        check ("login","password","pass");
        check ("login@","pass","pass");
        check ("login","pass@","pass@");
    }
    private static boolean check (String login, String password, String confirmPassword) {
        boolean isCorrect = true;

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e){
            System.out.println("Ошибка с введеным логином: "+ e.getMessage());
            isCorrect = false;
        }catch (WrongPasswordException e) {
            System.out.println("Ошибка с введеным паролем: " + e.getMessage());
            isCorrect = false;
        }
        if (isCorrect){
            System.out.println("логин и пароль верные");
        }

        return isCorrect;
    }
    private static void checkLogin (String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин может состоять только из латинских букв, цифр и андерскора");
        } else if (login.length()>20) {
            throw new WrongLoginException("Логин не должен превышать 20 символов");

        }
    }
    private static void checkPassword (String password,String cofirmPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль может состоять только из латинских букв, цифр и андерскора");
        } else if (!password.equals(cofirmPassword)){
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }
}