package com.duke.boot.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author: dengkun11
 * @date: 2022/11/17
 * @description: SpelExpressionParser
 */
public class SpelExpression {

    public static void main(String[] args) {
        SpelExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("10*5 + 8");
        Integer result = (Integer) expression.getValue();
        System.out.println("result:" + result);

    }
}
