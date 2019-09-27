package com.luajava;

public interface LuaMetaTable {
  Object __call(Object... paramVarArgs);
  
  Object __index(String paramString);
  
  void __newIndex(String paramString, Object paramObject);
}


/* Location:              C:\Users\lenovo\Desktop\tool\dex2jar-2.0\classes-dex2jar.jar!\com\luajava\LuaMetaTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */