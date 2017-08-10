package finalProject;

import java.util.Stack;

public class RPNCalculator {


    static abstract class Node {
        Node lhs;
        Node rhs;

        public Node() {
            lhs = rhs = null;
        }

        public abstract int valueOf();

        public abstract String infixform();

        public abstract String rpnform();

    }

    static class OperandNode extends Node {

        String label;

        public OperandNode(String lbl) {
            super();
            label = lbl;
        }

        public int valueOf() {
            return Integer.valueOf(label);
        }

        public String infixform() {
            return label;
        }

        public String rpnform() {
            return label;
        }

    }

    static abstract class OperatorNode extends Node {
        private String label;

        public OperatorNode() {
            super();
        }
    }

    static class PlusNode extends OperatorNode {

        public PlusNode() {
            super();
        }

        public int valueOf() {
            return lhs.valueOf() + rhs.valueOf();
        }

        public String infixform() {
            return String.format("(%s + %s)", lhs.infixform(), rhs.infixform());
        }

        public String rpnform() {
            return String.format("%s %s +", lhs.rpnform(), rhs.rpnform());
        }

    }

    static class MinusNode extends OperatorNode {
        public MinusNode() {
            super();
        }

        public int valueOf() {
            return lhs.valueOf() - rhs.valueOf();
        }

         public String infixform() {
            return String.format("(%s - %s)", lhs.infixform(), rhs.infixform());
        }

        public String rpnform() {
            return String.format("%s %s -", lhs.rpnform(), rhs.rpnform());
        }

    }

    static class TimesNode extends OperatorNode {
        public TimesNode() {
            super();
        }

        public int valueOf() {
            return lhs.valueOf() * rhs.valueOf();
        }
        public String infixform() {
            return String.format("(%s * %s)", lhs.infixform(), rhs.infixform());
        }

        public String rpnform() {
            return String.format("%s %s *", lhs.rpnform(), rhs.rpnform());
        }
    }

    static class DivisionNode extends OperatorNode {
        public DivisionNode() {
            super();
        }

        public int valueOf() {
            return lhs.valueOf() / rhs.valueOf();
        }
        public String infixform() {
            return String.format("(%s / %s)", lhs.infixform(), rhs.infixform());
        }

        public String rpnform() {
            return String.format("%s %s /", lhs.rpnform(), rhs.rpnform());
        }
    }

    public static boolean isOperand(Object symbol) {
        if ((!"P".equals(symbol)) && (!"M".equals(symbol)) && (!"D".equals(symbol)) && (!"T".equals(symbol))) {
            return true;
        } else {
            return false;
        }
    }

    static private Node ExpTree(Stack S) {
        Node root = null;
        Node rhs;
        Node lhs;
        String obj;
        if (S.isEmpty()) {
            return null;
        } else {
            obj = S.pop().toString();
            if (isOperand(obj)) {
                return new OperandNode(obj);
            } else {
                rhs = ExpTree(S);
                lhs = ExpTree(S);
                switch (obj) {
                    case "P":
                        root = new PlusNode();
                        root.lhs = lhs;
                        root.rhs = rhs;
                        break;
                    case "M":
                        root = new MinusNode();
                        root.lhs = lhs;
                        root.rhs = rhs;
                        break;
                    case "T":
                        root = new TimesNode();
                        root.lhs = lhs;
                        root.rhs = rhs;
                        break;
                    case "D":
                        root = new DivisionNode();
                        root.lhs = lhs;
                        root.rhs = rhs;
                        break;
                }
                return root;
            }
        }
    }


    public static void main(String[] args) {
        if (args.length != 0) {
            Stack<String> S = new Stack<String>();
            for (String symbol : args) {
                S.push(symbol);
            }
            Node tree = ExpTree(S);
            System.out.println(tree.rpnform());
            System.out.println(tree.infixform());
            System.out.println(tree.valueOf());

        }


    }


}

