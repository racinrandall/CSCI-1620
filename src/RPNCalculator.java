import java.util.Stack;

public class RPNCalculator {




    public static void main(String[] args) {
        if (args.length != 0) {
            Stack S = new Stack();
            for (String symbol : args) {
                if ((!"P".equals(symbol)) && (!"M".equals(symbol)) && (!"D".equals(symbol)) && (!"T".equals(symbol))) {
                    S.push(symbol);
                } else {
                    int rhs = Integer.parseInt(S.pop().toString());
                    int lhs = Integer.parseInt(S.pop().toString());
                    switch (symbol) {
                        case "P":
                            S.push(lhs + rhs);
                            break;
                        case "M":
                            S.push(lhs - rhs);
                            break;
                        case "D":
                            S.push(lhs / rhs);
                            break;
                        case "T":
                            S.push(lhs * rhs);
                            break;
                    }
                }
            }
            System.out.println(S.pop());

        }


    }
}
