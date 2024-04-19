class Node {
    char data;
    Node left, right;

    public Node(char item) {
        data = item;
        left = right = null;
    }
}

class SyntaxTree {
    Node root;

    public SyntaxTree() {
        root = null;
    }

    private int evaluate(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return Character.getNumericValue(root.data);
        int leftValue = evaluate(root.left);
        int rightValue = evaluate(root.right);
        switch (root.data) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                if (rightValue == 0)
                    throw new ArithmeticException("Division by zero!");
                return leftValue / rightValue;
        }
        return 0;
    }

    public int evaluateExpression() {
        return evaluate(root);
    }
}
class Main {
    public static void main(String[] args) {
        SyntaxTree tree = new SyntaxTree();
        tree.root = new Node('*');
        tree.root.left = new Node('+');
        tree.root.left.left = new Node('5');
        tree.root.left.right = new Node('3');
        tree.root.right = new Node('4');
        int result = tree.evaluateExpression();
        System.out.println("Result: " + result);
    }
}
