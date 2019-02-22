import java.util.*;


public class Controller {

    private String algebraicExpression; // алгебраическое выражение
    private ArrayList<String> postfix;
    private String result;


    public void runCalculate(String algebraicExpression){
        try {
            postfix = convertInfixToPostfix(algebraicExpression);
        }
        catch (Exception ex){
            result = "некорректно введены данные";
        }
        try {
            calculate(postfix);
        }
        catch (ArithmeticException ex){
            result = "деление на ноль";
        }
        catch (Exception ex){
            result = "некорректно введены данные";
        }
    }

    // перевод из инфиксной в постфиксную запись выражения
    private ArrayList<String> convertInfixToPostfix(String algebraicExpression){

        String arrayAlgebraicExpression[] = algebraicExpression.split("(?<=[-+*/()])|(?=[-+*/()])"); // массив строк выражения
        ArrayList<String>  postfixAlgebraicExpression = new ArrayList<>(); // постфиксная запись выражения
        Stack<String> conditionStack = new Stack<>(); // игрет роль стека
        int prexp, prstack; // prexp - приоритет знака операции с массива строк, prstack - приоритет знака операции на вершине стека
        for(int i = 0; i < arrayAlgebraicExpression.length; i++){
            switch (arrayAlgebraicExpression[i]){
                case "(":
                    conditionStack.push(arrayAlgebraicExpression[i]);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    prexp = priority(arrayAlgebraicExpression[i]);
                    while (true) {
                        if(conditionStack.empty() || conditionStack.peek().equals("(")) {
                            conditionStack.push(arrayAlgebraicExpression[i]);
                            break;
                        }
                        prstack = priority(conditionStack.peek());
                        if (compare(prexp, prstack)) {
                            conditionStack.push(arrayAlgebraicExpression[i]);
                            break;
                        }
                        else
                            postfixAlgebraicExpression.add(conditionStack.pop());
                    }
                    break;
                case ")":
                    while (!conditionStack.peek().equals("("))
                        postfixAlgebraicExpression.add(conditionStack.pop());
                    conditionStack.pop();
                    break;
                default:
                    postfixAlgebraicExpression.add(arrayAlgebraicExpression[i]);
                    break;
            }
        }
        while (!conditionStack.empty())
            postfixAlgebraicExpression.add(conditionStack.pop());
        return postfixAlgebraicExpression;
    }

    private void calculate(ArrayList<String> postfixAlgebraicExpression){
        Stack<Double> resultStack = new Stack<>();
        for(String elmn: postfixAlgebraicExpression){
            switch (elmn){
                case "+":
                    resultStack.push(resultStack.pop() + resultStack.pop());
                    break;
                case "-":
                    resultStack.push(- resultStack.pop() + resultStack.pop());
                    break;
                case "*":
                    resultStack.push(resultStack.pop() * resultStack.pop());
                    break;
                case "/":
                    double div = resultStack.pop();
                    if(div == 0.0)
                        throw new  ArithmeticException();
                    resultStack.push(resultStack.pop() / div);
                    break;
                default:
                    resultStack.push(Double.parseDouble(elmn));
            }
        }
        result = String.valueOf(resultStack.pop());
    }

    // сравнение приоритов
    // exp - приоритет знака операции текущего символа в выражении
    // st - приоритет знака операции на вершине стека
    private boolean compare(int exp, int st){
        if(st < exp)
            return true;
        else
            return false;
    }

    // определяется приоритет знака операции
    // prvar - знак операции
    private int priority(String prvar){
        int iprvar;
        switch (prvar){
            case "(":
            case ")":
                iprvar = 0;
                break;
            case "+":
            case "-":
                iprvar = 1;
                break;
            default:
                iprvar = 2;
                break;
        }
        return iprvar;
    }

    public String getResult() {
        return result;
    }
}
