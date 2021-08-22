package lambda;

public class MoreParamLambda {

    public static void main(String[] args) {
        Strategy strategy = (s1, s2) -> {
            return "hello world" + s1 + s2;
        };
        System.out.println(strategy.approach("shiny", "marry"));
        StrategyThree strategyThree = (s1, s2, s3) -> s1 + s2 + s3;
    }
}
