ArrayList<Integer> stack = new ArrayList<Integer>();
ArrayList<Integer> mins = new ArrayList<Integer>();

int[] minimumOnStack(String[] operations) {

    for(int i = 0; i<operations.length; i++) {
        switch(operations[i]) {
            case "pop": 
                popStack();
                break;
            case "min":
                minStack();
                break;
            default:
                pushStack(operations[i]);
                break;
        }
    }
    
    Integer [] result = mins.toArray(new Integer[mins.size()]);
    int [] resultInt = new int[result.length];
    
    for(int i = 0; i < result.length; i++) {
        resultInt[i] = result[i];
    }
    
    return resultInt;
}

void pushStack(String command) {
    String[] tokens = command.split(" ");
    stack.add(Integer.parseInt(tokens[1]));
}

void popStack() {
    stack.remove(stack.size()-1);
}

void minStack() {
    int minIndex = stack.indexOf(Collections.min(stack));
    mins.add(stack.get(minIndex));
}
