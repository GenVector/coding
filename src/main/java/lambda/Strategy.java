package lambda;

@FunctionalInterface
interface Strategy {
    String approach(String s1,String s2);
}
interface StrategyThree {
    String approach(String s1,String s2,String s3);
}
