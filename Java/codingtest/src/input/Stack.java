package input;

public class Stack implements DataStructure {

    @Override
    public void implementation() {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.pop();
        stack.push(8);

        while(!stack.empty()){
            System.out.println(stack.peek());
            System.out.println("pop 도 출력 ? :  " + stack.pop());
        }
    }
}
