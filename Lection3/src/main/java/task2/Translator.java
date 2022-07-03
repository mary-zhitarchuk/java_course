package main.java.task2;

import java.util.Queue;
import java.util.Stack;

public class Translator {
    private String equation;
    private Stack<Character> stack;
    private static final char[] MAS_POSTFIX = {'!'};
    private static final char[] MAS_PREFIX = {'+','-','*','/'};
    private static final char[] MAS_NUMBERS = {'0','1','2','3','4','5','6','7','8','9'};
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private String result;

    public Translator(String equation) {
        this.equation = equation.replaceAll(" ","");
        this.result = "";
        this.stack = new Stack<>();
    }

    public void translate(){
        char [] masChar = equation.toCharArray();

        for(int i=0; i<masChar.length; i++) {
            if (isNumber(masChar[i])){
                result += masChar[i];
            }
            else if(isPrefix(masChar[i]))
            {
                result += " ";
                stack.push(masChar[i]);
                System.out.println("Стек: " + getStack());
            }
            else if (masChar[i] == OPEN_BRACKET){
                result += " ";
                stack.push(masChar[i]);
                System.out.println("Стек: " + getStack());
            }
            else if (masChar[i] == CLOSE_BRACKET){
                result += " ";
                while (stack.peek()!= OPEN_BRACKET){
                    result += stack.pop();
                }
                stack.pop();
            }
            else System.out.println("Error");
        }
        while (!stack.isEmpty())
            result += " " + stack.pop();
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Stack<Character> getStack() {
        return stack;
    }

    public void setStack(Stack<Character> stack) {
        this.stack = stack;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private boolean isPrefix(char c) {
        for (char m : MAS_PREFIX) {
            if (m == c)
                return true;
        }
        return false;
    }

    private boolean isNumber(char c){
        for (char m : MAS_NUMBERS){
            if(m == c)
                return true;
        }
        for (char m : MAS_POSTFIX) {
            if (m == c)
                return true;
        }
        return false;
    }

}
