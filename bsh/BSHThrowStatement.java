package bsh;

class BSHThrowStatement extends SimpleNode {
  BSHThrowStatement(int paramInt) { super(paramInt); }
  
  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter) {
    Object object = ((SimpleNode)jjtGetChild(0)).eval(paramCallStack, paramInterpreter);
    if (!(object instanceof Exception))
      throw new EvalError("Expression in 'throw' must be Exception type", this, paramCallStack); 
    throw new TargetError((Exception)object, this, paramCallStack);
  }
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\bsh\BSHThrowStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */