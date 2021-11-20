public class ActionService {

    public static String calculate(Number first, Number second, String action) throws Exception {

        int result;

        switch (action) {
            case "+":
                result = first.getValue() + second.getValue();
                break;
            case "-":
                if (first.getType() == NumberType.ROMAN){
                    if(first.getValue() < second.getValue()){
                        throw new Exception("Не может быть отрицательных значений!");
                    }
                }
                result = first.getValue() - second.getValue();
                break;
            case "*":
                result = first.getValue() * second.getValue();
                break;
            case "/":
                result = first.getValue() / second.getValue();
                break;
            default:
                throw new Exception("Не правильно введен символ операции, используйте только +, -, *, /");
        }

        if (first.getType() == NumberType.ROMAN) {
            return NumberService.toRomanNumber(result);
        } else return String.valueOf(result);
    }
}