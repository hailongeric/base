package bsh;

public interface NameSource {
  void addNameSourceListener(Listener paramListener);
  
  String[] getAllNames();
  
  public static interface Listener {
    void nameSourceChanged(NameSource param1NameSource);
  }
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\bsh\NameSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */