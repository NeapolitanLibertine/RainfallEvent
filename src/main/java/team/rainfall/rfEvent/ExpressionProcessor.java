package team.rainfall.rfEvent;


import aoc.kingdoms.lukasz.jakowski.Game_Calendar;
import com.udojava.evalex.Expression;
import team.rainfall.finality.FinalityLogger;

import java.math.BigDecimal;
import java.util.Objects;

public class ExpressionProcessor {
    public static void main(String[] args) {
        System.out.println(satisfied(0,"a$test - 1 > 0"));
    }

    public static int compute(int iCivID,String expStr){
        expStr = expStr.replaceAll("@turn", String.valueOf(Game_Calendar.TURN_ID));
        expStr = expStr.replace("$","a$");
        Expression expression = new Expression(expStr);
        for (String variable : expression.getUsedVariables()) {
            if(variable.startsWith("a$")){
                Counter counter = CounterBuilder.getCounterFromCiv(iCivID,variable.replace("a$","$"));
                if (counter != null) {
                    expression.setVariable(variable, BigDecimal.valueOf(counter.value));
                }else {
                    expression.setVariable(variable, BigDecimal.valueOf(0));
                }
            }
        }
        return expression.eval().intValue();
    }

    public static boolean satisfied(int iCivID,String expStr){
        expStr = expStr.replaceAll("@turn", String.valueOf(Game_Calendar.TURN_ID));
        expStr = expStr.replace("$","a$");
        Expression expression = new Expression(expStr);
        for (String variable : expression.getUsedVariables()) {
            if(variable.startsWith("a$")){
                FinalityLogger.debug("A$ counter "+variable);
                Counter counter = CounterBuilder.getCounterFromCiv(iCivID,variable.replace("a$",""));
                if (counter != null) {
                    FinalityLogger.debug("SAT2 "+counter.value);
                    expression.setVariable(variable, BigDecimal.valueOf(counter.value));
                }else {
                    FinalityLogger.debug("SAT3 ");
                    expression.setVariable(variable, BigDecimal.valueOf(0));
                }
            }
        }
        System.out.println("SAT "+expression.getExpression());
        return Objects.equals(expression.eval(), BigDecimal.ONE);
    }
}
