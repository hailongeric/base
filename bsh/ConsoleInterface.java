package bsh;

import java.io.PrintStream;
import java.io.Reader;

public interface ConsoleInterface {
  void error(Object paramObject);
  
  PrintStream getErr();
  
  Reader getIn();
  
  PrintStream getOut();
  
  void print(Object paramObject);
  
  void println(Object paramObject);
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\bsh\ConsoleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */