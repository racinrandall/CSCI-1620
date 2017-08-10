package finalProject;
import java.util.Stack;

public class RPNCalculator {

    abstract class Node {
        private Node lhs;
        private Node rhs;

        public Node() {
            lhs = rhs = null;
        }

        public abstract int valueOf();
        public abstract String stringValueOf();
    }

    class OperandNode extends Node(String lbl) {
        private String label;
        public OperandNode(String lbl) {
            super();
            label=lbl;
        }
        public int valueOf() {
            return Integer.valueOf(label);
        }
        public String stringValueOf() {
            return label;
        }
    }

    abstract class OperatorNode  extends Node {
        private String label;
        public OperatorNode(String lbl) {
            super();
            label = lbl;
        }
    }

    class PlusNode extends OperatorNode {
        public PlusNode (String label) {
            super(label);
        }
        public int valueOf() {
            return lhs.valueOf() + rhs.valueOf();
        }
        public String stringValueOf() {
            return lhs.stringValueOf() " + " rhs.stringValueOf();
        }
    }

    class ExpTree {
        private Node root;
        public ExpTree() {
            root = null;
        }
        public ExpTree(int val) {
            root = new OperandNode(val);
        }
    }





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
