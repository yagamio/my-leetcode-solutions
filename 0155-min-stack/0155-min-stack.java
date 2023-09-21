class MinStack {

    private List<Integer> list;
    private int min;
    private Map<Integer, Integer> lastMin;

    public MinStack() {
      list = new ArrayList<>();
      min = Integer.MAX_VALUE;
      lastMin = new HashMap<>();
    }
    
    public void push(int val) {
      list.add(val);
      lastMin.put(list.size(), min);
      min = Math.min(min, val);
    }
    
    public void pop() {
        min = lastMin.get(list.size());
        lastMin.remove(list.size());
        list.remove(list.size() - 1);
    }
    
    public int top() {
      return list.get(list.size() - 1);
    }
    
    public int getMin() {
      return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */