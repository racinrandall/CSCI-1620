package finalProject;

import java.util.Stack;

public class RPNCalculator {
    String obj;

    abstract class Node {
        Node lhs;
        Node rhs;

        public Node() {
            lhs = rhs = null;
        }

        public abstract int valueOf();

    }

    class OperandNode extends Node {
        private String label;

        public OperandNode(String lbl) {
            super();
            label = lbl;
        }

        public int valueOf() {
            return Integer.valueOf(label);
        }

    }

    abstract class OperatorNode extends Node {
        private String label;
        public OperatorNode(String lbl) {
            super();
            label = lbl;
        }
    }

    class PlusNode extends OperatorNode {
        public PlusNode(String label) {
            super(label);
        }

        public int valueOf() {
            return lhs.valueOf() + rhs.valueOf();
        }

    }

    class MinusNode extends OperatorNode {
        public MinusNode(String label) {
            super(label);
        }

        public int valueOf() {
            return lhs.valueOf() - rhs.valueOf();
        }
    }

        class TimesNode extends OperatorNode {
            public TimesNode(String label) {
                super(label);
            }

            public int valueOf() {
                return lhs.valueOf() * rhs.valueOf();
            }

        }

    class DivisionNode extends OperatorNode {
        public DivisionNode(String label) {
            super(label);
        }

        public int valueOf() {
            return lhs.valueOf() / rhs.valueOf();
        }

    }
    public boolean isOperand(Object symbol) {
        if ((!"P".equals(symbol)) && (!"M".equals(symbol)) && (!"D".equals(symbol)) && (!"T".equals(symbol))) {
            return true;
        }
        else {
            return false;
        }
    }

    public Node ExpTree(Stack S) {
        Node root = null;
        Node rhs;
        Node lhs;
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
                        return new PlusNode(obj);
                    break;
                    case "M":
                        return new MinusNode(obj);
                    break;
                    case "T":
                        return new TimesNode(obj);
                    break;
                    case "D":
                        return new DivisionNode(obj);
                    break;
                }
                root.lhs = lhs;
                root.rhs = rhs;
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
            }


        }


    }
}
