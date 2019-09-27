package bsh;

class BSHSwitchLabel extends SimpleNode {
  boolean a;
  
  public BSHSwitchLabel(int paramInt) { super(paramInt); }
  
  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter) { return this.a ? null : ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter); }
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\bsh\BSHSwitchLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */